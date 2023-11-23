import jakarta.enterprise.inject.Produces;
import jakarta.inject.Singleton;
import org.springframework.amqp.rabbit.connection.CachingConnectionFactory;

@Singleton
public class RabbitMQConfig {

    @Produces
    @Singleton
    public CachingConnectionFactory rabbitConnectionFactory() {
        CachingConnectionFactory connectionFactory = new CachingConnectionFactory();
        connectionFactory.setHost("10.244.0.21");
        connectionFactory.setPort(5672);
        connectionFactory.setUsername("default_user_llvo5vut93_YmhmKLql");
        connectionFactory.setPassword("84AZH2wckx3bK3Jsg7BlHwosvIKAdq99");
//        connectionFactory.setVirtualHost("/");
        return connectionFactory;
    }
}
