package com.codigomorsa.mycrud.model;

import java.util.Date;
import java.util.List;

public class Vehiculo {

    public final String numero_placa;

    public final String marca;

    public final String modelo;

    public final Date anofabricacion;

    public final String VIN;

    private List<Cliente> clienteList;

    private List<placa> placaList;

    public List<placa> getPlacaList() {
        return placaList;
    }

    public void setPlacaList(List<placa> placaList) {
        this.placaList = placaList;
    }


    public List<Cliente> getClienteList() {
        return clienteList;
    }

    public void setClienteList(List<Cliente> clienteList) {
        this.clienteList = clienteList;
    }

    public String getNumero_placa() {
        return numero_placa;
    }

    public String getMarca() {
        return marca;
    }

    public String getModelo() {
        return modelo;
    }

    public Date getAnofabricacion() {
        return anofabricacion;
    }

    public String getVIN() {
        return VIN;
    }

    public int getCliente() {
        return cliente;
    }

    public final int cliente;


    public Vehiculo(String numeroPlaca, String marca, String modelo, Date anofabricacion, String vin, int cliente) {
        numero_placa = numeroPlaca;
        this.marca = marca;
        this.modelo = modelo;
        this.anofabricacion = anofabricacion;
        VIN = vin;
        this.cliente = cliente;
    }
}
