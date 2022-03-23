import kr.entree.spigradle.kotlin.spigot
import kr.entree.spigradle.kotlin.spigotmc

plugins {
    kotlin("jvm") version "1.5.10"
    id("kr.entree.spigradle.base") version "2.3.4"
    id("com.github.johnrengelman.shadow") version "7.1.2"
}

group = "cloud.acog"
version = "4.0.0"

repositories {
    mavenCentral()
    mavenLocal()
    spigotmc()
}

dependencies {
    shadow(project(":bukkit-view-kotlin-core"))
    compileOnly(spigot("1.18.1"))
    implementation(kotlin("stdlib"))
    implementation("io.typecraft:bukkit-view-core:${version}")
}
