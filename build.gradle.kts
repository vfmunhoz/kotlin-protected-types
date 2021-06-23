plugins {
    kotlin("jvm").version("1.5.10")
}

group = "com.vfmunhoz"
version = "1.0.0-SNAPSHOT"

repositories {
    mavenCentral()
}

dependencies {
    implementation(kotlin("stdlib"))

    testImplementation(kotlin("test"))
}

tasks.test {
    useJUnitPlatform()
}
