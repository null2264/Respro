package lv.cebbys.mcmods.respro.component.core;

import lv.cebbys.mcmods.respro.component.resource.AbstractResource;
import lv.cebbys.mcmods.respro.component.resource.pack.ResproResourcePack;
import net.fabricmc.loader.api.FabricLoader;
import org.jetbrains.annotations.NotNull;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

import static lv.cebbys.mcmods.respro.constant.ResproConstants.RESPRO_PACK_ICON_LOCATION;
import static lv.cebbys.mcmods.respro.constant.ResproConstants.RESPRO_PACK_MCMETA_LOCATION;

public
class ResproPackDump
{
    private static final Logger LOGGER = LoggerFactory.getLogger(ResproPackDump.class);
    private static final Executor EXECUTOR = Executors.newSingleThreadExecutor();

    public
    void dump(ResproResourcePack<?, ?> resources) {
        EXECUTOR.execute(() -> dumpResources(resources));
    }

    private
    void dumpResources(ResproResourcePack<?, ?> resources) {
        try {
            File resproDump = makeDir(new File(FabricLoader.getInstance().getGameDir().toString() + "/respro"));
            File namespace = makeDir(new File(resproDump, resources.getId().getNamespace()));
            File pack = recreateDir(new File(namespace, resources.getId().getPath()));
            File data = makeDir(pack, "data");
            resources.getResources().forEach((location, resource) -> {
                if (RESPRO_PACK_ICON_LOCATION.equals(location) || RESPRO_PACK_MCMETA_LOCATION.equals(location)) {
                    dumpResource(makeFile(pack, location.getPath()), resource);
                    return;
                }
                File dataNamespace = makeDir(data, location.getNamespace());
                dumpResource(makeFile(dataNamespace, location.getPath()), resource);
            });
        } catch (Exception e) {
            LOGGER.error("Failed to dump respro pack", e);
        }
    }

    private
    void dumpResource(File file, AbstractResource resource) {
        try (FileOutputStream out = new FileOutputStream(file); InputStream in = resource.getAsStream()) {
            in.transferTo(out);
            out.flush();
        } catch (Exception e) {
            throw new RuntimeException(e.getClass().getName() + ": " + e.getMessage(), e.getCause());
        }
    }

    @SuppressWarnings("all")
    private @NotNull
    File makeDir(@NotNull File file) {
        if (file.exists() && !file.isDirectory()) file.delete();
        if (!file.exists()) file.mkdirs();
        return file;
    }

    private @NotNull
    File makeDir(@NotNull File parent, @NotNull String child) {
        return makeDir(new File(parent, child));
    }

    private @NotNull
    File recreateDir(@NotNull File file) {
        if (file.exists()) file.delete();
        return makeDir(file);
    }

    private @NotNull
    File makeFile(@NotNull File file) {
        makeDir(file.getParentFile());
        return file;
    }

    private @NotNull
    File makeFile(@NotNull File parent, @NotNull String child) {
        return makeFile(new File(parent, child));
    }
}