package co.edu.umanizales.lde_leds.controller;

import co.edu.umanizales.lde_leds.dto.ResponseDTO;
import co.edu.umanizales.lde_leds.model.Led;
import co.edu.umanizales.lde_leds.service.ListDELedService;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "listdeled")
public class ListDELedController {

    @Autowired
    private ListDELedService listDELedService;

    @GetMapping(path = "/add/{id}")
    public ResponseEntity<ResponseDTO> add(@PathVariable String id){

        listDELedService.getLeds().add(new Led(id));

        return new ResponseEntity<>(new ResponseDTO(200,"se adicionado exitosamente el led",null), HttpStatus.OK);
    }

    @GetMapping(path = "/poweON")
    public ResponseEntity<ResponseDTO> turnOn()  {
        listDELedService.getLeds().turnOn();
        return new ResponseEntity<>(new ResponseDTO(
                200, "Se han encendido todos los leds", null), HttpStatus.OK);
    }

    @GetMapping(path = "onoff")
    public ResponseEntity<ResponseDTO> turnOnAndOff() {
        listDELedService.getLeds().turnOnAndOff();

        return new ResponseEntity<>(new ResponseDTO(
                200, "Se han prendido y apagado todos los leds", null), HttpStatus.OK);
    }

    @GetMapping(path = "/reset")
    public ResponseEntity<ResponseDTO> restart()  {
        listDELedService.getLeds().restart();

        return new ResponseEntity<>(new ResponseDTO(
                200, "Se ha reiniciado el proceso de los leds", null), HttpStatus.OK);
    }

    @GetMapping(path = "delete")
    public ResponseEntity<ResponseDTO> delete()  {
        listDELedService.getLeds().delete();

        return new ResponseEntity<>(new ResponseDTO(
                200, "Se han eliminado todos los leds", null), HttpStatus.OK);
    }

}
