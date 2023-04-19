package lv.cebbys.mcmods.respro.api;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import lv.cebbys.mcmods.respro.api.initializer.pack.AssetsResourcesInitializer;
import lv.cebbys.mcmods.respro.api.initializer.pack.DataResourcesInitializer;
import lv.cebbys.mcmods.respro.api.supplier.AssetsProvider;
import lv.cebbys.mcmods.respro.api.supplier.DataProvider;
import lv.cebbys.mcmods.respro.component.core.PackProviders;
import lv.cebbys.mcmods.respro.component.resource.pack.ResproAssetsPack;
import lv.cebbys.mcmods.respro.component.resource.pack.ResproDataPack;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.registry.Registry;

import java.util.function.Consumer;

import static lv.cebbys.mcmods.respro.Respro.LOGGER;

@NoArgsConstructor(access = AccessLevel.PUBLIC)
public
class ResproRegistry
{
    public static
    void registerData(DataProvider provider) {
        LOGGER.info(provider.getId().toString());
        Registry.register(PackProviders.DATA_PROFILE_PROVIDER, provider.getId(), provider);
    }

    public static
    void registerData(Consumer<DataResourcesInitializer> builderConsumer) {
        ResproDataPack builder = new ResproDataPack();
        builderConsumer.accept(builder);
        builder.validate();
        builder.dump();
        registerData(builder.getProvider());
    }

    @Environment(EnvType.CLIENT)
    public static
    void registerAssets(AssetsProvider provider) {
        Registry.register(PackProviders.ASSETS_PROFILE_PROVIDER, provider.getId(), provider);
    }

    @Environment(EnvType.CLIENT)
    public static
    void registerAssets(Consumer<AssetsResourcesInitializer> builderConsumer) {
        ResproAssetsPack builder = new ResproAssetsPack();
        builderConsumer.accept(builder);
        builder.validate();
        builder.dump();
        registerAssets(builder.getProvider());
    }
}