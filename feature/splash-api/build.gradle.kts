plugins {
    id("feature-api-config-plugin")
}

android {
    namespace = "com.spravochnic.scbguide.splash_api"
}

dependencies {
    implementation(project(":feature:root-api"))
}