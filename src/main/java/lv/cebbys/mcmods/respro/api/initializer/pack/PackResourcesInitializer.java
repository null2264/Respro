package lv.cebbys.mcmods.respro.api.initializer.pack;

import lv.cebbys.mcmods.respro.api.initializer.core.PackProfileResourceInitializer;
import net.minecraft.util.Identifier;
import org.jetbrains.annotations.NotNull;

import java.util.function.Consumer;

@SuppressWarnings("all")
public
interface PackResourcesInitializer<T extends PackResourcesInitializer<?>> {
    @NotNull
    T setPackId(@NotNull Identifier id);

    @NotNull
    T setPackProfile(@NotNull Consumer<PackProfileResourceInitializer> consumer);

    @NotNull
    T setDumpMode(boolean enabledDump);

    @NotNull <I> T setResource(Class<I> builderClass, Identifier location, Consumer<I> consumer);
}