package lv.cebbys.mcmods.respro.api.initializer.pack;

import lv.cebbys.mcmods.respro.api.initializer.blockstate.multipart.MultipartBlockstateResourceInitializer;
import lv.cebbys.mcmods.respro.api.initializer.blockstate.variant.VariantBlockstateResourceInitializer;
import net.minecraft.util.Identifier;
import org.jetbrains.annotations.NotNull;

import java.util.function.Consumer;

public
interface AssetsResourcesInitializer extends PackResourcesInitializer<AssetsResourcesInitializer> {
    @NotNull("DataResourcesInitializer is null")
    AssetsResourcesInitializer setVariantBlockstate(
            @NotNull("Identifier provided was null") Identifier id,
            @NotNull("VariantBlockstateResourceInitializer consumer was null") Consumer<VariantBlockstateResourceInitializer> consumer
    );

    @NotNull("DataResourcesInitializer is null")
    AssetsResourcesInitializer setMultipartBlockstate(
            @NotNull("Identifier provided was null") Identifier id,
            @NotNull("MultipartBlockstateResourceInitializer consumer was null") Consumer<MultipartBlockstateResourceInitializer> consumer
    );
}