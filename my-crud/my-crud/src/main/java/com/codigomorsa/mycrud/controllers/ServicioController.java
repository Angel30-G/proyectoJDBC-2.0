package com.codigomorsa.mycrud.controllers;

import com.codigomorsa.mycrud.model.Servicio;
import com.codigomorsa.mycrud.model.Vehiculo;
import com.codigomorsa.mycrud.services.ServicioService;
import com.codigomorsa.mycrud.services.VehiculoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;


import java.util.List;

@RestController
public class ServicioController {
    private final ServicioService ServicioService;

    //private VehiculoService vehiculoService;
    public Servicio servicio;

    public Vehiculo vehiculo;

    private VehiculoController vehiculoController;

    public ServicioController(ServicioService ServiceService){
        this.ServicioService = ServiceService;
    }


    private ServicioService servicioService;

    private VehiculoService vehiculoService;  // Asegúrate de tener la anotación @Autowired para la inyección de dependencias

   /* @GetMapping("/taller/{idTaller}/cliente/{idCliente}/servicio/{idServicio}")
    public ResponseEntity<Servicio> getServicioById(@PathVariable long idServicio) {

        // Aquí puedes agregar lógica para validar que el servicio pertenezca al cliente y taller indicados

        Servicio servicio = ServicioService.getServicioById(idServicio);
        if (servicio != null) {
            return new ResponseEntity<>(servicio, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    } */

    @GetMapping("/taller/{idTaller}/cliente/{idCliente}/servicio/{idServicio}")
    public ResponseEntity<Servicio> getServicioById(@PathVariable long idServicio) {
        Servicio servicio = servicioService.getServicioById(idServicio);

        if (servicio != null) {
            return new ResponseEntity<>(servicio, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }


    @GetMapping("/servicioV")
    public List<Servicio> getAllServicio(){
        return ServicioService.getAllServicio();
    }

    @GetMapping("/servicio")
    public List<Servicio> getAllServicios() {
        return ServicioService.getAllServicios();
    }



  /*  @PostMapping("/taller/{id}/cliente/{id}/servicio")
    public long createServicio(@RequestBody Servicio newServicio) {
        return ServicioService.createServicioInicial(newServicio);
    } */

   /* @PostMapping("/placa")
    public ResponseEntity<String> createServicioPlaca(@RequestBody Servicio newServicio) {
        return ServicioService.createServicioPlaca(newServicio);
    } */



    @PatchMapping("/taller/{id}/cliente/{id}/servicio/{id}")
    public long createCierreServicio(@RequestBody Servicio newServicio,  long idServicio){
        return ServicioService.createCierreServicio(newServicio, idServicio);
    }

    @PostMapping("/taller/{num-cuenta-taller}/cliente/{numcliente}/servicio")
    public ResponseEntity<String> createServicioPlaca(@RequestBody Servicio newServicio){
        return ServicioService.createServicioPlaca(newServicio);
    }
    
}

