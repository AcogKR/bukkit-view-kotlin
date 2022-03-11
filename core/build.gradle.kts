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
    implementation("io.typecraft:bukkit-view-core:${version}")
}

publishing {
    publications {
        create("maven", MavenPublication::class) {
            from(components["java"])
        }
    }
}
