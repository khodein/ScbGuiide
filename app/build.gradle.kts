plugins {
    id("app-config-plugin")
}

android {
    namespace = "com.spravochnic.scbguide"

    defaultConfig {
        applicationId = "com.spravochnic.scbguide"
    }

    buildFeatures {
        compose = true
    }
}

dependencies {
    implementation(project(":root-api"))
    implementation(project(":utils"))
}