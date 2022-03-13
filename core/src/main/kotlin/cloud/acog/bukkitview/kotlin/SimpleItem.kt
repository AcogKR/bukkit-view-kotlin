package cloud.acog.bukkitview.kotlin

import org.bukkit.Material
import org.bukkit.inventory.ItemStack
import org.bukkit.inventory.meta.ItemMeta

fun Material.toItem(amount: Int) = ItemStack(this, amount)

fun item(material: Material, amount: Int = 1) = material.toItem(amount)

fun item(material: Material, amount: Int = 1, c: ItemStack.() -> Unit) = material.toItem(amount).apply(c)

fun ItemStack.meta(c: ItemMeta.() -> Unit) = setItemMeta(itemMeta?.apply(c))

fun ItemStack.setDisplayName(display: String) = itemMeta?.setDisplayName(display)

fun ItemStack.setLore(lore: List<String>) { itemMeta?.lore = lore }

inline fun <reified T : ItemMeta> ItemStack.metaOf(configure: T.() -> Unit) {
    val meta = itemMeta
    if (meta is T) {
        meta.configure()
        itemMeta = meta
    } else throw IllegalStateException("$type meta of item isn't ${T::class.java.simpleName}")
}

fun simpleItem(material: Material, display: String, lore: List<String>) : ItemStack {
    return item(material) {
        meta {
            setDisplayName(display)
            setLore(lore)
        }
    }
}