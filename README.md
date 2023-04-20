
<h1 align="center">
<img src="./res/icon/icon.png" width="128" height="128"/>
<br/>
Resource Provider
</h1>

<p align="center">
<strong>Resource Provider (Respro)</strong> is a <strong>fabric</strong> dynamic resource generation library for
Minecraft.
<br/>
Highly inspired by 
<a href="https://github.com/natanfudge/artifice">Artifice</a>
by <a href="https://github.com/natanfudge">@natanfudge</a> and
<a href="https://github.com/Devan-Kerman/ARRP">ARRP</a>
by <a href="https://github.com/Devan-Kerman">@Devan-Kerman</a>
</p>

## Usage

### Setup

Mod is published on maven repository. You can fetch it and
include it in your mod in following way:

```groovy
repositories {
    // For versions BEFORE 0.3.0
    maven {
        url = "https://prod-cebbys-repomanager.herokuapp.com"
    }
    // For versions AFTER 0.3.0
    // - using Jitpack
    maven {
        url = "https://jitpack.io"
    }
}

dependencies {
    // Example include with version template
    // BEFORE 0.3.0
    include "lv.cebbys.mcmods:respro:${version}"
    // AFTER 0.3.0
    // - using Jitpack
    include "com.github.null2264:Respro:${version}"
    
    // Example include of version 0.1.1
    include "lv.cebbys.mcmods:respro:0.1.1"
    // Example include of version 0.3.1
    // - using Jitpack
    include "com.github.null2264:Respro:0.3.1"
}
```

### Basic Example

```java
class ResproRegistrar
{
    // Call this somewhere, maybe your ModInitializer subclass (your mod's main entrypoint)
    public static void register() {
        ResproRegistry.registerData(data -> {
            data.setDumpMode(FabricLoader.getInstance().isDevelopmentEnvironment());
            data.setPackId(new Identifier("yourmod", "datapack"));
            data.setPackProfile(profile -> {
                profile.setAlwaysEnabled(true);
                profile.setPackName(name -> name.setText("Your Mod Datapack's Name"));
                profile.setPackIcon(icon -> icon.setFromResources(Mod.class, "assets/yourmod/icon.png"));
                profile.setPackMeta(meta -> {
                    meta.setDescription("Your Mod Datapack's Name");
                    meta.setFormat(ResourceType.CLIENT_RESOURCES.getPackVersion(SharedConstants.getGameVersion()));
                });
            });
            data.setWorldPreset(...);
        });
    }
}
```

For a real use-case example, you can check out the source code of my [SkyblockCreator](https://github.com/null2264/SkyblockCreator/tree/1.19.3) mod.

## License

This library is licensed under the [MIT License](./LICENSE)
