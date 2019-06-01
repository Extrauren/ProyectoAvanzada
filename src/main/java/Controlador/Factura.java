package Controlador;

import Controlador.Tarifas.Tarifa;
import Modelo.Interfaces.Fecha;

import java.io.Serializable;
import java.util.Calendar;

public class Factura implements Serializable, Fecha {

    private String codfac;
    private Tarifa tarifa;
    private Calendar fechaFin;
    private Calendar fechaIni;
    private float importe;

    public Factura(String codfac, Tarifa tarifa, Calendar fechaIni, float importe){
        this.codfac = codfac;
        this.tarifa = tarifa;
        this.fechaIni = fechaIni;
        this.fechaFin = Calendar.getInstance();
        this.importe = importe;
    }

    public Calendar getFecha() {
        return fechaIni;
    }




}
