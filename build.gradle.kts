plugins {
    kotlin("jvm") version "1.9.21"
}

group = "org.example"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
}

dependencies {
    testImplementation("org.jetbrains.kotlin:kotlin-test")
    testImplementation("net.lingala.zip4j:zip4j:2.11.3")
    testImplementation("org.jetbrains.kotlinx:kotlinx-coroutines-io:0.1.16")

}

tasks.test {
    useJUnitPlatform()
}
kotlin {
    jvmToolchain(19)
}