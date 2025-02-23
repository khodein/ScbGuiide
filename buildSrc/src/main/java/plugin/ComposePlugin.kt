package plugin

import deps.compose.ComposeDep
import org.gradle.api.Project
import org.gradle.api.artifacts.VersionCatalogsExtension
import org.gradle.kotlin.dsl.getByType
import plugin.base.BasePlugin

class ComposePlugin : BasePlugin() {

    override fun apply(target: Project) {
        val versionCatalogs = target.extensions.getByType<VersionCatalogsExtension>()
        val libs = versionCatalogs.named("libs")

        target.plugins.apply(libs.getKotlinCompose())

        target.applyDependencies(ComposeDep.invoke(libs, target))
    }

    companion object {
        const val ID = "compose-config-plugin"
    }
}