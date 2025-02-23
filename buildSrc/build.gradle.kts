plugins {
    `kotlin-dsl`
    alias(libs.plugins.kotlin.jvm)
}

repositories {
    mavenCentral()
    google()

    gradlePlugin {
        plugins {
            register("app-config-plugin") {
                description = "AppPlugin"
                id = "app-config-plugin"
                implementationClass = "plugin.AppPlugin"
            }

            register("compose-config-plugin") {
                description = "ComposePlugin"
                id = "compose-config-plugin"
                implementationClass = "plugin.ComposePlugin"
            }

            register("serialization-config-plugin") {
                description = "SerializationPlugin"
                id = "serialization-config-plugin"
                implementationClass = "plugin.SerializationPlugin"
            }

            register("decompose-config-plugin") {
                description = "DecomposePlugin"
                id = "decompose-config-plugin"
                implementationClass = "plugin.DecomposePlugin"
            }

            register("room-config-plugin") {
                description = "RoomPlugin"
                id = "room-config-plugin"
                implementationClass = "plugin.RoomPlugin"
            }
        }
    }
}

dependencies {
    implementation(libs.gradle)
    implementation(libs.kotlin.stdlib)
    implementation(libs.kotlin.gradle.plugin)
    implementation(gradleApi())
}
