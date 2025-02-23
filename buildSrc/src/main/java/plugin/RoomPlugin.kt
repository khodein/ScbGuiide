package plugin

import deps.room.RoomListDep
import org.gradle.api.Project
import org.gradle.api.artifacts.VersionCatalogsExtension
import org.gradle.kotlin.dsl.getByType
import plugin.base.BasePlugin

class RoomPlugin : BasePlugin() {

    override fun apply(target: Project) {
        val versionCatalogs = target.extensions.getByType<VersionCatalogsExtension>()
        val libs = versionCatalogs.named("libs")

        target.applyDependencies(RoomListDep.invoke(libs))
    }

    companion object {
        const val ID = "room-config-plugin"
    }
}