plugins {
    id("feature-impl-config-plugin")
}

android {
    namespace = "com.spravochnic.scbguide.catalog_root_impl"

    buildFeatures {
        compose = true
    }
}

dependencies {
    implementation(project(":root-api"))
    implementation(project(":catalog-root-api"))
    implementation(project(":status-api"))

    implementation(project(":uikit"))
    implementation(project(":utils"))
}