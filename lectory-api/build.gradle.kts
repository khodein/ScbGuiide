plugins {
    id("feature-api-config-plugin")
}

android {
    namespace = "com.spravochnic.scbguide.lectory_api"
}

dependencies {
    implementation(project(":root-api"))

    implementation(project(":uikit"))
}