import io.dropwizard.Application;
import io.dropwizard.setup.Environment;
import resource.SampleResources;

/**
 * Created by sboob on 5/27/2016.
 */
public class ServerApplication extends Application<MyConfiguration> {
    @Override
    public void run(MyConfiguration myConfiguration, Environment environment) throws Exception {
        SampleResources sampleResources =new SampleResources(myConfiguration.getMessage());
        environment.jersey().register(sampleResources);
    }

    public static  void main(String args[]) throws Exception {
        new ServerApplication().run(args);
    }
}
