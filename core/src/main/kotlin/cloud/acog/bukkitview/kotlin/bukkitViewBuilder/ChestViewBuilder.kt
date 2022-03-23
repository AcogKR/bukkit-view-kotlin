package cloud.acog.bukkitview.kotlin.bukkitViewBuilder

import io.typecraft.bukkit.view.*
import org.bukkit.inventory.ItemStack

import java.util.function.Function

class ChestViewBuilder(
    var title: String,
    val row: Int,
    var controls: MutableMap<Int, ViewControl>,
    var contents: MutableMap<Int, ItemStack>,
    var onClose: Function<CloseEvent, ViewAction>
) {

    companion object {
        fun just(title: String, row: Int) : ChestViewBuilder {
            return ChestViewBuilder(title, row, mutableMapOf(), mutableMapOf()) { ViewAction.NOTHING }
        }
    }

    fun asChestView() : ChestView = ChestView.of(
        title, row, ViewContents.of(controls, contents), onClose
    )
}



