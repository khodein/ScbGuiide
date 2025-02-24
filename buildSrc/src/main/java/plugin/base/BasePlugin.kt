package plugin.base

import model.ConfigureModel
import org.gradle.api.Plugin
import org.gradle.api.Project
import org.gradle.api.artifacts.VersionCatalog
import org.gradle.kotlin.dsl.dependencies

abstract class BasePlugin : Plugin<Project> {

    protected fun Project.applyDependencies(
        list: List<ConfigureModel>,
    ) {
        this.dependencies {
            list.forEach { config ->
                add(
                    configurationName = config.method.value,
                    dependencyNotation = config.dependency,
                )
            }
        }
    }

    protected fun VersionCatalog.getKotlinAndroidId(): String {
        val androidAppPlugin = this.findPlugin("kotlin-android").get()
        return androidAppPlugin.get().pluginId
    }

    protected fun VersionCatalog.getKotlinCompose(): String {
        val androidAppPlugin = this.findPlugin("kotlin-compose").get()
        return androidAppPlugin.get().pluginId
    }

    protected fun VersionCatalog.getKotlinKsp(): String {
        val androidAppPlugin = this.findPlugin("kotlin-ksp").get()
        return androidAppPlugin.get().pluginId
    }

    interface PluginID {
        val id: String
    }
}