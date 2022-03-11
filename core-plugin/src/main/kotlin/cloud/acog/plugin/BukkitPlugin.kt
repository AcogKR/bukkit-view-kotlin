package cloud.acog.plugin

import cloud.acog.bukkitview.kotlin.*
import io.typecraft.bukkit.view.ViewAction
import io.typecraft.bukkit.view.ViewItem
import io.typecraft.bukkit.view.page.PageContext
import io.typecraft.bukkit.view.page.PageViewLayout
import org.bukkit.Material
import org.bukkit.command.Command
import org.bukkit.command.CommandSender
import org.bukkit.entity.Player
import org.bukkit.inventory.ItemStack
import org.bukkit.plugin.java.JavaPlugin
import java.util.function.Function

class BukkitPlugin : JavaPlugin() {
    override fun onDisable() {
        super.onDisable()
    }

    override fun onEnable() {
        super.onEnable()
    }

    override fun onCommand(sender: CommandSender, command: Command, label: String, args: Array<out String>): Boolean {

        return false
    }

}