package Controlador;

import Controlador.Tarifas.Tarifa;

import java.io.Serializable;
import java.util.Calendar;

public class Factura implements Serializable, Fecha {

    private String codfac;
    private Tarifa tarifa;
    private Calendar fechaFin;
    private Calendar fechaIni;
    private float importe;

    public Factura(String codfac, Tarifa tarifa, Calendar fechaFin, float importe){
        this.codfac = codfac;
        this.tarifa = tarifa;
        this.fechaIni = Calendar.getInstance();
        this.fechaFin = fechaFin;
        this.importe = importe;
    }

    public Calendar getFecha() {
        return fechaIni;
    }




}
