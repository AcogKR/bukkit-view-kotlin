package cloud.acog.bukkitview.kotlin

import org.bukkit.Material
import org.bukkit.inventory.ItemStack

fun item(material: Material, display: String, lore: List<String>) : ItemStack {
    val item = ItemStack(material, 1)
    val meta = item.itemMeta ?: return ItemStack(Material.AIR)
    meta.setDisplayName(display)
    meta.lore = lore
    item.itemMeta = meta
    return item
}