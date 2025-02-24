plugins {
    id("feature-impl-config-plugin")
}

android {
    namespace = "com.spravochnic.scbguide.catalog_top_impl"
}

dependencies {
    implementation(project(":root-api"))
    implementation(project(":catalog-top-api"))

    implementation(project(":uikit"))
    implementation(project(":utils"))
}