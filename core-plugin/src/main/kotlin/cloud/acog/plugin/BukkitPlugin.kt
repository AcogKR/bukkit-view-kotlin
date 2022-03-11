package cloud.acog.plugin

import cloud.acog.bukkitview.kotlin.*
import io.typecraft.bukkit.view.BukkitView
import io.typecraft.bukkit.view.ViewAction
import io.typecraft.bukkit.view.page.PageViewLayout
import org.bukkit.Bukkit
import org.bukkit.Material
import org.bukkit.command.Command
import org.bukkit.command.CommandSender
import org.bukkit.entity.Player
import org.bukkit.inventory.ItemStack
import org.bukkit.inventory.meta.SkullMeta
import org.bukkit.plugin.java.JavaPlugin

class BukkitPlugin : JavaPlugin() {

    override fun onDisable() {
        super.onDisable()
    }

    override fun onEnable() {
        BukkitView.register(this)
    }

    override fun onCommand(sender: CommandSender, command: Command, label: String, args: Array<out String>): Boolean {
        val player = sender as Player 
        if (player.isOp) openPlayerList().toView(1).openView(player, this)
        return false
    }

    fun openPlayerList() : PageViewLayout {
        return pageViewLayout("Players", 6) {
            contents = Bukkit.getOnlinePlayers().map { player ->
                pageViewItem(getPlayerHead(player)) {
                    clicker.sendMessage("Hello World!")
                    ViewAction.CLOSE
                }
            }.toMutableList()
        }
    }

    fun getPlayerHead(player: Player) : ItemStack {
        val item = ItemStack(Material.PLAYER_HEAD)
        val meta: SkullMeta = item.itemMeta as SkullMeta
        meta.owningPlayer = player
        item.itemMeta = meta
        return item
    }
}