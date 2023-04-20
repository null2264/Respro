package lv.cebbys.mcmods.respro.component.mapper;

import lv.cebbys.mcmods.respro.component.resource.core.BinaryResource;

import java.util.List;

public abstract
class ResourceCollectionExtractor<T extends BinaryResource> extends ResourceCollector<T> {

    private ResourceCollectionExtractor(Class<T> clazz) {
        super(clazz);
    }

    public static <T extends BinaryResource> List<T> collect(ResourceCollector<T> collector) {
        return collector.resources;
    }
}