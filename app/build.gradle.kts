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
    implementation(project(":feature:root-api"))

    implementation(project(":feature:status-api"))
    implementation(project(":feature:status-impl"))

    implementation(project(":feature:splash-api"))
    implementation(project(":feature:splash-impl"))

    implementation(project(":feature:catalog-root-api"))
    implementation(project(":feature:catalog-root-impl"))

    implementation(project(":feature:catalog-top-api"))
    implementation(project(":feature:catalog-top-impl"))

    implementation(project(":feature:lectory-api"))
    implementation(project(":feature:lectory-impl"))

    implementation(project(":feature:quest-api"))
    implementation(project(":feature:quest-impl"))

    implementation(project(":uikit"))
    implementation(project(":utils"))
}