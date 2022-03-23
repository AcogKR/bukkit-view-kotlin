# bukkit-view-kotlin

This is an extension of the bukkit-view-core library. [[bukkit-view]](https://github.com/typecraft-io/bukkit-view)  
A detailed explanation is on the [wiki](https://github.com/AcogKR/bukkit-view-kotlin/wiki)


[Example is here!](https://github.com/AcogKR/bukkit-view-kotlin/blob/master/plugin/src/main/kotlin/cloud/acog/plugin/BukkitPlugin.kt)

## Import

<details>
<summary>Groovy</summary>

```groovy
repositories {
    mavenCentral()
}

dependencies {
    compileOnly "cloud.acog:bukkit-view-kotlin-core:4.0.0"
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
    compileOnly("cloud.acog:bukkit-view-kotlin-core:4.0.0")
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
        <version>4.0.0</version>
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
---
### ChestView
```kotlin
chestView("title", 6) {
    controlItem(slot(3, 3), ItemStack(Material.DIAMOND)) {
        ViewAction.Open(subView)
    }

    controls[slot(3, 6)] = viewControl(ItemStack(Material.EMERALD)) {
        ViewAction.NOTHING
    }
}.openView(player, plugin)
```
To open asynchronously, `ViewAction.OpenAsync(Future<View>)`:
```kotlin
viewControl(ItemStack(Material.EMERALD)) {
    val myChestViewFuture: Future<ChestView>
    ViewAction.OpenAsync(myChestViewFuture)
}
```
To update just contents, `ViewAction.Update` also `ViewAction.UpdateAsync(Future<ViewContents>)`
```kotlin
viewControl(ItemStack(Material.IRON_INGOT)) {
    ViewAction.Update(newContents)
}
```
On close the view:
```kotlin
chestView("title", 6, { //ChestViewBuilder ->
    controls[slot(2, 3)] = viewControl(ItemStack(Material.EMERALD)) {
        ViewAction.NOTHING
    }
}) { // CloseEvent ->
    ViewAction.NOTHING // or ViewAction.REOPEN
}
```
or closeEvent View
```kotlin
chestView("title", 6) { //ChestViewBuilder ->
    controls[slot(1, 8)] = viewControl(ItemStack(Material.EMERALD)) {
        ViewAction.NOTHING
    }
    closeEvent { // CloseEvent ->
        ViewAction.NOTHING
    }
}
```
---
### PageViewLayout
```kotlin
pageViewLayout("title", 6) {
    elements = Material.values()
        .filter { mat -> mat.isItem && !mat.isAir }
        .map { material -> functionViewControl(material.toItem(1)) {
            val player: Player = clicker
            if (player.isOp) {
                clicker.inventory.addItem(material.toItem(1))
            }
            ViewAction.NOTHING
        }}.toMutableList()
    
}.toView(1).openView(player, plugin)
```
valuate a single page from the layout and open:

```kotlin
val pageViewLayout : PageViewLayOut = TODO()
pageViewLayout.toView(1).openView(player, plugin)
```

### ViewControl

Constructions:

`viewControl(ItemStack, ClickEvent.() -> ViewAction>)`

> (ItemStack, ClickEvent -> ViewAction) -> ViewItem

`functionViewControl(ItemStack, ClickEvent.() -> ViewAction>)`  

> (ItemStack, ClickEvent -> ViewAction) -> Function<PageContext, ViewControl>  
