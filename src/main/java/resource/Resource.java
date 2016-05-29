package resource;

import com.codahale.metrics.annotation.Timed;
import database.TodoDAO;
import model.TODO;

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
    public List<TODO> getTodo() {
        return todoDAO.getAllTodo();
    }

    @GET
    @Path("/{title}")
    @Produces({MediaType.APPLICATION_JSON})
    @Timed
    public TODO getTodo(@PathParam("title") String title) {
        return todoDAO.getTodo(title);

    }

    @POST
    @Timed
    @Consumes({MediaType.APPLICATION_JSON})
    @Produces({MediaType.APPLICATION_JSON})
    public Response addTodo(TODO todo) {
        todoDAO.save(todo);
        return Response.ok().build();
    }

    @PUT
    @Timed
    @Consumes({MediaType.APPLICATION_JSON})
    @Produces({MediaType.APPLICATION_JSON})
    public Response updateTodo(TODO newTodo) {

        int updatedCount = todoDAO.updateTodo(newTodo);
        if (updatedCount > 0)
            return Response.ok().build();
        else
            return Response.notModified().build();
    }

    @DELETE
    @Timed
    @Path("/{title}")
    @Produces({MediaType.APPLICATION_JSON})
    public Response deleteTodo(@PathParam("title") String title) {
        todoDAO.deleteTodo(title);
        return Response.ok().build();
    }
}