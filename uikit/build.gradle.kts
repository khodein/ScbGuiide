plugins {
    id("lib-api-config-plugin")
}

android {
    namespace = "com.spravochnic.scbguide.uikit"
}

dependencies {
    implementation(project(":utils"))
}