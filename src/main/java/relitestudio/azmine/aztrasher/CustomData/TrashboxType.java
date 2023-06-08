package relitestudio.azmine.aztrasher.CustomData;

import com.mongodb.client.MongoCollection;
import com.mongodb.client.result.InsertOneResult;
import org.bson.Document;
import org.bson.types.ObjectId;
import org.bukkit.inventory.ItemFlag;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.jetbrains.annotations.NotNull;

import java.util.*;

public class TrashboxType {
    private HashMap<ItemStack, Double> itemAndChance;

    private MongoCollection<Document> collection_type;

    public TrashboxType(@NotNull MongoCollection<Document> collection_type) {
        this.collection_type = collection_type;

        try {
            collection_type.insertOne(new Document().append("test", "test"));
        } catch (Exception e) {
            System.err.println("TRASHBOXTYPE INSERT" + e);
        }


        this.itemAndChance = new HashMap<ItemStack, Double>();
    }

    public void save(String name) {
        InsertOneResult result = collection_type.insertOne(new Document()
                .append("_id", new ObjectId())
                .append("type", name)
                .append("items", new ArrayList<>())
        );

        System.out.println(result);
    }

    public void insertItemsToTrashboxType() {

        List<Document> ItemsForMongo = new ArrayList();

        for (Map.Entry<ItemStack, Double> entry : this.itemAndChance.entrySet()) {
            ItemStack stack = entry.getKey();
            if (stack == null) {
                System.err.println("Stack is null");
                return;
            }

            Double chance = entry.getValue();

            ItemMeta meta = stack.getItemMeta();

            Document trashItem = new Document()
                    .append("id", String.valueOf(stack.getType()))
                    .append("count", stack.getAmount())
                    .append("name", meta.getDisplayName())
                    .append("lore", meta.getLore())
                    .append("model", meta.getCustomModelData())
                    .append("chance", chance);

            System.out.println(trashItem.toJson());

            Set<ItemFlag> flags = meta.getItemFlags();
            List<String> flagsString = new ArrayList();
            while (flags.iterator().hasNext()) {
                flagsString.add(
                        flags
                                .iterator()
                                .next()
                                .toString()
                );
            }

            ItemsForMongo.add(trashItem
                    .append("flags", flagsString)
            );


        }

        Document trashItems = new Document()
                .append("items", ItemsForMongo);

        try {
            collection_type.insertOne(trashItems);
        } catch (Exception e) {
            System.err.println("MONGODB" + e);
        }
    }

    public void addItem(ItemStack stack, Double chance) {
        this.itemAndChance.put(stack, chance);
        System.out.println("Add item to trashboxType");
    }

}
