/*
 * This Kotlin source file was generated by the Gradle 'init' task.
 */
package plugin

import org.gradle.testfixtures.ProjectBuilder
import kotlin.test.Test
import kotlin.test.assertNotNull

/**
 * A simple unit test for the 'plugin.greeting' plugin.
 */
class KotlinXmlFromScratchPluginTest {
    @Test fun `plugin registers task`() {
        // Create a test project and apply the plugin
        val project = ProjectBuilder.builder().build()
        project.plugins.apply("plugin.greeting")

        // Verify the result
        assertNotNull(project.tasks.findByName("greeting"))
    }
}
