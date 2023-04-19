package lv.cebbys.mcmods.respro.api.pack;

import lv.cebbys.mcmods.respro.component.resource.pack.profile.PackProfileResource;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.resource.ResourcePackProfile;
import net.minecraft.resource.ResourceType;
import net.minecraft.util.Identifier;
import org.jetbrains.annotations.NotNull;

import static net.fabricmc.api.EnvType.CLIENT;

@Environment(CLIENT)
public
class Assets extends Pack
{
    public
    Assets(
            @NotNull Identifier packLocation,
            @NotNull PackProfileResource packProfile,
            @NotNull ResourcePackProfile.PackFactory supplier
    ) {
        super(
                packLocation,
                packProfile,
                supplier,
                ResourceType.CLIENT_RESOURCES
        );
    }
}