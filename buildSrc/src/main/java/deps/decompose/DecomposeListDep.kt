package deps.decompose

import model.ConfigureModel
import org.gradle.api.artifacts.VersionCatalog

object DecomposeListDep {

    operator fun invoke(libs: VersionCatalog): List<ConfigureModel> {
        return listOf(
            DecomposeDep.invoke(libs),
            DecomposeExtDecomposeDep.invoke(libs),
            DecomposeExtDep.invoke(libs),
            DecomposeLifecycleCoroutinesDep.invoke(libs)
        )
    }
}