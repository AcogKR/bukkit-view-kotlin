# bukkit-view-kotlin

This is an extension of the bukkit-view-core library. [[bukkit-view]](https://github.com/typecraft-io/bukkit-view)  
A detailed explanation is on the [wiki](https://github.com/AcogKR/bukkit-view-kotlin/wiki)

## Import

<details>
<summary>Groovy</summary>

```groovy
repositories {
    mavenCentral()
}

dependencies {
    compileOnly "cloud.acog:bukkit-view-kotlin-core:2.0.2"
}
```
</details>

<details>
<summary>Kotlin DSL</summary>

```kotlin
repositories {
    mavenCentral()
}

dependencies {
    compileOnly("cloud.acog:bukkit-view-kotlin-core:2.0.2")
}
```
</details>

<details>
<summary>Maven</summary>

```xml
<dependencies>
    <dependency>
        <groupId>cloud.acog</groupId>
        <artifactId>bukkit-view-kotlin-core</artifactId>
        <version>2.0.2</version>
        <scope>provided</scope>
    </dependency>
</dependencies>
```
</details>

---

### Main Class

```kotlin
class ViewPlugin : JavaPlugin() {

    override fun onEnable() { //register bukkit-view Event Listener
        BukkitView.register(this)
    }
    
}
```


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
PageViewLayout to ChestView 
```kotlin
val pageViewLayout : PageViewLayOut = TODO()
pageViewLayout.toView(1).openView(player, plugin)
```

### ViewItem

Constructions:

`viewItem(ItemStack, ClickEvent.() -> ViewAction>)`
> (ItemStack, ClickEvent -> ViewAction) -> ViewItem  

`justViewItem(ItemStack)`  

> ItemStack -> ViewItem  

`pageViewItem(ItemStack, ClickEvent.() -> ViewAction>)`  

> (ItemStack, ClickEvent -> Unit) -> Function<PageContext, ViewItem>  

`justPageViewItem(ItemStack)`  

> ItemStack -> Function<PageContext, ViewItem>