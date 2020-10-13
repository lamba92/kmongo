import org.gradle.api.Plugin
import org.gradle.api.Project
import org.gradle.api.publish.maven.plugins.MavenPublishPlugin
import org.gradle.api.tasks.testing.Test
import org.gradle.kotlin.dsl.apply
import org.gradle.kotlin.dsl.findByType
import org.gradle.kotlin.dsl.withType
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
        }

        tasks.withType<Test> {
            useJUnitPlatform()
        }

    }

}
