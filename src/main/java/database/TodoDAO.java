package database;

import model.TODO;
import org.bson.types.ObjectId;
import org.mongodb.morphia.dao.DAO;
import org.mongodb.morphia.query.UpdateResults;

import java.util.List;

/**
 * Created by sboob on 5/29/2016.
 */
public interface TodoDAO extends DAO<TODO,ObjectId> {
    public List<TODO> getAllTodo();
    public TODO getTodo(String title);
    public int updateTodo(TODO newTodo);
    public void deleteTodo(String title);
}
