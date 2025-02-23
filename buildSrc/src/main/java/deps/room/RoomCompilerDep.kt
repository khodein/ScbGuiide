package deps.room

import deps.BaseDep
import model.ConfigureModel
import model.MethodModel
import org.gradle.api.artifacts.VersionCatalog

object RoomCompilerDep : BaseDep() {

    override fun invoke(libs: VersionCatalog): ConfigureModel {
        val lib = libs.findLibrary("androidx-room-compiler").get()
        val dependency = getDependency(
            module = "${lib.get().module}",
            version = "${lib.get().version}"
        )
        return ConfigureModel(
            method = MethodModel.KSP,
            dependency = dependency
        )
    }
}