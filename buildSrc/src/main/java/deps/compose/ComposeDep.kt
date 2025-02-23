package deps.compose

import model.ConfigureModel
import model.MethodModel
import org.gradle.api.Project
import org.gradle.api.artifacts.VersionCatalog

object ComposeDep {

    operator fun invoke(
        libs: VersionCatalog,
        target: Project
    ): List<ConfigureModel> {
        return listOf(
            libs.getAndroidXComposeBom(target),
            libs.getAndroidXUi(),
            libs.getAndroidXUiGraphics(),
            libs.getAndroidxMaterial3(),
            libs.getAndroidXUiToolingPreview(),
            libs.getAndroidXUiTooling(),
            libs.getAndroidXUiTestManifest(),
        )
    }

    private fun VersionCatalog.getAndroidXUiToolingPreview(): ConfigureModel {
        val androidxUiToolingPreview = this.findLibrary("androidx-ui-tooling-preview").get()
        val androidxUiToolingPreviewModule = androidxUiToolingPreview.get().module
        return ConfigureModel(
            method = MethodModel.IMPL,
            dependency = "$androidxUiToolingPreviewModule"
        )
    }

    private fun VersionCatalog.getAndroidxMaterial3(): ConfigureModel {
        val androidxMaterial3 = this.findLibrary("androidx-material3").get()
        val androidxMaterial3Module = androidxMaterial3.get().module
        return ConfigureModel(
            method = MethodModel.IMPL,
            dependency = "$androidxMaterial3Module"
        )
    }

    private fun VersionCatalog.getAndroidXUiGraphics(): ConfigureModel {
        val androidxUiGraphics = this.findLibrary("androidx-ui-graphics").get()
        val androidxUiGraphicsModule = androidxUiGraphics.get().module
        return ConfigureModel(
            method = MethodModel.IMPL,
            dependency = "$androidxUiGraphicsModule"
        )
    }

    private fun VersionCatalog.getAndroidXUi(): ConfigureModel {
        val androidxUi = this.findLibrary("androidx-ui").get()
        val androidxUiModule = androidxUi.get().module
        return ConfigureModel(
            method = MethodModel.IMPL,
            dependency = "$androidxUiModule"
        )
    }

    private fun VersionCatalog.getAndroidXComposeBom(target: Project): ConfigureModel {
        val androidxComposeBom = this.findLibrary("androidx-compose-bom").get()
        val androidxComposeBomModule = androidxComposeBom.get().module
        val androidxComposeBomVersion = androidxComposeBom.get().version
        return ConfigureModel(
            method = MethodModel.IMPL,
            dependency = target.dependencies.platform("$androidxComposeBomModule:$androidxComposeBomVersion")
        )
    }

    private fun VersionCatalog.getAndroidXUiTooling(): ConfigureModel {
        val androidxUi = this.findLibrary("androidx-ui-tooling").get()
        val androidxUiModule = androidxUi.get().module
        return ConfigureModel(
            method = MethodModel.DEBUG_IMPL,
            dependency = "$androidxUiModule"
        )
    }

    private fun VersionCatalog.getAndroidXUiTestManifest(): ConfigureModel {
        val androidxUi = this.findLibrary("androidx-ui-test-manifest").get()
        val androidxUiModule = androidxUi.get().module
        return ConfigureModel(
            method = MethodModel.DEBUG_IMPL,
            dependency = "$androidxUiModule"
        )
    }
}