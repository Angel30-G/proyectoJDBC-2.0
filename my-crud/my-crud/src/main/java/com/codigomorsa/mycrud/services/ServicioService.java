package com.codigomorsa.mycrud.services;

import com.codigomorsa.mycrud.model.Servicio;
import com.codigomorsa.mycrud.model.Vehiculo;
import com.codigomorsa.mycrud.repositories.ServicioRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ServicioService {
    private final ServicioRepository repository;

    public ServicioService(ServicioRepository repository){
        this.repository = repository;
    }

    public List<Servicio> getAllServicio(){
        return repository.getAllServicio();
    }

    public List<Servicio> getAllServicios() {
        return repository.getAllServicios();
    }



    public long createServicioInicial(Servicio newServicio) {
        return repository.createServicioInicial(newServicio);
    }

    public long createCierreServicio(Servicio newServicio, long idServicio){
        return repository.createCierreServicio(newServicio, idServicio);
    }
    
    public Servicio getServicioById(long id) {
        return repository.getServicioById(id);
    }

   /* public Vehiculo getVehiculoByPlaca(String placa){
        return repository.getVehiculoByPlaca(placa);
    }*/

    public long createServicioP(Servicio newServicioP) {
        return repository.createServicioP(newServicioP);
    }
    public ResponseEntity<String> createServicioPlaca(Servicio newServicioP){
        return repository.createServicioPlaca(newServicioP);
    }

   /* public ResponseEntity<String> createServicioPlaca(Servicio newServicioP){
        return repository.createServicioPlaca(newServicioP);
    } */

   /* public ResponseEntity<String> createServicioPla(Servicio newServicioP){
        return repository.createServicioPla(newServicioP);
    } */

}
