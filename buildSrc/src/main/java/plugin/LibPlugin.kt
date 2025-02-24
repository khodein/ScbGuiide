package plugin

import config.AppConfig
import deps.activityx.AndroidXCoreDep
import deps.decompose.DecomposeDep
import deps.koin.KoinDep
import org.gradle.api.Project
import org.gradle.api.artifacts.VersionCatalogsExtension
import org.gradle.kotlin.dsl.getByType
import plugin.base.BaseFeaturePlugin

class LibPlugin : BaseFeaturePlugin() {

    override fun apply(target: Project) {
        val versionCatalogs = target.extensions.getByType<VersionCatalogsExtension>()
        val libs = versionCatalogs.named("libs")

        target.plugins.apply(libs.getAndroidLibraryId())
        target.plugins.apply(libs.getKotlinAndroidId())

        target.plugins.apply(SerializationPlugin.id)
        target.plugins.apply(ComposePlugin.id)

        AppConfig.configure(target)

        val dependencies = buildList {
            add(AndroidXCoreDep.invoke(libs))
            add(DecomposeDep.invoke(libs))
            add(KoinDep(libs))
        }

        target.applyDependencies(dependencies)
    }

    companion object : PluginID {
        override val id: String = "lib-api-config-plugin"
    }
}