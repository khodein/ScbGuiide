package plugin.feature

import config.AppConfig
import deps.activityx.AndroidXCoreDep
import deps.koin.KoinDep
import deps.room.RoomRuntimeDep
import org.gradle.api.Project
import org.gradle.api.artifacts.VersionCatalogsExtension
import org.gradle.kotlin.dsl.getByType
import plugin.ComposePlugin
import plugin.DecomposePlugin
import plugin.SerializationPlugin
import plugin.base.BaseFeaturePlugin

class FeatureImplPlugin : BaseFeaturePlugin() {

    override fun apply(target: Project) {
        val versionCatalogs = target.extensions.getByType<VersionCatalogsExtension>()
        val libs = versionCatalogs.named("libs")

        target.plugins.apply(libs.getAndroidLibraryId())
        target.plugins.apply(libs.getKotlinAndroidId())

        target.plugins.apply(libs.getKotlinKsp())

        target.plugins.apply(ComposePlugin.id)
        target.plugins.apply(SerializationPlugin.id)
        target.plugins.apply(DecomposePlugin.id)

        AppConfig.configure(target)

        val dependencies = buildList {
            add(AndroidXCoreDep(libs))
            add(RoomRuntimeDep.invoke(libs))
            add(KoinDep(libs))
        }

        target.applyDependencies(dependencies)
    }

    companion object : PluginID {
        override val id: String = "feature-impl-config-plugin"
    }
}