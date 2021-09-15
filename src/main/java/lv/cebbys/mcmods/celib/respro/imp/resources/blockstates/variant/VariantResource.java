package lv.cebbys.mcmods.celib.respro.imp.resources.blockstates.variant;

import lv.cebbys.mcmods.celib.respro.imp.loggers.ResproLogger;
import lv.cebbys.mcmods.celib.respro.imp.parser.JsonPart;
import lv.cebbys.mcmods.celib.respro.imp.resources.JsonResource;
import net.minecraft.util.Identifier;

public class VariantResource extends JsonResource {
    @JsonPart(path = "model")
    protected String model;
    @JsonPart(path = "x")
    protected Integer x;
    @JsonPart(path = "y")
    protected Integer y;
    @JsonPart(path = "uvlock")
    protected Boolean uvlock;
    @JsonPart(path = "weight")
    protected Integer weight;

    public VariantResource model(String s) {
        if(model == null) {
            model = s;
        } else {
            ResproLogger.warn("Variant resource model has been already initialized. Tried to overwrite");
        }
        return this;
    }
    public VariantResource model(Identifier s) {
        return model(s.toString());
    }

    public VariantResource x(int s) {
        if(x == null) {
            x = s;
        } else {
            ResproLogger.warn("Variant resource x has been already initialized. Tried to overwrite");
        }
        return this;
    }

    public VariantResource y(int s) {
        if(y == null) {
            y = s;
        } else {
            ResproLogger.warn("Variant resource y has been already initialized. Tried to overwrite");
        }
        return this;
    }

    public VariantResource uvlock(boolean s) {
        if(uvlock == null) {
            uvlock = s;
        } else {
            ResproLogger.warn("Variant resource uvlock has been already initialized. Tried to overwrite");
        }
        return this;
    }

    public VariantResource weight(int s) {
        if(weight == null) {
            weight = s;
        } else {
            ResproLogger.warn("Variant resource weight has been already initialized. Tried to overwrite");
        }
        return this;
    }
}
