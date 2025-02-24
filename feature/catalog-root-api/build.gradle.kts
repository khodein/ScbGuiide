plugins {
    id("feature-api-config-plugin")
}

android {
    namespace = "com.spravochnic.scbguide.catalog_root_api"
}

dependencies {
    implementation(project(":feature:root-api"))

    implementation(project(":uikit"))
}