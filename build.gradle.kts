import kr.entree.spigradle.kotlin.spigot
import kr.entree.spigradle.kotlin.spigotmc

plugins {
    kotlin("jvm") version "1.5.10"
    id("maven-publish")
    id("kr.entree.spigradle.base") version "2.3.4"
}

group = "cloud.acog"
version = "1.0.0"

repositories {
    mavenCentral()
    spigotmc()
    mavenLocal()
}

dependencies {
    compileOnly(spigot("1.18.1"))
    implementation(kotlin("stdlib"))
    implementation("io.typecraft:bukkit-view-core:1.0.0")
}

publishing {
    publications {
        create("maven", MavenPublication::class) {
            from(components["java"])
        }
    }
}
