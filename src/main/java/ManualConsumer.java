import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Named;
import org.apache.camel.Handler;

@ApplicationScoped
@Named("manualconsumer")
public class ManualConsumer {


    public String handle(String body) {
        if ((Math.random() * 2) > 1) {
            return "linz";
        } else {
            return "wien";
        }
    }
}
