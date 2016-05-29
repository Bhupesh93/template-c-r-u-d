package resource;

import database.TodoDAO;
import model.TODO;
import com.codahale.metrics.annotation.Timed;
import org.mongodb.morphia.query.UpdateResults;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.List;


@Path("/todo")
@Produces(MediaType.APPLICATION_JSON)
public class Resource {

    TodoDAO todoDAO;

    public Resource(TodoDAO todoDAO) {
        this.todoDAO = todoDAO;
    }

    @GET
    @Produces({MediaType.APPLICATION_JSON})
    @Timed
    public List<TODO> getTodo(){
        return todoDAO.getAllTodo();
    }

    @GET
    @Path("/{title}")
    @Produces({MediaType.APPLICATION_JSON})
    @Timed
    public TODO getTodo(@PathParam("title")String title){
        return todoDAO.getTodosWithTitle(title);

    }

    @POST
    @Timed
    @Consumes({MediaType.APPLICATION_JSON})
    @Produces({MediaType.APPLICATION_JSON})
    public Response addTodo(TODO todo){
        todoDAO.save(todo);
        return Response.ok().build();
    }

    @PUT
    @Timed
    @Consumes({MediaType.APPLICATION_JSON})
    @Produces({MediaType.APPLICATION_JSON})
    public Response updateTodo(TODO newTodo){

       UpdateResults updateResults = todoDAO.updateDetails(newTodo);
        if(updateResults.getUpdatedCount()>0)
        return Response.ok().build();
        else
            return Response.notModified().build();
    }
}