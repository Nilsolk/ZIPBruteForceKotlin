plugins {
    kotlin("jvm") version "1.9.21"
}

group = "org.example"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
}

dependencies {
    implementation("de.schlichtherle.truezip:truezip:7.7.1")
    implementation("org.apache.pdfbox:pdfbox:2.0.16")
    testImplementation("org.jetbrains.kotlin:kotlin-test")
    implementation("net.lingala.zip4j:zip4j:2.11.3")
    implementation("com.github.junrar:junrar:7.5.5")
}

tasks.test {
    useJUnitPlatform()
}
kotlin {
    jvmToolchain(19)
}