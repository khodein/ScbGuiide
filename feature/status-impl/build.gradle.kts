plugins {
    id("feature-impl-config-plugin")
}

android {
    namespace = "com.spravochnic.scbguide.status_impl"
}

dependencies {
    implementation(project(":feature:status-api"))
    implementation(project(":feature:lectory-api"))
    implementation(project(":feature:quest-api"))
    implementation(project(":feature:catalog-root-api"))
    implementation(project(":feature:root-api"))
}