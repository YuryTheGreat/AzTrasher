package relitestudio.azmine.aztrasher;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.plugin.java.JavaPlugin;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import relitestudio.azmine.aztrasher.CustomData.TrashboxType;
import relitestudio.azmine.aztrasher.DB.MongoConnection;
import relitestudio.azmine.aztrasher.ItemStack.ItemData;
import relitestudio.azmine.aztrasher.ItemStack.ItemMaker;
import relitestudio.azmine.aztrasher.Listener.CommandListener;
import relitestudio.azmine.aztrasher.Listener.EventListener;

public final class Main extends JavaPlugin {

    ItemData Maker = new ItemMaker();

    @Override
    public void onEnable() {
        Logger logger = LoggerFactory.getLogger("MyApp");
        logger.error("Logging an Error");

        getLogger().info("Plugin AzTrasher is very good");

        //Creating itemStacks
        ItemMeta newMeta = new ItemMaker().CreateStandartMeta(
                0,
                "На, КУЙ!",
                null,
                null,
                null
        );
        ItemStack newStack = Maker.CreateItemStack(Material.ANVIL, 10, newMeta);

        ItemMeta newMeta1 = Maker.CreateStandartMeta(
                0,
                "Item_1",
                null,
                null,
                null
        );

        ItemStack newStack1 = Maker.CreateItemStack(Material.SAND, 10, newMeta1);
        //Creating new trashboxType
        MongoConnection db = new MongoConnection();
        TrashboxType newType = new TrashboxType(db.getCollectionTrashtype());
        //Add itemStacks
        newType.addItem(newStack1, 0.5);
        newType.addItem(newStack, 0.5);
        //Saving trashboxType
        try {
            newType.save("newType");
            newType.insertItemsToTrashboxType();
        } catch (Exception e) {
            System.err.println(e);
        }

        //db.saveTrashtype("newType");


        //Events
        Bukkit.getPluginManager().registerEvents(new EventListener(/*ClassItemMaker*/), this);
        //Commands
        CommandListener listener = new CommandListener();
        getCommand("createTrashboxType").setExecutor(listener);
        getCommand("addItemToTrashboxType").setExecutor(listener);
    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }
}
