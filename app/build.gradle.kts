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

    implementation(project(":status-api"))
    implementation(project(":status-impl"))

    implementation(project(":splash-api"))
    implementation(project(":splash-impl"))

    implementation(project(":catalog-root-api"))
    implementation(project(":catalog-root-impl"))

    implementation(project(":catalog-top-api"))
    implementation(project(":catalog-top-impl"))

    implementation(project(":uikit"))
    implementation(project(":utils"))
}