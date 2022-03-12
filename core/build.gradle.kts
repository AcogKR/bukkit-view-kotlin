import kr.entree.spigradle.kotlin.spigot
import kr.entree.spigradle.kotlin.spigotmc

plugins {
    kotlin("jvm") version "1.6.10"
    id("maven-publish")
    id("kr.entree.spigradle.base") version "2.3.4"
}

group = "cloud.acog"
version = "2.0.1"

repositories {
    mavenCentral()
    mavenLocal()
    spigotmc()
}

dependencies {
    compileOnly(spigot("1.18.1"))
    implementation(kotlin("stdlib"))
    api("io.typecraft:bukkit-view-core:${version}")
}

publishing {
    publications {
        create("maven", MavenPublication::class) {
            from(components["java"])
        }
    }
}

/*
publishing {
    publications {
        create("spigradleAnnotations", MavenPublication::class) {
            from(components["java"])
            // NOTE: https://central.sonatype.org/publish/requirements/#sufficient-metadata
            pom {
                name.set("${project.group}:${project.name}")
                description.set("Annotations and processors for specify the main class.")
                url.set("https://github.com/AcogKR/bukkit-view-kotlin")
                licenses {
                    license {
                        name.set("The Apache License, Version 2.0")
                        url.set("https://www.apache.org/licenses/LICENSE-2.0.txt")
                    }
                }
                developers {
                    developer {
                        id.set("Acogkr")
                        name.set("Seongmin Hong")
                        email.set("acog.seongmin@gmail.com")
                    }
                }
                scm {
                    connection.set("scm:git:git://github.com/AcogKR/bukkit-view-kotlin.git")
                    developerConnection.set("scm:git:ssh://github.com:AcogKR/bukkit-view-kotlin.git")
                    url.set("https://github.com/AcogKR/bukkit-view-kotlin/tree/master")
                }
            }
        }
    }
    repositories {
        maven {
            name = "sonatypeReleases"
            url = uri("https://s01.oss.sonatype.org/service/local/staging/deploy/maven2/")
            credentials {
                username = findProperty("ossrhUsername")?.toString()
                password = findProperty("ossrhPassword")?.toString()
            }
        }
        maven {
            name = "sonatypeSnapshots"
            url = uri("https://s01.oss.sonatype.org/content/repositories/snapshots/")
            credentials {
                username = findProperty("ossrhUsername")?.toString()
                password = findProperty("ossrhPassword")?.toString()
            }
        }
    }
}
*/