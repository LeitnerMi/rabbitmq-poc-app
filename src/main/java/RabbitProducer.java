public class RabbitProducer extends org.apache.camel.builder.RouteBuilder {

    @Override
    public void configure() throws Exception {

//        from("timer://hello?period=1000")
//                .transform(simple(String.format("Wichtige info für %s! Wert: %s", "Linz", Math.random())))
//                .to("spring-rabbitmq:topic-exchange?routingKey=linz");


        from("timer://hello?period=1000")
                .bean("manualconsumer", "handle")
                .choice()
                .when(body().contains("linz"))
                .setBody(simple("Hey Linz"))
                .to("spring-rabbitmq:topic-exchange?routingKey=linz")
                .otherwise()
                .to("spring-rabbitmq:topic-exchange?routingKey=wien")
                .end();

    }
}
