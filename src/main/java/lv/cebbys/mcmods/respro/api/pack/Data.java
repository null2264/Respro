package lv.cebbys.mcmods.respro.api.pack;

import lv.cebbys.mcmods.respro.component.resource.pack.profile.PackProfileResource;
import net.minecraft.resource.ResourcePackProfile;
import net.minecraft.resource.ResourceType;
import net.minecraft.util.Identifier;
import org.jetbrains.annotations.NotNull;

public
class Data extends Pack {
    public Data(
            @NotNull Identifier packLocation,
            @NotNull PackProfileResource packProfile,
            @NotNull ResourcePackProfile.PackFactory supplier
    ) {
        super(
                packLocation,
                packProfile,
                supplier,
                ResourceType.SERVER_DATA
        );
    }
}