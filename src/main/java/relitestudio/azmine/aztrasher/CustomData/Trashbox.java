package relitestudio.azmine.aztrasher.CustomData;

import com.mongodb.client.MongoCollection;
import com.mongodb.client.result.InsertOneResult;
import org.bson.Document;
import org.bson.types.ObjectId;
import org.bukkit.inventory.ItemStack;
import org.jetbrains.annotations.NotNull;

import java.util.HashMap;

public class Trashbox {
    private int x;
    private int y;
    private int z;
    private HashMap<ItemStack, Double> TrashboxType;

    public Trashbox(int x, int y, int z, HashMap<ItemStack, Double> type) {

        this.x = x;
        this.y = y;
        this.z = z;
        this.TrashboxType = type;
    }

    public boolean CheckLocation(int x, int y, int z) {
        if (this.x == x && this.y == y && this.z == z) {
            return true;
        }
        return false;
    }

    public int getX() {
        return this.x;
    }

    public int getY() {
        return this.y;
    }

    public int getZ() {
        return this.z;
    }

    public Object getType() {
        return this.TrashboxType;
    }

    public void save(@NotNull MongoCollection<Document> collection_trashbox) {
        InsertOneResult result = collection_trashbox.insertOne(new Document()
                .append("_id", new ObjectId())
                .append("x", this.x)
                .append("y", this.y)
                .append("z", this.z)
                .append("type", this.TrashboxType)
        );
    }
}
