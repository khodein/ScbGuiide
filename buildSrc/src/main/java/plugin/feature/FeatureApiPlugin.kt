package plugin.feature

import config.AppConfig
import deps.activityx.AndroidXCoreDep
import deps.decompose.DecomposeDep
import deps.room.RoomRuntimeDep
import org.gradle.api.Project
import org.gradle.api.artifacts.VersionCatalogsExtension
import org.gradle.kotlin.dsl.getByType
import plugin.SerializationPlugin
import plugin.base.BaseFeaturePlugin

class FeatureApiPlugin : BaseFeaturePlugin() {

    override fun apply(target: Project) {
        val versionCatalogs = target.extensions.getByType<VersionCatalogsExtension>()
        val libs = versionCatalogs.named("libs")

        target.plugins.apply(libs.getAndroidLibraryId())
        target.plugins.apply(libs.getKotlinAndroidId())

        target.plugins.apply(SerializationPlugin.id)

        AppConfig.configure(target)

        val dependencies = buildList {
            add(AndroidXCoreDep.invoke(libs))
            add(DecomposeDep.invoke(libs))
            add(RoomRuntimeDep.invoke(libs))
        }
        target.applyDependencies(dependencies)
    }

    companion object : PluginID {
        override val id: String = "feature-api-config-plugin"
    }
}