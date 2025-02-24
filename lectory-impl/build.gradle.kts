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
    implementation(project(":root-api"))
    implementation(project(":lectory-api"))

    implementation(project(":uikit"))
    implementation(project(":utils"))
}