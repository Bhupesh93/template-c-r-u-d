package resource;

import Model.TODO;
import com.codahale.metrics.annotation.Timed;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;


@Path("/todo")
@Produces(MediaType.APPLICATION_JSON)
public class Resource {

    TODO todo;
    @GET
    @Produces({MediaType.APPLICATION_JSON})
    @Timed
    public TODO getTodo(){
        todo = new TODO("this is sample todo");
        return todo;
    }

    @POST
    @Timed
    @Consumes({MediaType.APPLICATION_JSON})
    @Produces({MediaType.APPLICATION_JSON})
    public TODO addTodo(TODO todo){
        System.out.println("todo"+todo.getText());
        return todo;
    }
}