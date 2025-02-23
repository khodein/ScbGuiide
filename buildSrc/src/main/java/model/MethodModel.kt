package model

enum class MethodModel(val value: String) {
    IMPL("implementation"),
    DEBUG_IMPL("debugImplementation"),
    KSP("ksp"),
}