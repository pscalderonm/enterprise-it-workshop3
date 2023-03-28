package ec.edu.ups.msoft.workshop3;

import org.apache.camel.Exchange;
import org.springframework.stereotype.Component;

@Component("converterBean")
public class ClientConverter {

    public ClientOutput convert(ClientModel input, Exchange exchange){
        return new ClientOutput(input);
    }
}
