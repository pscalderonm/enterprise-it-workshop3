package ec.edu.ups.msoft.workshop3;

import org.apache.camel.ProducerTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController()
public class ClientRestController  {

    @Autowired private ProducerTemplate producerTemplate;

    @PostMapping("/clients/transfer")
    public ResponseEntity<Void> transferClient(@RequestBody ClientModel model){
        producerTemplate.sendBody("direct:client_transfer", model);
        return ResponseEntity.ok().build();
    }
}
