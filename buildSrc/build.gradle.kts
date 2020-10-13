plugins {
    `kotlin-dsl`
}

repositories {
    jcenter()
    mavenCentral()
}

gradlePlugin {
    plugins {
        create("kmongo") {
            id = "kmongo-build-plugin"
            implementationClass = "KMongoPlugin"
        }
    }
}
dependencies {

    val kotlinVersion: String by project

    api(kotlin("gradle-plugin", kotlinVersion))
    api(kotlin("reflect", kotlinVersion))
    api(kotlin("serialization", kotlinVersion))

}


