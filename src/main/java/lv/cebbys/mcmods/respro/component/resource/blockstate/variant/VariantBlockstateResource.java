package lv.cebbys.mcmods.respro.component.resource.blockstate.variant;

import lombok.Getter;
import lv.cebbys.mcmods.respro.api.initializer.blockstate.BlockVariantResourceInitializer;
import lv.cebbys.mcmods.respro.api.initializer.blockstate.variant.VariantBlockPropertyResourceInitializer;
import lv.cebbys.mcmods.respro.api.initializer.blockstate.variant.VariantBlockstateResourceInitializer;
import lv.cebbys.mcmods.respro.component.mapper.JsonPart;
import lv.cebbys.mcmods.respro.component.resource.AbstractJsonObjectResource;
import lv.cebbys.mcmods.respro.component.resource.blockstate.BlockVariantResource;
import lv.cebbys.mcmods.respro.exception.ResourceValidationException;
import net.minecraft.resource.ResourceType;
import org.jetbrains.annotations.NotNull;

import java.util.HashMap;
import java.util.Map;
import java.util.function.Consumer;

@Getter
public final
class VariantBlockstateResource extends AbstractJsonObjectResource implements VariantBlockstateResourceInitializer
{
    @JsonPart("variants")
    private final Map<String, BlockVariantResource> variants = new HashMap<>();

    @Override
    public @NotNull
    VariantBlockstateResourceInitializer setVariant(
            @NotNull Consumer<VariantBlockPropertyResourceInitializer> propertyConsumer,
            @NotNull Consumer<BlockVariantResourceInitializer> variantConsumer
    ) {
        VariantBlockPropertyResource properties = new VariantBlockPropertyResource();
        propertyConsumer.accept(properties);
        lv.cebbys.mcmods.respro.component.resource.blockstate.BlockVariantResource variant = new lv.cebbys.mcmods.respro.component.resource.blockstate.BlockVariantResource();
        variantConsumer.accept(variant);
        variants.put(properties.getAsString(), variant);
        return this;
    }

    @Override
    public boolean belongsTo(@NotNull("Provided ResourceType is null") ResourceType type) {
        return ResourceType.CLIENT_RESOURCES.equals(type);
    }

    @Override
    public void validate() throws ResourceValidationException {

    }
}