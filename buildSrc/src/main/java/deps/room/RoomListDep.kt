package deps.room

import model.ConfigureModel
import org.gradle.api.artifacts.VersionCatalog

object RoomListDep {

    operator fun invoke(libs: VersionCatalog): List<ConfigureModel> {
        return listOf(
            RoomKtxDep.invoke(libs),
            RoomRuntimeDep.invoke(libs),
            RoomCompilerDep.invoke(libs),
        )
    }
}