import io.quarkus.logging.Log;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.inject.Named;


@ApplicationScoped
@Named("consumerBeanBinding")
public class ConsumerBeanBinding {
    public String doSomething(String body){
        Log.info(String.format("I received %s!", body));
        return body;
    }
}
