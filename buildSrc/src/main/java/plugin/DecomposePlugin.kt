package plugin

import deps.decompose.DecomposeListDep
import org.gradle.api.Project
import org.gradle.api.artifacts.VersionCatalogsExtension
import org.gradle.kotlin.dsl.getByType
import plugin.base.BasePlugin

class DecomposePlugin : BasePlugin() {

    override fun apply(target: Project) {
        val versionCatalogs = target.extensions.getByType<VersionCatalogsExtension>()
        val libs = versionCatalogs.named("libs")

        target.applyDependencies(DecomposeListDep.invoke(libs))
    }

    companion object {
        const val ID = "decompose-config-plugin"
    }
}