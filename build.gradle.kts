import org.gradle.api.tasks.testing.logging.TestExceptionFormat

plugins {
    kotlin("jvm") version "2.3.20"
}

repositories {
    mavenCentral()
}

dependencies {
    testImplementation("org.junit.jupiter:junit-jupiter-params")
    testImplementation(kotlin("test"))
}

kotlin {
    jvmToolchain(25)
}

tasks.test {
    useJUnitPlatform {
        testLogging {
            events("passed", "skipped", "failed")
        }
        testLogging.showStandardStreams = true
        testLogging.showExceptions = true
        testLogging.exceptionFormat = TestExceptionFormat.FULL
    }
}
