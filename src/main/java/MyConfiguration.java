import com.fasterxml.jackson.annotation.JsonProperty;
import io.dropwizard.Configuration;
import org.hibernate.validator.constraints.NotEmpty;

/**
 * Created by sboob on 5/27/2016.
 */
public class MyConfiguration extends Configuration {

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
