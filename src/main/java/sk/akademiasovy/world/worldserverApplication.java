package sk.akademiasovy.world;

import io.dropwizard.Application;
import io.dropwizard.setup.Bootstrap;
import io.dropwizard.setup.Environment;
import sk.akademiasovy.world.resources.HelloWorld;
import sk.akademiasovy.world.resources.World;

public class worldserverApplication extends Application<worldserverConfiguration> {

    public static void main(final String[] args) throws Exception {
        new worldserverApplication().run(args);
    }

    @Override
    public String getName() {
        return "worldserver";
    }

    @Override
    public void initialize(final Bootstrap<worldserverConfiguration> bootstrap) {
        // TODO: application initialization
    }

    @Override
    public void run(final worldserverConfiguration configuration,
                    final Environment environment) {
        // TODO: implement application
        environment.jersey().register(
                new HelloWorld()
        );

        environment.jersey().register(
                new World()
        );
    }

}
