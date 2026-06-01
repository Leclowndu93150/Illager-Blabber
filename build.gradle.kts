plugins {
    id("dev.prism")
}

group = "com.leclowndu93150"
version = "1.0.1"

prism {
    metadata {
        modId = "illagerblabber"
        name = "IllagerBlabber"
        description = "Adds voice lines and dialogue to Illagers"
        license = "MIT"
        author("leclowndu93150")
    }

    version("1.21.11") {

        fabric {
            loaderVersion = "0.19.2"
            fabricApi("0.141.4+1.21.11")
            publishingDependencies {
                requires("fabric-api")
            }
        }
        neoforge {
            loaderVersion = "21.11.42"
        }
    }

    version("26.1.2") {

        fabric {
            loaderVersion = "0.19.2"
            fabricApi("0.150.0+26.1.2")
            publishingDependencies {
                requires("fabric-api")
            }
        }
        neoforge {
            loaderVersion = "26.1.2.68-beta"
        }
    }

    publishing {
        type = STABLE
        changelog = "Multi-version release for Minecraft 1.21.11 and 26.1.2 (Fabric + NeoForge)."

        curseforge {
            accessToken = providers.environmentVariable("CURSEFORGE_TOKEN")
            projectId = "1262825"
        }
        modrinth {
            accessToken = providers.environmentVariable("MODRINTH_TOKEN")
            projectId = "WS4FswTq"
        }
    }
}
