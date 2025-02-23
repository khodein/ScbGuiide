package deps.decompose

import deps.BaseDep
import model.ConfigureModel
import model.MethodModel
import org.gradle.api.artifacts.VersionCatalog

object DecomposeExtDecomposeDep : BaseDep() {

    override fun invoke(libs: VersionCatalog): ConfigureModel {
        val lib = libs.findLibrary("decompose-extensionsAndroid").get()
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