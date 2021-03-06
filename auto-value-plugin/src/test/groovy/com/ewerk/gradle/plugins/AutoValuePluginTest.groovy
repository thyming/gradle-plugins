package com.ewerk.gradle.plugins

import com.ewerk.gradle.plugins.tasks.InitAutoValueSourcesDir
import org.gradle.api.Project
import org.gradle.api.Task
import org.gradle.api.internal.artifacts.dependencies.DefaultExternalModuleDependency
import org.gradle.api.plugins.JavaPlugin
import org.gradle.testfixtures.ProjectBuilder
import org.testng.annotations.BeforeMethod
import org.testng.annotations.Test

import static org.hamcrest.CoreMatchers.*
import static org.hamcrest.MatcherAssert.assertThat

/**
 * @author holgerstolzenberg
 * @since 1.0.0
 */
class AutoValuePluginTest {
  private Project project

  @BeforeMethod
  void setup() {
    project = ProjectBuilder.builder().build()
    project.plugins.apply(AutoValuePlugin.class)
  }

  @Test
  void testPluginAppliesItself() {
    assertThat(project.plugins.hasPlugin(AutoValuePlugin.class), is(true))
  }

  @Test
  void testReApplyDoesNotFail() {
    project.plugins.apply(AutoValuePlugin.class)
  }

  @Test
  void testPluginAppliesJavaPlugin() {
    assertThat(project.plugins.hasPlugin(JavaPlugin.class), is(true))
  }

  @Test
  void testPluginRegistersAutoValueExtensions() {
    assertThat(project.extensions.autoValue, notNullValue())
  }

  @Test
  void testPluginTasksAreAvailable() {
    assertThat(project.tasks.initAutoValueSourcesDir, notNullValue())
  }

  @Test
  void testTaskTypes() {
    final Task initTask = project.tasks.initAutoValueSourcesDir
    assertThat(initTask, instanceOf(InitAutoValueSourcesDir.class))
  }

  @Test
  void testAfterEvaluate() {
    project.evaluate()

    DefaultExternalModuleDependency lib = project.configurations.compile.dependencies[0] as DefaultExternalModuleDependency

    String id = lib.group + ":" +
        lib.name +
        ":" +
        lib.version

    assertThat(id, equalTo(AutoValuePluginExtension.DEFAULT_LIBRARY))
  }
}
