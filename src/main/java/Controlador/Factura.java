package Controlador;

import Controlador.Tarifas.Tarifa;
import Modelo.Interfaces.Fecha;

import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.Calendar;

public class Factura implements Serializable, Fecha {

    private String NIF;
    private String codfac;
    private Tarifa tarifa;
    private Calendar fechaFin;
    private Calendar fechaIni;
    private float importe;

    public Factura(String NIF, String codfac, Tarifa tarifa, Calendar fechaIni, float importe){
        this.NIF = NIF;
        this.codfac = codfac;
        this.tarifa = tarifa;
        this.fechaIni = fechaIni;
        this.fechaFin = Calendar.getInstance();
        this.importe = importe;
    }

    public Calendar getFecha() {
        return fechaIni;
    }

    private String fechaTexto(Calendar fecha){
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        return sdf.format(fecha.getTime());
    }

    @Override
    public String toString() {
        return "Nif: " + NIF
                +" Codigo: " + codfac
                +" tarifa: " + tarifa
                +" fecha inicio: " + fechaIni
                +" fecha fin: " + fechaFin
                +" importe: " + importe;
    }
}
