plugins {
    id("feature-impl-config-plugin")
}

android {
    namespace = "com.spravochnic.scbguide.quest_impl"

    buildFeatures {
        compose = true
    }
}

dependencies {
    implementation(project(":root-api"))
    implementation(project(":quest-api"))

    implementation(project(":uikit"))
    implementation(project(":utils"))
}