package cloud.acog.plugin

import cloud.acog.bukkitview.kotlin.chestView
import cloud.acog.bukkitview.kotlin.viewItem
import org.bukkit.Material
import org.bukkit.command.Command
import org.bukkit.command.CommandSender
import org.bukkit.inventory.ItemStack
import org.bukkit.plugin.java.JavaPlugin

class BukkitPlugin : JavaPlugin() {
    override fun onDisable() {
        super.onDisable()
    }

    override fun onEnable() {
        super.onEnable()
    }

    override fun onCommand(sender: CommandSender, command: Command, label: String, args: Array<out String>): Boolean {
        val chestView = chestView("플레이어 리스트", 6) {
            title = "Tes"
            slot(4) {
                item
            }
        }
        return false
    }
}