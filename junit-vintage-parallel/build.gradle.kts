import org.gradle.api.tasks.testing.logging.TestLogEvent
import org.gradle.api.tasks.testing.logging.TestLogEvent.STARTED

/*
 * This file was generated by the Gradle 'init' task.
 *
 * This generated file contains a sample Java Library project to get you started.
 * For more details take a look at the Java Libraries chapter in the Gradle
 * User Manual available at https://docs.gradle.org/6.0.1/userguide/java_library_plugin.html
 */

plugins {
    // Apply the java-library plugin to add support for Java Library
    `java-library`
}

repositories {
    // Use jcenter for resolving dependencies.
    // You can declare any Maven/Ivy/file repository here.
    jcenter()
}

dependencies {
    // This dependency is used internally, and not exposed to consumers on their own compile classpath.
    implementation("com.google.guava:guava:28.0-jre")

    val junit4Version = "4.13"
    val junitBomVersion = "5.6.1"


    testImplementation(platform("org.junit:junit-bom:$junitBomVersion"))

    // JUnit Jupiter API and TestEngine implementation
    testImplementation("org.junit.jupiter:junit-jupiter")

    testImplementation("junit:junit:${junit4Version}")
    testRuntimeOnly("org.junit.vintage:junit-vintage-engine") {
        because("allows JUnit 3 and JUnit 4 tests to run")
    }

}

tasks.test {
    // Use junit platform for unit tests
    useJUnitPlatform {
    }

    testLogging {
        events(TestLogEvent.STARTED, TestLogEvent.PASSED, TestLogEvent.SKIPPED, TestLogEvent.FAILED)
    }

    // Configure parallel per class
    systemProperty("junit.jupiter.execution.parallel.enabled", "true")
    systemProperty("junit.jupiter.execution.parallel.mode.default", "same_thread")
    systemProperty("junit.jupiter.execution.parallel.mode.classes.default", "concurrent")
    systemProperty("junit.jupiter.execution.parallel.config.strategy", "fixed")
    systemProperty("junit.jupiter.execution.parallel.config.fixed.parallelism", "2")

    maxParallelForks = 2

}
