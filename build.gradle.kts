plugins {
    kotlin("jvm").version("1.5.21")
    `maven-publish`
}

group = "com.github.vfmunhoz"
version = "1.0.0"

repositories {
    mavenCentral()
}

publishing {
    publications {
        create<MavenPublication>("maven") {
            from(components["kotlin"])
        }
    }
}

dependencies {
    implementation(kotlin("stdlib"))
    implementation(kotlin("reflect"))

    compileOnly("com.fasterxml.jackson.module:jackson-module-kotlin:2.12.+")

    testImplementation(kotlin("test"))
    testImplementation("com.fasterxml.jackson.module:jackson-module-kotlin:2.12.+")
}

tasks.test {
    useJUnitPlatform()
}

// Suppressing test compile warnings since we intentionally
// cause an overflow on arithmetic operation for integer types.
tasks.compileTestKotlin {
    kotlinOptions.suppressWarnings = true
}