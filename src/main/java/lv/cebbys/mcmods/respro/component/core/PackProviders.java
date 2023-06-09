package lv.cebbys.mcmods.respro.component.core;

import com.mojang.serialization.Lifecycle;
import lv.cebbys.mcmods.respro.api.pack.Assets;
import lv.cebbys.mcmods.respro.api.pack.Data;
import lv.cebbys.mcmods.respro.api.supplier.*;
import lv.cebbys.mcmods.respro.utility.IdentifierUtils;
import net.minecraft.registry.Registry;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.SimpleRegistry;
import net.minecraft.util.Identifier;
import org.jetbrains.annotations.NotNull;

import java.util.List;

public
class PackProviders {
    public static final Registry<DataProvider> DATA_PROFILE_PROVIDER;
    public static final PackListProvider<Data> RESPRO_DATA_PROVIDER;

    public static final Registry<AssetsProvider> ASSETS_PROFILE_PROVIDER;
    public static final PackListProvider<Assets> RESPRO_ASSETS_PROVIDER;

    static {
        DATA_PROFILE_PROVIDER = new SimpleRegistry<>(
                RegistryKey.ofRegistry(IdentifierUtils.of("data_profile_provider")),
                Lifecycle.stable(),
                false
        );
        RESPRO_DATA_PROVIDER = new DataListProvider() {
            private final Identifier id = IdentifierUtils.of("respro_data_provider");

            @Override
            public @NotNull
            Identifier getId() {
                return id;
            }

            @Override
            public @NotNull
            List<Data> getPacks() {
                return PackProviders.DATA_PROFILE_PROVIDER.stream().map(DataProvider::getPack).toList();
            }
        };

        ASSETS_PROFILE_PROVIDER = new SimpleRegistry<>(
                RegistryKey.ofRegistry(IdentifierUtils.of("assets_profile_provider")),
                Lifecycle.stable(),
                false
        );
        RESPRO_ASSETS_PROVIDER = new AssetsListProvider() {
            private final Identifier id = IdentifierUtils.of("respro_assets_provider");

            @Override
            public @NotNull
            Identifier getId() {
                return id;
            }

            @Override
            public @NotNull
            List<Assets> getPacks() {
                return PackProviders.ASSETS_PROFILE_PROVIDER.stream().map(AssetsProvider::getPack).toList();
            }
        };
    }
}