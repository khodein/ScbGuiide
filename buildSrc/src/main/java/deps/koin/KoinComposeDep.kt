package deps.koin

import deps.BaseDep
import model.ConfigureModel
import model.MethodModel
import org.gradle.api.artifacts.VersionCatalog

object KoinComposeDep : BaseDep() {

    override fun invoke(libs: VersionCatalog): ConfigureModel {
        val lib = libs.findLibrary("koin-androidx-compose").get()
        val dependency = getDependency(
            module = "${lib.get().module}",
            version = "${lib.get().version}"
        )
        return ConfigureModel(
            method = MethodModel.IMPL,
            dependency = dependency
        )
    }
}