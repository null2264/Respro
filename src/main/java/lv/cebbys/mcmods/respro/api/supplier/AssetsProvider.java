package lv.cebbys.mcmods.respro.api.supplier;

import lv.cebbys.mcmods.respro.api.pack.Assets;
import net.fabricmc.api.Environment;

import static net.fabricmc.api.EnvType.CLIENT;

@Environment(CLIENT)
public
interface AssetsProvider extends PackProvider<Assets>
{}