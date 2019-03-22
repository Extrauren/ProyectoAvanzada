package Modelo;

import Controlador.Factura;
import Controlador.Tarifa;
import Excepciones.FacturaNoExisteException;

import java.io.Serializable;
import java.util.Calendar;
import java.util.HashMap;

public class CRUDFactura implements Serializable {

    HashMap<String, Factura> mapaFactuarsCod = new HashMap<>();             //codfac como clave

    public void emitirFactura(String codfac, Tarifa tarifa, Calendar fechaFin){
        Factura factura;
        float importe = tarifa.valor;
        factura = new Factura(codfac,tarifa,fechaFin,importe);
        mapaFactuarsCod.put(codfac, factura);
    }

    public Factura getFacturaCodigo(String codfac) throws FacturaNoExisteException {
        return mapaFactuarsCod.get(codfac);
    }

    public void listarFacturas(){
        System.out.println(mapaFactuarsCod.toString());
    }

}
