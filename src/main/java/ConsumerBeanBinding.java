import io.quarkus.logging.Log;
import jakarta.enterprise.context.ApplicationScoped;
import org.apache.camel.Consume;

@ApplicationScoped
public class ConsumerBeanBinding {

    @Consume("spring-rabbitmq:topic-exchange?exchangeType=topic&queues=linz-queue")
    public String onLinz(String body) {
        Log.info(String.format("I received %s", body));
        return body;
    }

    @Consume("spring-rabbitmq:topic-exchange?exchangeType=topic&queues=wien-queue")
    public String onWien(String body) {
        Log.info(String.format("I received %s", body));
        return body;
    }
}
