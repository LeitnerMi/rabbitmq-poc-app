import jakarta.enterprise.inject.Produces;
import jakarta.inject.Inject;
import jakarta.inject.Singleton;
import org.eclipse.microprofile.config.inject.ConfigProperty;
import org.springframework.amqp.rabbit.connection.CachingConnectionFactory;

@Singleton
public class RabbitMQConfig {

    @Produces
    @Singleton
    public CachingConnectionFactory rabbitConnectionFactory() {
        CachingConnectionFactory connectionFactory = new CachingConnectionFactory();
        connectionFactory.setHost("hello-world.hello-world-cluster.svc.cluster.local");
        connectionFactory.setPort(5672);
        connectionFactory.setUsername("test-user");
        connectionFactory.setPassword("test-password");
//        connectionFactory.setVirtualHost("/");
        return connectionFactory;
    }
}
