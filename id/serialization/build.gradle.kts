plugins {
    `kmongo-build-plugin`
    kotlin("plugin.serialization")
}

kotlin.sourceSets {
    commonMain.dependencies {
        val kotlinxSerializationVersion: String by project
        api(serialization("json", kotlinxSerializationVersion))
    }

    jvmMain.dependencies {
        api(project(":id"))
    }
}
