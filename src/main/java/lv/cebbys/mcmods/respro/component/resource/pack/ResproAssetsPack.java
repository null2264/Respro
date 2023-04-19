package lv.cebbys.mcmods.respro.component.resource.pack;

import lv.cebbys.mcmods.respro.api.initializer.blockstate.multipart.MultipartBlockstateResourceInitializer;
import lv.cebbys.mcmods.respro.api.initializer.blockstate.variant.VariantBlockstateResourceInitializer;
import lv.cebbys.mcmods.respro.api.initializer.pack.AssetsResourcesInitializer;
import lv.cebbys.mcmods.respro.api.pack.Assets;
import lv.cebbys.mcmods.respro.api.supplier.AssetsProvider;
import lv.cebbys.mcmods.respro.component.supplier.SimpleAssetsProvider;
import lv.cebbys.mcmods.respro.utility.IdentifierUtils;
import net.fabricmc.api.Environment;
import net.minecraft.util.Identifier;
import org.jetbrains.annotations.NotNull;

import java.util.function.Consumer;

import static net.fabricmc.api.EnvType.CLIENT;

@Environment(CLIENT)
public
class ResproAssetsPack extends ResproResourcePack<ResproAssetsPack, AssetsProvider> implements AssetsResourcesInitializer
{
    @Override
    public
    AssetsProvider getProvider() {
        return new SimpleAssetsProvider(
                this::getInstance,
                (resources) -> new Assets(resources.getId(), resources.getProfile(), ignored -> resources)
        );
    }

    @Override
    protected
    ResproAssetsPack getInstance() {
        return this;
    }

    @Override
    public @NotNull("DataResourcesInitializer is null")
    AssetsResourcesInitializer setVariantBlockstate(
            @NotNull("Identifier provided was null") Identifier id,
            @NotNull("VariantBlockstateResourceInitializer consumer was null") Consumer<VariantBlockstateResourceInitializer> consumer
    ) {
        return setResource(
                VariantBlockstateResourceInitializer.class,
                IdentifierUtils.wrapped("blockstates/", id, ".json"),
                consumer
        );
    }

    @Override
    public @NotNull("DataResourcesInitializer is null")
    AssetsResourcesInitializer setMultipartBlockstate(
            @NotNull("Identifier provided was null") Identifier id,
            @NotNull("MultipartBlockstateResourceInitializer consumer was null") Consumer<MultipartBlockstateResourceInitializer> consumer
    ) {
        return setResource(
                MultipartBlockstateResourceInitializer.class,
                IdentifierUtils.wrapped("blockstates/", id, ".json"),
                consumer
        );
    }

    @Override
    public @NotNull
    AssetsResourcesInitializer setDumpMode(boolean enabledDump) {
        return this.setEnabledDumpMode(enabledDump);
    }
}