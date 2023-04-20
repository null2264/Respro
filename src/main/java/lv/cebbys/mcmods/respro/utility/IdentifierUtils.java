package lv.cebbys.mcmods.respro.utility;

import lv.cebbys.mcmods.respro.Respro;
import net.minecraft.util.Identifier;

public final
class IdentifierUtils
{
    public static
    Identifier of(String id) {
        return new Identifier(Respro.MODID, id);
    }

    public static
    Identifier prefix(Identifier id, String prefix) {
        return new Identifier(id.getNamespace(), prefix + id.getPath());
    }

    public static
    Identifier suffix(Identifier id, String suffix) {
        return new Identifier(id.getNamespace(), id.getPath() + suffix);
    }

    public static
    Identifier wrapped(String prefix, Identifier id, String suffix) {
        return new Identifier(id.getNamespace(), prefix + id.getPath() + suffix);
    }
}