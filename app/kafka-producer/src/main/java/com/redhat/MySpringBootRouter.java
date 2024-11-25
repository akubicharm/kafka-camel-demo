package com.redhat;

import org.apache.camel.builder.RouteBuilder;
import org.springframework.stereotype.Component;

/**
 * A simple Camel route that triggers from a timer and calls a bean and prints
 * to system out.
 * <p/>
 * Use <tt>@Component</tt> to make Camel auto detect this route when starting.
 */
@Component
public class MySpringBootRouter extends RouteBuilder {

    @Override
    public void configure() {
        from("timer:hello?period={{timer.period}}").routeId("hello")
                //.transform().method("myBean", "saySomething")
                .transform().method("householdPower", "generateConsumption")
                .filter(simple("${body} contains 'foo'"))
                .to("log:foo")
                .end()
                .to("stream:out")
                .to("kafka:{{producer.topic}}?brokers={{kafka.bootstrap.url}}");
    }

    /*
    @Override
    public void configure() {
        from("timer:hello?period={{timer.period}}").routeId("hello")
                .transform().method("myBean", "saySomething")
                .filter(simple("${body} contains 'foo'"))
                .to("log:foo")
                .end()
                .to("stream:out")
                .to("kafka:{{producer.topic}}?brokers={{kafka.bootstrap.url}}"
            + "&sslTruststoreLocation={{producer.ssl.truststore.location}}"
            + "&sslTruststorePassword={{producer.ssl.truststore.password}}"
            + "&securityProtocol={{producer.security.protocol}}");
    }    
    */
}
