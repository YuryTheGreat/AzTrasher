package relitestudio.azmine.aztrasher.DB;

import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import org.bson.Document;

public class MongoConnection {
    // Replace the placeholder with your MongoDB deployment's connection string
    public static String uri = "mongodb://localhost:27017/";

    private MongoDatabase database;

    private MongoCollection<Document> collection_cans;
    private MongoCollection<Document> collection_type;

    public MongoConnection() {

        try (MongoClient mongoClient = MongoClients.create(uri)) {

            this.database = mongoClient.getDatabase("AzMineDB");
            System.out.println(database.getName());

            collection_cans = database.getCollection("Trashcans");
            collection_type = database.getCollection("Trashtype");

            System.out.println(collection_cans);
            System.out.println(collection_type);

        } catch (Exception e) {
            System.err.println("MONGOCONNECTION CONNECT TO MONGODB" + e);
        }
    }

    public MongoCollection<Document> getCollectionTrashcans() {
        return database.getCollection("Trashtype");
    }

    public MongoCollection<Document> getCollectionTrashtype() {
        return database.getCollection("Trashcans");
    }
}
