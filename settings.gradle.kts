pluginManagement {
    repositories {
        mavenCentral()
        jcenter()
        gradlePluginPortal()
    }
    plugins {
        val kotlinVersion: String by settings
        kotlin("multiplatform") version kotlinVersion
    }
}

rootProject.name = "kmongo"

include(
    ":annotation-processor",
    ":async",
    ":async:core",
    ":async:native",
    ":async:serialization",
    ":core",
    ":coroutines",
    ":coroutines:core",
    ":coroutines:native",
    ":coroutines:serialization",
    ":data",
    ":flapdoodle",
    ":id",
    ":id:jackson",
    ":jackson-mapping",
    ":native",
    ":native-mapping",
    ":property",
    ":rxjava2",
    ":rxjava2:core",
    ":rxjava2:native",
    ":rxjava2:serialization",
    ":serialization",
    ":serialization-mapping"
)
