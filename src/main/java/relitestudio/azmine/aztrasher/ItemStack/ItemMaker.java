package relitestudio.azmine.aztrasher.ItemStack;

import org.bukkit.Material;
import org.bukkit.Tag;
import org.bukkit.inventory.ItemFlag;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.ArrayList;

public class ItemMaker implements ItemData {
    private ItemMeta newItemMeta;

    public ItemStack CreateItemStack(Material material, int amount, ItemMeta meta) {
        ItemStack newItemStack = new ItemStack(material, amount);
        newItemStack.setItemMeta(meta);

        return newItemStack;
    }

    public ItemMeta StandartItemMeta(
            //@Nonnull Material material
    ) {
        return new ItemStack(Material.WOODEN_AXE/*material*/, 1).getItemMeta();
    }

    public ItemMeta CreateStandartMeta(
            //@Nonnull Material material,
            //int amount,
            int model,
            String name,
            ArrayList<String> lore,
            ItemFlag flag,
            Tag tag
    ) {
        //if (amount < 1) {
        //    amount = 1;
        //}
        ItemStack newItemStack = new ItemStack(Material.WOODEN_AXE/*material*/, 1);
        ItemMeta newItemMeta = newItemStack.getItemMeta();
        if (model > 0) {
            newItemMeta.setCustomModelData(model);
        }
        if (lore != null) {
            newItemMeta.setLore(lore);
        }
        if (!name.isEmpty()) {
            newItemMeta.setDisplayName(name);
        }
        if (flag != null) {
            newItemMeta.addItemFlags(flag);
        }
        if (tag != null) {

        }

        return newItemMeta;
    }

}
