package plugin.base

import org.gradle.api.artifacts.VersionCatalog

abstract class BaseFeaturePlugin : BasePlugin() {

    protected fun VersionCatalog.getAndroidLibraryId(): String {
        val androidAppPlugin = this.findPlugin("android-library").get()
        return androidAppPlugin.get().pluginId
    }
}