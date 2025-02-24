plugins {
    id("feature-impl-config-plugin")
}

android {
    namespace = "com.spravochnic.scbguide.lectory_impl"

    buildFeatures {
        compose = true
    }
}

dependencies {
    implementation(project(":feature:root-api"))
    implementation(project(":feature:lectory-api"))

    implementation(project(":uikit"))
    implementation(project(":utils"))
}