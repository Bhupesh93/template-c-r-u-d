import com.fasterxml.jackson.annotation.JsonProperty;
import io.dropwizard.Configuration;
import org.hibernate.validator.constraints.NotEmpty;

/**
 * Created by sboob on 5/27/2016.
 */
public class MyConfiguration extends Configuration {

    public String getMongoDbHostIp() {
        return mongoDbHostIp;
    }

    public void setMongoDbHostIp(String mongoDbHostIp) {
        this.mongoDbHostIp = mongoDbHostIp;
    }

    public String getMongoDbHostPort() {
        return mongoDbHostPort;
    }

    public void setMongoDbHostPort(String mongoDbHostPort) {
        this.mongoDbHostPort = mongoDbHostPort;
    }

    public String getMongoDbName() {
        return mongoDbName;
    }

    public void setMongoDbName(String mongoDbName) {
        this.mongoDbName = mongoDbName;
    }

    @NotEmpty
    private  String mongoDbHostIp;

    @NotEmpty
    private  String mongoDbHostPort;

    @NotEmpty
    private  String mongoDbName;

    @NotEmpty
    private  String message;


    @JsonProperty
    public String getMessage() {
        return message;
    }
    @JsonProperty
    public void setMessage(String message) {
        this.message = message;
    }
}
