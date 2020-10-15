plugins {
    `kmongo-build-plugin`
}

kotlin.sourceSets {
    commonMain.dependencies {
        api(project(":id"))
    }

    jvmMain.dependencies {
        val jacksonVersion: String by project
        api(jackson("core", "databind", jacksonVersion))
        api(jackson("module", "module-kotlin", jacksonVersion))
    }

}
