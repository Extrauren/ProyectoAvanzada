package Modelo;

import Controlador.Factura;
import Controlador.Tarifas.Tarifa;
import Excepciones.FacturaNoExisteException;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashMap;

public class CRUDFactura implements Serializable {

    HashMap<String, Factura> mapaFactuarsCod = new HashMap<>();             //codfac como clave
    ArrayList<Factura> listaFacturas = new ArrayList<>();

    public void emitirFactura(String codfac, Tarifa tarifa, Calendar fechaFin){
        Factura factura;
        float importe = tarifa.precio;
        factura = new Factura(codfac,tarifa,fechaFin,importe);
        mapaFactuarsCod.put(codfac, factura);
        listaFacturas.add(factura);
    }

    public Factura getFacturaCodigo(String codfac) throws FacturaNoExisteException {
        return mapaFactuarsCod.get(codfac);
    }

    public void listarFacturas(){
        System.out.println(mapaFactuarsCod.toString());
    }

    public ArrayList<Factura> getListaFacturas(){ return listaFacturas;}
}
