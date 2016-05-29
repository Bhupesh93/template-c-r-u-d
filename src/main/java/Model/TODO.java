package model;

import org.bson.types.ObjectId;
import org.mongodb.morphia.annotations.Embedded;
import org.mongodb.morphia.annotations.Entity;
import org.mongodb.morphia.annotations.Id;

import javax.xml.bind.annotation.XmlRootElement;

/**
 * Created by sboob on 5/28/2016.
 */
@XmlRootElement
@Entity
public class TODO {

    @Id
    private ObjectId id;
    private String title;

    @Embedded
    private TODODetails todoDetails;
    public TODO(){

    }

    public TODO(String title, TODODetails todoDetails) {
        super();
        this.title = title;
        this.todoDetails = todoDetails;
    }

    public Object getId() {  return id;  }

    public void setId(ObjectId id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public TODODetails getTodoDetails() {
        return todoDetails;
    }

    public void setTodoDetails(TODODetails todoDetails) {
        this.todoDetails = todoDetails;
    }


}
