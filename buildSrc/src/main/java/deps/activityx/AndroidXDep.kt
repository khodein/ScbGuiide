package deps.activityx

import model.ConfigureModel
import org.gradle.api.artifacts.VersionCatalog

object AndroidXDep {

    fun getList(libs: VersionCatalog): List<ConfigureModel> {
        return listOf(
            AndroidXCoreDep(libs),
            AndroidXActivityComposeDep(libs),
            AndroidXLifecycleRuntimeKtxDep(libs),
        )
    }
}