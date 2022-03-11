# bukkit-view-kotlin

This is an extension of the bukkit-view-core library. [[bukkit-view]](https://github.com/typecraft-io/bukkit-view)

---


### Example Code

```kotlin
class ViewPlugin : JavaPlugin() {

    override fun onEnable() {
        server.pluginManager.registerEvents(BukkitView.viewListener(this), this)
    }

    override fun onCommand(sender: CommandSender, command: Command, label: String, args: Array<out String>): Boolean {
        val player: Player = sender as Player ?: return
    }
    
}
```

