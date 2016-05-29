package database;

import com.mongodb.MongoClient;
import model.TODO;
import model.TODODetails;
import org.mongodb.morphia.Datastore;
import org.mongodb.morphia.Morphia;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class MongoDb {
    private MongoClient mongoClient;
    private String databaseName;
    private Datastore db;
    Morphia morphia;


    final static Logger logger = LoggerFactory.getLogger(MongoDb.class);

    public MongoDb(String mongoHost, int port, String databaseName) {
        this.mongoClient = new MongoClient(mongoHost, port);
        this.databaseName = databaseName;
        morphia = new Morphia();
        morphia.map(TODO.class).map(TODODetails.class);
        connectToDatabase();
    }

    public Morphia getMorphia() {
        return morphia;
    }

    public void setMorphia(Morphia morphia) {
        this.morphia = morphia;
    }


    public void connectToDatabase() {
        try {
            db = new Morphia().createDatastore(mongoClient, databaseName);
            logger.info("Successfully connected to Database " + databaseName);
        } catch (Exception e) {
            logger.error("Exception while creating database " + e);
        }
    }


    public Datastore getDb() {
        return db;
    }

    public void setDb(Datastore db) {
        this.db = db;
    }
}
