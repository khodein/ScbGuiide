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
    implementation(project(":root-api"))
    implementation(project(":splash-api"))

    implementation(project(":uikit"))
    implementation(project(":utils"))
}