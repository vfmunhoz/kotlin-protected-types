plugins {
    kotlin("jvm").version("1.5.21")
}

group = "com.vfmunhoz"
version = "1.0.0"

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

// Suppressing test compile warnings since we intentionally
// cause an overflow on arithmetic operation for integer types.
tasks.compileTestKotlin {
    kotlinOptions.suppressWarnings = true
}