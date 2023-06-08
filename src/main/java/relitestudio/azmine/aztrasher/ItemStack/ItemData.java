package relitestudio.azmine.aztrasher.ItemStack;

import org.bukkit.Material;
import org.bukkit.Tag;
import org.bukkit.inventory.ItemFlag;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.ArrayList;

public interface ItemData {
    public ItemStack CreateItemStack(Material material, int amount, ItemMeta meta);

    public ItemMeta CreateStandartMeta(int model,
                                       String name,
                                       ArrayList<String> lore,
                                       ItemFlag flag,
                                       Tag tag);

}
