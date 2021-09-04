plugins {
    kotlin("jvm").version("1.5.21")
    id("org.jetbrains.dokka") version "1.5.0"
    `maven-publish`
    `signing`
}

group = "io.github.vfmunhoz"
version = "0.0.1-SNAPSHOT"

val sonatypeReleaseRepo: String by project
val sonatypeSnapshotRepo: String by project
val sonatypeUsername: String? = System.getenv("SONATYPE_USERNAME")
val sonatypePassword: String? = System.getenv("SONATYPE_PASSWORD")
val sonatypeRepositoryId: String? = System.getenv("SONATYPE_REPOSITORY_ID")

val gpgPrivateKey: String? = System.getenv("GPG_PRIVATE_KEY")
val gpgPrivatePassword: String? = System.getenv("GPG_PRIVATE_PASSWORD")

val dokkaOutputDir = "$buildDir/dokka"

repositories {
    mavenCentral()
}

dependencies {
    implementation(kotlin("stdlib"))
    implementation(kotlin("reflect"))

    compileOnly("com.fasterxml.jackson.module:jackson-module-kotlin:2.12.+")

    testImplementation(kotlin("test"))
    testImplementation("com.fasterxml.jackson.module:jackson-module-kotlin:2.12.+")

    dokkaHtmlPlugin("org.jetbrains.dokka:kotlin-as-java-plugin:1.5.0")
}

tasks.test {
    useJUnitPlatform()
}

// Suppressing test compile warnings since we intentionally
// cause an overflow on arithmetic operation for integer types.
tasks.compileTestKotlin {
    kotlinOptions.suppressWarnings = true
}

tasks.getByName<org.jetbrains.dokka.gradle.DokkaTask>("dokkaHtml") {
    outputDirectory.set(file(dokkaOutputDir))
}

val deleteDokkaOutputDir by tasks.register<Delete>("deleteDokkaOutputDirectory") {
    delete(dokkaOutputDir)
}

val javadocJar = tasks.register<Jar>("javadocJar") {
    dependsOn(deleteDokkaOutputDir, tasks.dokkaHtml)
    archiveClassifier.set("javadoc")
    from(dokkaOutputDir)
}

val sourcesJar = tasks.register<Jar>("sourcesJar") {
    archiveClassifier.set("sources")
    from(sourceSets.getByName("main").allSource)
}

signing {
    useInMemoryPgpKeys(
        gpgPrivateKey,
        gpgPrivatePassword
    )

    sign(publishing.publications)
}

publishing {
    repositories {
        maven {
            name = "oss"

            val repoUri = if (version.toString().contains("SNAPSHOT")) { sonatypeSnapshotRepo }
                          else { sonatypeReleaseRepo }

            url = uri(repoUri)

            credentials {
                username = sonatypeUsername
                password = sonatypePassword
            }
        }
    }

    publications {
        create<MavenPublication>("release") {
            from(components["kotlin"])
        }

        withType<MavenPublication> {
            artifact(javadocJar.get())
            artifact(sourcesJar.get())

            pom {
                name.set("Kotlin ProtectedTypes")
                description.set("KPT - Kotlin ProtectedTypes for JVM applications")
                licenses {
                    license {
                        name.set("MIT")
                        url.set("https://opensource.org/licenses/MIT")
                    }
                }
                url.set("https://github.com/vfmunhoz/kotlin-protected-types")
                issueManagement {
                    system.set("Github")
                    url.set("https://github.com/vfmunhoz/kotlin-protected-types/issues")
                }
                scm {
                    connection.set("https://github.com/vfmunhoz/kotlin-protected-types.git")
                    url.set("https://github.com/vfmunhoz/kotlin-protected-types")
                }
                developers {
                    developer {
                        name.set("Vinicius Montes Munhoz")
                        email.set("viniciusfmunhoz@gmail.com")
                    }
                }
            }
        }
    }
}
