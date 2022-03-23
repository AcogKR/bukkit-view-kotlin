package cloud.acog.plugin

import cloud.acog.bukkitview.kotlin.*
import io.typecraft.bukkit.view.BukkitView
import io.typecraft.bukkit.view.ChestView
import io.typecraft.bukkit.view.ViewAction
import io.typecraft.bukkit.view.page.PageViewLayout
import org.bukkit.Material
import org.bukkit.command.Command
import org.bukkit.command.CommandSender
import org.bukkit.entity.Player
import org.bukkit.plugin.java.JavaPlugin

class BukkitPlugin : JavaPlugin(){

    override fun onEnable() {
        BukkitView.register(this)
    }

    override fun onCommand(sender: CommandSender, command: Command, label: String, args: Array<out String>): Boolean {
        val player: Player = if (sender is Player && sender.isOp) sender else return false
        val head: String = if (args.isEmpty()) "" else args[0]

        when (head) {
            "page" -> {
                createMyViewLayout().toView(1).openView(player, this)
            }
            "chest" -> {
                createChestView().openView(player, this)
            }
            else -> {
                listOf(
                    "§a/${label} page: §fshow a demo pagination view.",
                    "§a/${label} chest: §fshow a demo chest view."
                ).forEach(player::sendMessage)
            }
        }
        return true
    }

    private fun createChestView() : ChestView {
        return chestView("title", 6) {
            controlItem(slot(3, 5), simpleItem(Material.IRON_INGOT, "ViewControl Item"))
            itemSlot(slot(3, 3), simpleItem(Material.CHEST, "Bukkit ItemStack"))
            closeEvent {
                ViewAction.NOTHING
            }
        }
    }

    private fun createMyViewLayout() : PageViewLayout {
        return pageViewLayout("Player Heads", 6) {
            elements = Material.values()
                .filter { mat -> mat.isItem && !mat.isAir }
                .map { material -> functionViewControl(material.toItem(1)) {
                    val player: Player = clicker
                    if (player.isOp) {
                        clicker.inventory.addItem(material.toItem(1))
                    }
                    ViewAction.NOTHING
                }
            }.toMutableList()
        }
    }
}