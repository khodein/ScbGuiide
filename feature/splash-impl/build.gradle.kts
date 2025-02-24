plugins {
    id("feature-impl-config-plugin")
}

android {
    namespace = "com.spravochnic.scbguide.splash_impl"

    buildFeatures {
        compose = true
    }
}

dependencies {
    implementation(project(":feature:root-api"))
    implementation(project(":feature:splash-api"))

    implementation(project(":uikit"))
    implementation(project(":utils"))
}