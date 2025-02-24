package plugin

import config.AppConfig
import deps.activityx.AndroidXDep
import deps.leekcanary.LeekCanaryDep
import org.gradle.api.Project
import org.gradle.api.artifacts.VersionCatalog
import org.gradle.api.artifacts.VersionCatalogsExtension
import org.gradle.kotlin.dsl.getByType
import plugin.base.BasePlugin

class AppPlugin : BasePlugin() {

    override fun apply(target: Project) {
        val versionCatalogs = target.extensions.getByType<VersionCatalogsExtension>()
        val libs = versionCatalogs.named("libs")

        target.plugins.apply(libs.getAndroidApplicationId())
        target.plugins.apply(libs.getKotlinAndroidId())

        target.plugins.apply(libs.getKotlinKsp())

        target.plugins.apply(ComposePlugin.id)
        target.plugins.apply(SerializationPlugin.id)
        target.plugins.apply(DecomposePlugin.id)
        target.plugins.apply(RoomPlugin.id)

        AppConfig.configure(target)

        val androidXDependencies = AndroidXDep.getList(libs)

        val dependencies = buildList {
            addAll(androidXDependencies)
            add(LeekCanaryDep(libs))
        }

        target.applyDependencies(dependencies)
    }

    private fun VersionCatalog.getAndroidApplicationId(): String {
        val androidAppPlugin = this.findPlugin("android-application").get()
        return androidAppPlugin.get().pluginId
    }

    companion object : PluginID {
        override val id: String = "app-config-plugin"
    }
}