plugins {
    `kmongo-build-plugin`
}

allprojects {

    group = "org.litote.kmongo"
    version = System.getenv("TRAVIS_TAG")
        ?: System.getenv("GITHUB_REF")?.split("/")?.last()
            ?: "4.0.1"

    repositories {
        mavenCentral()
        jcenter()
    }
}

kotlin.sourceSets {

    val kotlinxSerializationVersion: String by project
    val mongoDriverVersion: String by project

    commonMain {
        dependencies {
            api("org.jetbrains.kotlinx", "kotlinx-serialization-core", kotlinxSerializationVersion)
        }
    }

    jvmMain {
        dependencies {
            api(project(":id"))
            api(mongodb("driver-core", mongoDriverVersion))
        }
    }

}

