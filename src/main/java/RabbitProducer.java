import org.apache.camel.CamelContext;
import org.apache.camel.component.springrabbit.SpringRabbitMQEndpoint;
import org.springframework.amqp.rabbit.connection.ConnectionFactory;

public class RabbitProducer extends org.apache.camel.builder.RouteBuilder{

    @Override
    public void configure() throws Exception {
        from("timer://hello?period=1000")
                .transform(simple("hello world"))
                .to("spring-rabbitmq:test");

        from("spring-rabbitmq:test?exchangeType=fanout&queues=test-queue")
                .bean("consumerBeanBinding", "doSomething");
    }
}
