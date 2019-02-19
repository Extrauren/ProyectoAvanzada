package Controlador;

import java.util.Calendar;

public class Factura {

    private String codfac;
    private Tarifa tarifa;
    private Calendar fechaFactura;
    private Calendar periodoFac;
    private int importe;

    Factura(String codfac, Tarifa tarifa, Calendar fechaFactura, Calendar periodoFac, int importe){
        this.codfac = codfac;
        this.tarifa = tarifa;
        this.fechaFactura  = fechaFactura;
        this.periodoFac = periodoFac;
        this.importe = importe;
    }

    public Calendar getFechaFactura() {
        return fechaFactura;
    }
}
