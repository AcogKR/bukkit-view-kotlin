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
import org.bukkit.inventory.meta.SkullMeta
import org.bukkit.plugin.java.JavaPlugin

class BukkitPlugin : JavaPlugin(){

    override fun onEnable() {
        BukkitView.register(this)
    }


    override fun onDisable() {
        super.onDisable()
    }

    override fun onCommand(sender: CommandSender, command: Command, label: String, args: Array<out String>): Boolean {
        getPlayerHeadPage().toView(1).openView(sender as Player, this)
        return super.onCommand(sender, command, label, args)
    }

    private fun getPlayerHeadPage() : PageViewLayout {
        return pageViewLayout("Player Heads", 6) {
            contents = Bukkit.getOnlinePlayers().map { player ->
                pageViewItem(item(Material.PLAYER_HEAD, 1) {
                    metaOf<SkullMeta> {
                        owningPlayer = player
                        setDisplayName(player.name)
                    }
                }) {
                    if (click.isLeftClick) clicker.teleport(player.location)
                    else if (click.isRightClick) player.kickPlayer("?")
                    ViewAction.CLOSE
                }
            }.toMutableList()
        }
    }
}