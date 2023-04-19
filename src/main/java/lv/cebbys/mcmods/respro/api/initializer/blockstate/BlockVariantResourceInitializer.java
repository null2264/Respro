package lv.cebbys.mcmods.respro.api.initializer.blockstate;

import net.minecraft.util.Identifier;
import org.jetbrains.annotations.NotNull;

public
interface BlockVariantResourceInitializer
{
    @NotNull
    BlockVariantResourceInitializer setModel(@NotNull String model);

    @NotNull
    BlockVariantResourceInitializer setModel(@NotNull Identifier model);

    @NotNull
    BlockVariantResourceInitializer setX(int value);

    @NotNull
    BlockVariantResourceInitializer setY(int value);

    @NotNull
    BlockVariantResourceInitializer setUVLock(boolean uvlock);

    @NotNull
    BlockVariantResourceInitializer setWeight(int value);
}