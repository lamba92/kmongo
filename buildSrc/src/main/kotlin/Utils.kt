import org.jetbrains.kotlin.gradle.plugin.KotlinDependencyHandler

fun KotlinDependencyHandler.api(group: String, artifact: String, version: String) =
    api("$group:$artifact:$version")

fun KotlinDependencyHandler.implementation(group: String, artifact: String, version: String) =
    implementation("$group:$artifact:$version")
