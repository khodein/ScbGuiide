plugins {
    id("feature-api-config-plugin")
}

android {
    namespace = "com.spravochnic.scbguide.quest_api"
}

dependencies {
    implementation(project(":root-api"))

    implementation(project(":uikit"))
}