package lv.cebbys.mcmods.respro.component.supplier;

import lv.cebbys.mcmods.respro.api.pack.Pack;
import lv.cebbys.mcmods.respro.component.resource.pack.ResproResourcePack;
import lv.cebbys.mcmods.respro.utility.IdentifierUtils;
import net.minecraft.util.Identifier;
import org.jetbrains.annotations.NotNull;

import java.util.function.Function;
import java.util.function.Supplier;

public
class SimplePackProvider<T extends Pack> {
    private final Supplier<ResproResourcePack<?, ?>> packResources;
    private final Function<ResproResourcePack<?, ?>, T> packCreator;

    public SimplePackProvider(
            Supplier<ResproResourcePack<?, ?>> packResources, Function<ResproResourcePack<?, ?>, T> packCreator
    ) {
        this.packResources = packResources;
        this.packCreator = packCreator;
    }

    public @NotNull
    Identifier getId() {
        return IdentifierUtils.suffix(packResources.get().getId(), "_supplier");
    }

    public @NotNull
    T getPack() {
        return packCreator.apply(packResources.get());
    }
}