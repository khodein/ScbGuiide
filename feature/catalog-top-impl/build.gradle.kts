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
    implementation(project(":feature:root-api"))
    implementation(project(":feature:catalog-root-api"))
    implementation(project(":feature:catalog-top-api"))
    implementation(project(":feature:quest-api"))
    implementation(project(":feature:lectory-api"))

    implementation(project(":uikit"))
    implementation(project(":utils"))
}