package com.codigomorsa.mycrud.services;

import com.codigomorsa.mycrud.model.Piezas_Compradas;
import com.codigomorsa.mycrud.repositories.PiezasCompradasRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PiezasCompradasService {
    private final PiezasCompradasRepository repository;

    public PiezasCompradasService(PiezasCompradasRepository repository){
        this.repository = repository;
    }

    public List<Piezas_Compradas> getAllPiezasC(){
        return repository.getAllPiezasC();
    }


    public long createPiezasC(Piezas_Compradas newPiezasC) {
        return repository.createPiezasCompradas(newPiezasC);
    }

    public ResponseEntity<String> createPiezasC2(Piezas_Compradas newPiezasC) {
        return repository.createPiezasCompradas2(newPiezasC);
    }


   /* public long createPiezasCompradasCatalogo(Piezas_Compradas newPiezasC){
        return repository.createPiezasCompradasCatalogo(newPiezasC);
    }*/
}
