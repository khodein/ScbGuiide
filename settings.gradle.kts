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

include(":utils")
include(":uikit")

include(":feature:root-api")

include(
    ":feature:status-api",
    ":feature:status-impl"
)

include(
    ":feature:splash-api",
    ":feature:splash-impl"
)

include(
    ":feature:catalog-root-api",
    ":feature:catalog-root-impl"
)

include(
    ":feature:catalog-top-api",
    ":feature:catalog-top-impl"
)

include(
    ":feature:lectory-api",
    ":feature:lectory-impl"
)

include(
    ":feature:quest-api",
    ":feature:quest-impl"
)
