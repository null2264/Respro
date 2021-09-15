package lv.cebbys.mcmods.celib.respro.imp.resources;

import net.minecraft.resource.ResourceType;

import java.io.InputStream;

public abstract class Resource {
    protected abstract InputStream getAsStream();
    protected abstract boolean belongsTo(ResourceType type);
}