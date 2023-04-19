<h1 align="center">Resource Provider</h1>

<p align="center">
Resource Provider (Respro) is a <strong>fabric</strong> dynamic resource generation library for
minecraft highly inspired by 
<a href="https://github.com/natanfudge/artifice">Artifice</a>
by <a href="https://github.com/natanfudge">@natanfudge</a> and
<a href="https://github.com/Devan-Kerman/ARRP">ARRP</a>
by <a href="https://github.com/Devan-Kerman">@Devan-Kerman</a>
</p>

## API
Mod is published on maven repository. You can fetch it and
include it in your mod in following way:

```groovy
repositories {
    // For versions BEFORE 0.3.0
    maven {
        url = "https://prod-cebbys-repomanager.herokuapp.com"
    }
    // For versions AFTER 0.3.0
    maven {
        url = "https://maven.pkg.github.com/null2264/Respro"
    }
}

dependencies {
    // Example include with version template
    // BEFORE 0.3.0
    include "lv.cebbys.mcmods:respro:${version}"
    // AFTER 0.3.0
    include "lv.cebbys.mcmods:respro:${version}+${mc_version}"
    
    // Example include of version 0.1.1
    include "lv.cebbys.mcmods:respro:0.1.1"
    // Example include of version 0.3.0
    include "lv.cebbys.mcmods:respro:0.3.0+1.19.3"
}
```

## Guide
