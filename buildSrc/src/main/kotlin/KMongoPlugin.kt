import org.gradle.api.Plugin
import org.gradle.api.Project
import org.gradle.api.publish.maven.plugins.MavenPublishPlugin
import org.gradle.api.tasks.testing.Test
import org.gradle.kotlin.dsl.*
import org.jetbrains.kotlin.gradle.dsl.KotlinMultiplatformExtension
import org.jetbrains.kotlin.gradle.plugin.KotlinMultiplatformPluginWrapper

class KMongoPlugin : Plugin<Project> {

    override fun apply(target: Project): Unit = with(target) {
        apply<KotlinMultiplatformPluginWrapper>()
        apply<MavenPublishPlugin>()

        extensions.findByType<KotlinMultiplatformExtension>()!!.apply {
            jvm {
                compilations.all {
                    kotlinOptions.jvmTarget = "1.8"
                }
            }
            sourceSets {
                named("commonTest") {
                    dependencies {
                        api(kotlin("test-common"))
                    }
                }
                named("jvmTest") {
                    dependencies {

                        val junitVersion: String by project

                        api(kotlin("test-junit5"))
                        api("org.junit.jupiter", "junit-jupiter-api", junitVersion)
                        api("org.junit.jupiter", "junit-jupiter-engine", junitVersion)

                    }
                }
            }
        }

        tasks.withType<Test> {
            useJUnitPlatform()
        }

    }

}
