plugins {
    id("feature-api-config-plugin")
}

android {
    namespace = "com.spravochnic.scbguide.catalog_root_api"
}

dependencies {
    implementation(project(":root-api"))

    implementation(project(":uikit"))
}