import org.jetbrains.kotlin.gradle.dsl.KotlinJvmProjectExtension

plugins {
    kotlin("multiplatform")
    `maven-publish`
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

kotlin {
    jvm {
        compilations.all {
            kotlinOptions.jvmTarget = "1.8"
        }
    }
    sourceSets {
        named("jvmMain") {
            dependencies {
                api(kotlin("reflect"))
                api(project(":id"))
                api("org.mongodb:mongodb-driver-core")
            }
        }
    }
}
