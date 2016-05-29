import database.MongoDb;
import database.TodoDAO;
import database.TodoDaoImpl;
import model.TODO;
import model.TODOList;
import io.dropwizard.Application;
import io.dropwizard.setup.Environment;
import resource.Resource;

/**
 * Created by sboob on 5/27/2016.
 */
public class ServerApplication extends Application<MyConfiguration> {
    @Override
    public void run(MyConfiguration myConfiguration, Environment environment) throws Exception {
        TODOList todoList =new TODOList();
        MongoDb mongoDb = new MongoDb(myConfiguration.getMongoDbHostIp(),Integer.parseInt(myConfiguration.getMongoDbHostPort()),myConfiguration.getMongoDbName());
        TodoDAO todoDAO = new TodoDaoImpl(TODO.class,mongoDb.getDb());
        Resource sampleResources =new Resource(todoDAO);
        environment.jersey().register(sampleResources);
    }

    public static  void main(String args[]) throws Exception {
        new ServerApplication().run(args);
    }
}
