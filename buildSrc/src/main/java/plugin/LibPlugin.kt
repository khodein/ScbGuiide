package plugin

import config.AppConfig
import deps.activityx.AndroidXCoreDep
import deps.decompose.DecomposeDep
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

        target.plugins.apply(SerializationPlugin.ID)
        target.plugins.apply(ComposePlugin.ID)

        AppConfig.configure(target)

        val dependencies = buildList {
            add(AndroidXCoreDep.invoke(libs))
            add(DecomposeDep.invoke(libs))
        }
        target.applyDependencies(dependencies)
    }

    companion object {
        const val ID = "lib-api-config-plugin"
    }
}