import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

plugins {
    kotlin("jvm") version "1.6.10"
    application
}

group = "me.seangalloway"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
}

dependencies {
    testImplementation(kotlin("test"))
}

tasks.test {
    useJUnitPlatform()
}

tasks.withType<KotlinCompile> {
    kotlinOptions.jvmTarget = "1.8"
}

application {
    mainClass.set("odu.HasherKt")
}

tasks.withType<Jar>{
    manifest {
        attributes["Main-Class"] = "odu.HasherKt"
    }

    exclude("META-INF/**")

    from(configurations.runtimeClasspath.get().map { if (it.isDirectory) it else zipTree(it) })
}