package lv.cebbys.mcmods.respro.component.resource.pack.profile;

import lv.cebbys.mcmods.respro.api.initializer.core.ImageResourceInitializer;
import lv.cebbys.mcmods.respro.api.initializer.core.MetaResourceInitializer;
import lv.cebbys.mcmods.respro.api.initializer.core.PackProfileResourceInitializer;
import lv.cebbys.mcmods.respro.api.initializer.core.StringResourceInitializer;
import lv.cebbys.mcmods.respro.component.resource.AbstractResource;
import lv.cebbys.mcmods.respro.component.resource.core.ImageResource;
import lv.cebbys.mcmods.respro.component.resource.core.MetaResource;
import lv.cebbys.mcmods.respro.component.resource.core.StringResource;
import lv.cebbys.mcmods.respro.constant.ResproConstants;
import lv.cebbys.mcmods.respro.exception.ResourceValidationException;
import net.minecraft.SharedConstants;
import net.minecraft.resource.ResourcePackProfile;
import net.minecraft.resource.ResourceType;
import org.jetbrains.annotations.NotNull;

import java.io.InputStream;
import java.util.function.Consumer;

public
class PackProfileResource extends AbstractResource implements PackProfileResourceInitializer {
    private final ImageResource icon;
    private final StringResource name;
    private final StringResource source;
    private final MetaResource meta;
    private ResourcePackProfile.InsertionPosition position;
    private boolean alwaysEnabled;
    private boolean pinned;

    public PackProfileResource() {
        icon = new ImageResource();
        name = new StringResource();
        source = new StringResource(ResproConstants.PACK_SOURCE_STRING_RESPRO);
        meta = new MetaResource(
                "Respro Generated Pack",
                ResourceType.CLIENT_RESOURCES.getPackVersion(SharedConstants.getGameVersion())
        );
        position = ResourcePackProfile.InsertionPosition.TOP;
        alwaysEnabled = false;
        pinned = false;
    }

    @Override
    public void validate() throws ResourceValidationException {
        if (icon == null) throw new ResourceValidationException("Pack icon resource is null");
        try {
            icon.validate();
        } catch (Exception e) {
            throw new ResourceValidationException("Pack icon resource validation exception. " + e.getMessage(), e);
        }
        if (name == null) throw new ResourceValidationException("Pack name resource is null");
        try {
            name.validate();
        } catch (Exception e) {
            throw new ResourceValidationException("Pack name resource validation exception. " + e.getMessage(), e);
        }
        if (source == null) throw new ResourceValidationException("Pack source resource is null");
        try {
            source.validate();
        } catch (Exception e) {
            throw new ResourceValidationException("Pack source resource validation exception. " + e.getMessage(), e);
        }
        if (meta == null) throw new ResourceValidationException("Pack meta resource is null");
        try {
            meta.validate();
        } catch (Exception e) {
            throw new ResourceValidationException("Pack meta resource validation exception. " + e.getMessage(), e);
        }
        if (position == null) throw new ResourceValidationException("Pack position is null");
    }

    @Override
    public @NotNull
    PackProfileResourceInitializer setPackIcon(@NotNull Consumer<ImageResourceInitializer> consumer) {
        consumer.accept(icon);
        return this;
    }

    @Override
    public @NotNull
    PackProfileResourceInitializer setPackName(@NotNull Consumer<StringResourceInitializer> consumer) {
        consumer.accept(name);
        return this;
    }

    @Override
    public @NotNull
    PackProfileResourceInitializer setPackSource(@NotNull Consumer<StringResourceInitializer> consumer) {
        consumer.accept(source);
        return this;
    }

    @Override
    public @NotNull
    PackProfileResourceInitializer setPackMeta(@NotNull Consumer<MetaResourceInitializer> consumer) {
        consumer.accept(meta);
        return this;
    }

    @Override
    public @NotNull
    PackProfileResourceInitializer setPackInsertionPosition(
            @NotNull ResourcePackProfile.InsertionPosition insertionPosition
    ) {
        position = insertionPosition;
        return this;
    }

    @Override
    public @NotNull
    PackProfileResourceInitializer setAlwaysEnabled(boolean packAlwaysEnabled) {
        alwaysEnabled = packAlwaysEnabled;
        return this;
    }

    @Override
    public @NotNull
    PackProfileResourceInitializer setPinned(boolean packPinned) {
        pinned = packPinned;
        return this;
    }

    @Override
    public @NotNull
    InputStream getAsStream() {
        return InputStream.nullInputStream();
    }

    @Override
    public boolean belongsTo(@NotNull ResourceType type) {
        return true;
    }

    public boolean isAlwaysEnabled() {
        return alwaysEnabled;
    }

    public StringResource getName() {
        return name;
    }

    public MetaResource getMeta() {
        return meta;
    }

    public ResourcePackProfile.InsertionPosition getPosition() {
        return position;
    }

    public boolean isPinned() {
        return pinned;
    }

    public StringResource getSource() {
        return source;
    }

    public ImageResource getIcon() {
        return icon;
    }
}