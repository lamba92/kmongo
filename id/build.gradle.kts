plugins {
    `kmongo-build-plugin`
}

kotlin.sourceSets {
    jvmMain {
        dependencies {
            api(kotlin("reflect"))
        }
    }
}
