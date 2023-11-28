package com.codigomorsa.mycrud.controllers;

import com.codigomorsa.mycrud.model.Piezas_Compradas;
import com.codigomorsa.mycrud.repositories.PiezaRepository;
import com.codigomorsa.mycrud.services.PiezasCompradasService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class PiezasCompradasController {
    private PiezasCompradasService PiezasCompradasService;

    public PiezaRepository piezaRepository;

    public PiezaController piezaController;

    public PiezasCompradasController(PiezasCompradasService PiezasCompradasService){
        this.PiezasCompradasService = PiezasCompradasService;
    }

   /* @Autowired
    public PiezasCompradasController(PiezaController piezaController) {
        this.piezaController = piezaController;
    }*/

    @GetMapping("/piezasC")
    public List<Piezas_Compradas> getAllPiezasC(){
        return PiezasCompradasService.getAllPiezasC();
    }

    @PostMapping("/taller/{num-cuenta-taller}/cliente/{numcliente}/servicio/{id-servicio}/pieza")
    public ResponseEntity<String>  createPiezasC2(@RequestBody Piezas_Compradas newPiezasC) {
        return PiezasCompradasService.createPiezasC2(newPiezasC);
    }

   /* @PostMapping("/piezasC")
    public ResponseEntity<String>  createPiezasC(@RequestBody Piezas_Compradas newPiezasC) {
        // Validar que el código de pieza existe
        if (!piezaExists(newPiezasC.getCodigo_pieza())) {
            return new ResponseEntity<>("El código de pieza no existe", HttpStatus.BAD_REQUEST);
        }

        // Aquí puedes realizar otras validaciones si es necesario, como verificar el formato de los otros path variables.

        // Llamar al servicio para crear piezas compradas
        long result = PiezasCompradasService.createPiezasC2(newPiezasC);

        // Retornar la respuesta adecuada (puedes ajustar según sea necesario)
        if (result > 0) {
            return new ResponseEntity<>("Piezas compradas creadas exitosamente", HttpStatus.CREATED);
        } else {
            return new ResponseEntity<>("Error al crear piezas compradas", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    } */


    // Método para verificar si el código de pieza existe en la tabla de piezas
    private boolean piezaExists(String codigoPieza) {
        // Lógica para verificar la existencia del código de pieza en la tabla de piezas
        return piezaController.existsByCodigo(codigoPieza);
    }
}
