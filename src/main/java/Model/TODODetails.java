package model;

import org.mongodb.morphia.annotations.Embedded;

/**
 * Created by sboob on 5/28/2016.
 */
@Embedded
public class TODODetails {

    public TODODetails() {

    }
    public TODODetails(String description) {
        super();
        this.description = description;
    }


    private String description;


    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }


}
