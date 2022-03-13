package cloud.acog.plugin.utils

import cloud.acog.bukkitview.kotlin.*
import io.typecraft.bukkit.view.ViewAction
import org.bukkit.Bukkit
import org.bukkit.Material
import org.bukkit.entity.Player
import org.bukkit.inventory.meta.SkullMeta
import org.bukkit.plugin.Plugin

fun openChestView(player: Player, plugin: Plugin) {
    chestView("title", 1) {
        slotItem(slot(3, 4), item(Material.CHEST, 1) {
            setDisplayName("Open Page2 ChestView")
        }) {
            //New ChestView Open
            ViewAction.Open(chestView("page2", 2) {
                slotItem(slot(3, 4), item(Material.CHEST, 1) {
                    setDisplayName("Close ChestView")
                }) {
                    ViewAction.NOTHING
                }
            })
        }
    }.openView(player, plugin)
}

fun openPageViewLayout(player: Player, plugin: Plugin) {
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
}