pluginManagement {
    repositories {
        google {
            content {
                includeGroupByRegex("com\\.android.*")
                includeGroupByRegex("com\\.google.*")
                includeGroupByRegex("androidx.*")
            }
        }
        mavenCentral()
        gradlePluginPortal()
    }
}
dependencyResolutionManagement {
    repositoriesMode.set(RepositoriesMode.FAIL_ON_PROJECT_REPOS)
    repositories {
        google()
        mavenCentral()
    }
}

rootProject.name = "ScbGuiide"

include(":app")

include(":root-api")

include(":utils")
include(":uikit")

include(":status-api", ":status-impl")

include(":splash-api", ":splash-impl")

include(":catalog-root-api", ":catalog-root-impl")

include(":catalog-top-api", ":catalog-top-impl")
