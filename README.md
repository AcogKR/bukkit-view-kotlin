# bukkit-view-kotlin

This is an extension of the bukkit-view-core library. [[bukkit-view]](https://github.com/typecraft-io/bukkit-view)


### Example Code

```kotlin
class ViewPlugin {

    override fun onCommand(sender: CommandSender, command: Command, label: String, args: Array<out String>): Boolean {
        val player: Player = sender as Player ?: return 
        getPageViewManager().openPage(player, 1)
    }
    
    private fun getPageViewManager(): PageViewLayout {
        return pageViewLayout("Page List", 6) {
            contents = pageViewList.map { data -> 
                pageViewItem(ItemStack(Material.AIR)) { // Click Event
                    if (click.isLeftClick) {
                        clicker.sendMessage("left Click")
                        ViewAction.CLOSE
                    } else {
                        ViewAction.NOTHING
                    }
                }
            }.toMutableList()
        }
    }
    
}
```

