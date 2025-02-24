plugins {
    id("feature-api-config-plugin")
}

android {
    namespace = "com.spravochnic.scbguide.catalog_top_api"
}

dependencies {
    implementation(project(":feature:root-api"))
    implementation(project(":feature:quest-api"))
    implementation(project(":feature:lectory-api"))

    implementation(project(":uikit"))
}