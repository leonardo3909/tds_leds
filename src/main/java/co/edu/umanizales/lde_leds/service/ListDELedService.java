package co.edu.umanizales.lde_leds.service;

import co.edu.umanizales.lde_leds.model.ListDELed;
import lombok.Data;
import org.springframework.stereotype.Service;

@Service
@Data
public class ListDELedService {

    private ListDELed leds;

    public ListDELedService(){
        leds = new ListDELed();
    }
}
