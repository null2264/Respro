package lv.cebbys.mcmods.respro.component.supplier;

import lv.cebbys.mcmods.respro.api.pack.Assets;
import lv.cebbys.mcmods.respro.api.pack.Data;
import lv.cebbys.mcmods.respro.api.supplier.AssetsProvider;
import lv.cebbys.mcmods.respro.api.supplier.DataProvider;
import lv.cebbys.mcmods.respro.component.resource.pack.ResproResourcePack;

import java.util.function.Function;
import java.util.function.Supplier;

public
class SimpleAssetsProvider extends SimplePackProvider<Assets> implements AssetsProvider
{
    public
    SimpleAssetsProvider(
            Supplier<ResproResourcePack<?, ?>> packResources, Function<ResproResourcePack<?, ?>, Assets> packCreator
    ) {
        super(packResources, packCreator);
    }
}