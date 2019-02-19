package Modelo;

import Controlador.Factura;
import Controlador.Tarifa;

import java.util.Calendar;
import java.util.HashMap;

public class CRUDFactura {

    private Factura factura;

    HashMap<String, Factura> mapaFactuarsNIF = new HashMap<>();             //nif como clave
    HashMap<String, Factura> mapaFactuarsCod = new HashMap<>();             //codfac como clave


    public void emitirFactura(String codfac, Tarifa tarifa, Calendar periodoFac){

        //float importe = tarifa.valor*
        //factura = new Factura(codfac, tarifa, Calendar.getInstance(), periodoFac, importe )

    }

    public Factura getFacturaCodigo(String codfac){
        return mapaFactuarsCod.get(codfac);
    }

    public Factura getFacturaCliente(String NIF){
        return mapaFactuarsNIF.get(NIF);
    }


}
