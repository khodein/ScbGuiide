package plugin

import deps.serialization.SerializationDep
import org.gradle.api.Project
import org.gradle.api.artifacts.VersionCatalog
import org.gradle.api.artifacts.VersionCatalogsExtension
import org.gradle.kotlin.dsl.getByType
import plugin.base.BasePlugin

class SerializationPlugin : BasePlugin() {

    override fun apply(target: Project) {
        val versionCatalogs = target.extensions.getByType<VersionCatalogsExtension>()
        val libs = versionCatalogs.named("libs")

        target.plugins.apply(libs.getKotlinSerialization())

        target.applyDependencies(listOf(SerializationDep(libs)))
    }

    private fun VersionCatalog.getKotlinSerialization(): String {
        val androidAppPlugin = this.findPlugin("kotlin-serialization").get()
        return androidAppPlugin.get().pluginId
    }

    companion object : PluginID {
        override val id: String = "serialization-config-plugin"
    }
}