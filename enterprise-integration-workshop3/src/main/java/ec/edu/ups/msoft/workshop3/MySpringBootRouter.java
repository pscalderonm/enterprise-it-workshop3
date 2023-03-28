package ec.edu.ups.msoft.workshop3;

import org.apache.camel.builder.RouteBuilder;
import org.apache.camel.component.jackson.JacksonDataFormat;
import org.apache.camel.http.base.HttpOperationFailedException;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Component;

/**
 * A simple Camel route that triggers from a timer and calls a bean and prints to system out.
 * <p/>
 * Use <tt>@Component</tt> to make Camel auto detect this route when starting.
 */
@Component
public class MySpringBootRouter extends RouteBuilder {

    private final JacksonDataFormat jacksonDataFormat = new JacksonDataFormat(ClientOutput.class);

    @Value("${service.system-abc-host}")
    private String system123Host;

    @Value("${service.system-123-host}")
    private String systemABCHost;

    @Override
    public void configure() {
        /*from("timer:hello?period={{timer.period}}").routeId("hello")
            .transform().method("myBean", "saySomething")
            .filter(simple("${body} contains 'foo'"))
                .to("log:foo")
            .end()
            .to("stream:out");*/

        from("direct:client_transfer")
                .transform().method("converterBean", "convert")
                .setHeader("Content-Type").constant("application/json")
                .doTry()
                    .choice()
                        .when().simple("'digital' == ${body.buyingProfile.channel}")
                            .log("Forwarding to system 123 ;)")
                            .marshal(jacksonDataFormat)
                            .to(String.format("rest:post:/Client?host=%s", system123Host))
                        .when().simple("'digitalAndPos' == ${body.buyingProfile.channel}")
                            .log("Forwarding to system ABC :)")
                            .marshal(jacksonDataFormat)
                            .to(String.format("rest:post:/clients?host=%s", systemABCHost))
                        .otherwise()
                            .log("No buying channel recognized for routing. :(")
                    .end()
                .endDoTry()
                .doCatch(HttpOperationFailedException.class)
                .onWhen(exceptionMessage().contains("400"))
                    .log("The client already exists in the destination system")
                .to("stream:out");
    }

}
