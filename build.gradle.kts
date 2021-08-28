plugins {
    kotlin("jvm").version("1.5.21")
    id("org.jetbrains.dokka") version "1.5.0"
    `maven-publish`
    `signing`
}

group = "io.github.vfmunhoz"
version = "1.0.0-SNAPSHOT"

val snapshotVersion: String by project

val sonatypeUsername: String? = System.getenv("SONATYPE_USERNAME")
val sonatypePassword: String? = System.getenv("SONATYPE_PASSWORD")
val repositoryId: String? = System.getenv("SONATYPE_REPOSITORY_ID")

val dokkaOutputDir = "$buildDir/dokka"

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

repositories {
    mavenCentral()
}

signing {
    useInMemoryPgpKeys(
        System.getenv("GPG_PRIVATE_KEY"),
        System.getenv("GPG_PRIVATE_PASSWORD")
    )

    sign(publishing.publications)
}

publishing {
    repositories {
        maven {
            name = "oss"

            val releasesRepoUrl = uri("https://s01.oss.sonatype.org/service/local/staging/deploy/maven2/")
            val snapshotsRepoUrl = uri("https://s01.oss.sonatype.org/content/repositories/snapshots/")

            url = if (snapshotVersion == "true") snapshotsRepoUrl else releasesRepoUrl

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
            artifacts {
                archives(javadocJar) {
                    builtBy(javadocJar)
                }
            }

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