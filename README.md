# bukkit-view-kotlin

> This is an extension of the bukkit-view-core library. [[bukkit-view]](https://github.com/typecraft-io/bukkit-view)  
> A detailed explanation is on the [Wiki](https://github.com/AcogKR/bukkit-view-kotlin/wiki)

## Gradle

#### groovy
```groovy
dependencies {
    compileOnly spigot('1.18')
    shadow "cloud.acog:bukkit-view-kotlin-core:2.0.1"
}
```

#### kotlin dsl
```kotlin
dependencies {
    compileOnly(spigot("1.18"))
    implementation(kotlin("stdlib-jdk8"))
    shadow("cloud.acog:bukkit-view-kotlin-core:2.0.1")
}
```

한국어로도 적어줘야 할려나

---
### Main Class

```kotlin
class ViewPlugin : JavaPlugin() {

    override fun onEnable() {
        BukkitView.register(this)
    }
    
}
```
---
### ChestView
```kotlin
chestView("title", 1) {
    slotItem(slot(3, 4), item(Material.CHEST, 1) {
        setDisplayName("Open Page2 ChestView")
    }) {
        //New ChestView Open
        ViewAction.Open(chestView("page2", 2) {
            slotItem(slot(3, 4), item(Material.CHEST, 1) {
                setDisplayName("Close ChestView")
            }) { ViewAction.NOTHING }
        })
    }
}.openView(player, plugin)
```
---
### PageViewLayout
```kotlin
pageViewLayout("title", 6) {
    contents = Bukkit.getOnlinePlayers().map { player ->
        pageViewItem(item(Material.PLAYER_HEAD) {
            metaOf<SkullMeta> {
                owningPlayer = player
                setDisplayName(player.name)
            }
        }) {
            ViewAction.NOTHING
        }
    }.toMutableList()
    //If the value of the controller is null, it will be applied by default
}.toView(1).openView(player, plugin)
```

