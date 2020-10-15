import org.gradle.api.NamedDomainObjectContainer
import org.gradle.api.NamedDomainObjectProvider
import org.jetbrains.kotlin.gradle.plugin.KotlinDependencyHandler
import org.jetbrains.kotlin.gradle.plugin.KotlinSourceSet

fun KotlinDependencyHandler.api(group: String, artifact: String, version: String) =
    api("$group:$artifact:$version")

fun KotlinDependencyHandler.implementation(group: String, artifact: String, version: String) =
    implementation("$group:$artifact:$version")

fun KotlinDependencyHandler.mongodb(name: String, version: String) =
    "org.mongodb:mongodb-$name:$version"

fun KotlinDependencyHandler.jackson(id: String, name: String, version: String) =
    "com.fasterxml.jackson.$id:jackson-$name:$version"

fun KotlinDependencyHandler.jackson(name: String, version: String) =
    "com.fasterxml.jackson.$name:jackson-$name:$version"

fun KotlinDependencyHandler.serialization(name: String, version: String) =
    "org.jetbrains.kotlinx:kotlinx-serialization-$name:$version"

fun NamedDomainObjectProvider<KotlinSourceSet>.dependencies(action: KotlinDependencyHandler.()->Unit) =
    get().dependencies(action)
