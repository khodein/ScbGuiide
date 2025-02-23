package deps.activityx

import deps.BaseDep
import model.ConfigureModel
import model.MethodModel
import org.gradle.api.artifacts.VersionCatalog

object AndroidXLifecycleRuntimeKtxDep : BaseDep() {

    override fun invoke(libs: VersionCatalog): ConfigureModel {
        val coreLib = libs.findLibrary("androidx-lifecycle-runtime-ktx").get()
        val dependency = getDependency(
            module = "${coreLib.get().group}",
            name = coreLib.get().name,
            version = "${coreLib.get().version}"
        )
        return ConfigureModel(
            method = MethodModel.IMPL,
            dependency = dependency,
        )
    }
}