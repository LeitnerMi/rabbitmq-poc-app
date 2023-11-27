import org.apache.camel.CamelContext;
import org.apache.camel.component.springrabbit.SpringRabbitMQEndpoint;
import org.springframework.amqp.rabbit.connection.ConnectionFactory;

public class RabbitProducer extends org.apache.camel.builder.RouteBuilder{

    @Override
    public void configure() throws Exception {
        String topic;

        if (Math.random() * 2 > 1){
            topic = "linz";
        } else{
            topic = "wien";
        }

        from("timer://hello?period=1000")
                .transform(simple(String.format("Wichtige info für %s! Wert: %s", topic, Math.random())))
                .to("spring-rabbitmq:topic-exchange?routingKey="+topic);
    }
}
