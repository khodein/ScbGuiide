plugins {
    id("feature-api-config-plugin")
}

android {
    namespace = "com.spravochnic.scbguide.catalog_top_api"
}

dependencies {
    implementation(project(":root-api"))

    implementation(project(":uikit"))
}