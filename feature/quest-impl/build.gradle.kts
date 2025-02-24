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
    implementation(project(":feature:root-api"))
    implementation(project(":feature:quest-api"))

    implementation(project(":uikit"))
    implementation(project(":utils"))
}