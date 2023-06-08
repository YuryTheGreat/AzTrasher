package relitestudio.azmine.aztrasher.Listener;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.ItemStack;
import relitestudio.azmine.aztrasher.CustomData.Trashbox;

import java.util.HashMap;

public class EventListener implements Listener {
    //private ItemMaker itemMaker;

    //public EventListener(ItemMaker itemMaker) {
    //    this.itemMaker = itemMaker;
    //}

    @EventHandler
    public void PlayerInteractEvent(PlayerInteractEvent event) {

        Player player = event.getPlayer();
        Action action = event.getAction();
        int x = event.getClickedBlock().getX();
        int y = event.getClickedBlock().getY();
        int z = event.getClickedBlock().getZ();

        //использование мусорки
        if (action == Action.LEFT_CLICK_BLOCK /*|| action == Action.RIGHT_CLICK_BLOCK*/) {

        }
        //Создание и редактирование мусорки
        if (action == Action.RIGHT_CLICK_BLOCK) {
            //Проверка на существование мусорки
            //Если её нет
            HashMap<ItemStack, Double> newTrashBoxType = new HashMap<ItemStack, Double>();
            Trashbox newTrashBox = new Trashbox(x, y, z, newTrashBoxType);

        }
    }
}
