rootProject.name = "bukkit-view-kotlin"

include("core", "plugin")

rootProject.children.forEach {
    it.name = "${rootProject.name}-${it.name}"
}
