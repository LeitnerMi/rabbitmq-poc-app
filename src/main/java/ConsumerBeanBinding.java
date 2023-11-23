import io.quarkus.runtime.annotations.RegisterForReflection;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.inject.Named;
import org.apache.camel.Handler;
import org.slf4j.Logger;

@ApplicationScoped
@Named("consumerBeanBinding")
public class ConsumerBeanBinding {

    @Inject
    Logger logger;
    public String doSomething(String body){
        logger.info(String.format("I received %s", body));
        return body;
    }
}
