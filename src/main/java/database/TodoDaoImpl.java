package database;

import model.TODO;
import org.bson.types.ObjectId;
import org.mongodb.morphia.Datastore;
import org.mongodb.morphia.dao.BasicDAO;
import org.mongodb.morphia.query.Query;
import org.mongodb.morphia.query.UpdateOperations;
import org.mongodb.morphia.query.UpdateResults;

import java.util.List;

/**
 * Created by sboob on 5/29/2016.
 */
public class TodoDaoImpl extends BasicDAO<TODO,ObjectId> implements  TodoDAO {


    Datastore ds;

    public TodoDaoImpl(Class<TODO> entityClass, Datastore ds) {
        super(entityClass, ds);
        this.ds=ds;
    }

    @Override
    public List<TODO> getAllTodo() {
        Query<TODO> query = createQuery();
        return query.asList();
    }

    @Override
    public TODO getTodo(String title) {
        Query<TODO> query = createQuery().field("title").equal(title);
        return query.get();
    }


    @Override
    public UpdateResults updateTodo(TODO newTodo) {
        Query<TODO> query = createQuery().field("title").equal(newTodo.getTitle());
        UpdateOperations<TODO> updateOperations = createUpdateOperations().set("todoDetails",newTodo.getTodoDetails());
        UpdateResults updateResults = update(query,updateOperations);
        if(updateResults.getInsertedCount() > 0)
        {

        }
        return updateResults;
    }

    public void deleteTodo(String title){
        Query<TODO> query = createQuery().field("title").equal(title);
        deleteByQuery(query);
    }

}
