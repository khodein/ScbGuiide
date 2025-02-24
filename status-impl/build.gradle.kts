plugins {
    id("feature-impl-config-plugin")
}

android {
    namespace = "com.spravochnic.scbguide.status_impl"
}

dependencies {
    implementation(project(":status-api"))
    implementation(project(":catalog-root-api"))
    implementation(project(":root-api"))
}