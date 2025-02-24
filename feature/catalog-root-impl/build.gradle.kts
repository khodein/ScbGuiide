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
    implementation(project(":feature:root-api"))
    implementation(project(":feature:catalog-root-api"))
    implementation(project(":feature:status-api"))

    implementation(project(":uikit"))
    implementation(project(":utils"))
}