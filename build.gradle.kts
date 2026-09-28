plugins {
    id("dev.prism")
}

group = "com.leclowndu93150"
version = "1.1.0"

prism {
    metadata {
        modId = "illagerblabber"
        name = "IllagerBlabber"
        description = "Adds voice lines and dialogue to Illagers"
        license = "MIT"
        author("leclowndu93150")
    }

    version("1.20.1") {

        fabric {
            loaderVersion = "0.19.5"
            fabricApi("0.92.12+1.20.1")
            publishingDependencies {
                requires("fabric-api")
            }
        }
        forge {
            loaderVersion = "47.4.10"
        }
    }

    version("1.21.1") {

        fabric {
            loaderVersion = "0.19.5"
            fabricApi("0.116.17+1.21.1")
            publishingDependencies {
                requires("fabric-api")
            }
        }
        neoforge {
            loaderVersion = "21.1.252"
        }
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

    version("26.2") {

        fabric {
            loaderVersion = "0.19.5"
            fabricApi("0.161.0+26.2")
            publishingDependencies {
                requires("fabric-api")
            }
        }
        neoforge {
            loaderVersion = "26.2.0.88"
        }
    }

    version("26.3") {

        fabric {
            loaderVersion = "0.19.5"
            fabricApi("0.161.0+26.3")
            publishingDependencies {
                requires("fabric-api")
            }
        }
        neoforge {
            loaderVersion = "26.3.0.26-beta"
        }
    }

    publishing {
        type = STABLE
        changelogFile = "CHANGELOG.md"

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
