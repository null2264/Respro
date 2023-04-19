package lv.cebbys.mcmods.respro.api.supplier;

import lv.cebbys.mcmods.respro.api.pack.Pack;
import net.minecraft.resource.ResourcePackProfile;
import net.minecraft.resource.ResourcePackProvider;
import net.minecraft.util.Identifier;
import org.jetbrains.annotations.NotNull;

import java.util.function.Consumer;

public
interface PackProvider<T extends Pack> extends ResourcePackProvider
{
    @NotNull
    Identifier getId();

    @NotNull
    T getPack();

    @Override
    default
    void register(Consumer<ResourcePackProfile> profileAdder) {
        profileAdder.accept(getPack());
    }
}