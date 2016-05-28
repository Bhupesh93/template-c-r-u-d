package resource;

import com.codahale.metrics.annotation.Timed;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path("/sample")
@Produces(MediaType.TEXT_HTML)
public class SampleResources {

    String message;

    public SampleResources(String message) {
        this.message =message ;
    }

    @GET
    @Timed
    public String sayHello(){

        return message;
    }
}
