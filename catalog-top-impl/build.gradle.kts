plugins {
    id("feature-impl-config-plugin")
}

android {
    namespace = "com.spravochnic.scbguide.catalog_top_impl"

    buildFeatures {
        compose = true
    }
}

dependencies {
    implementation(project(":root-api"))
    implementation(project(":catalog-root-api"))
    implementation(project(":catalog-top-api"))
    implementation(project(":quest-api"))
    implementation(project(":lectory-api"))

    implementation(project(":uikit"))
    implementation(project(":utils"))
}