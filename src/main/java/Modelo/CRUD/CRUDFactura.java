package Modelo.CRUD;

import Controlador.Factura;
import Controlador.Llamada;
import Controlador.Tarifas.Tarifa;
import Controlador.Tarifas.TarifaBasica;
import Controlador.Tarifas.TarifaDias;
import Controlador.Tarifas.TarifaHoras;
import Modelo.Excepciones.ClienteNoExisteException;
import Modelo.Excepciones.FacturaNoExisteException;
import Modelo.Factory.FabricaTarifa;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;

public class CRUDFactura implements Serializable {

    HashMap<String, Factura> mapaFactuarsCod = new HashMap<>();             //codfac como clave
    ArrayList<Factura> listaFacturas = new ArrayList<>();
    ModeloCliente modeloCliente = new ModeloCliente();
    CRUDLlamada crudLlamada = new CRUDLlamada();



    public void emitirFactura(String nif) throws ClienteNoExisteException {
        FabricaTarifa fabricaTarifa = new FabricaTarifa();
        ArrayList<Tarifa> tarifas = modeloCliente.getCliente(nif).getTarifa();
        ArrayList<Llamada> llamadas = crudLlamada.muestraLlamadaCliente(nif);
        boolean tieneHoras = false;
        boolean tieneDias = false;
        TarifaDias tarifaDias = null;
        TarifaHoras tarifaHoras = null;
        TarifaBasica tarifaBasica = null;
        for(Tarifa tarifa : tarifas){
            if(tarifa.getClass().equals(tarifaDias)){
                tieneDias = true;
                tarifaDias = (TarifaDias) tarifa;
            }else if(tarifa.getClass().equals(tarifaHoras)){
                tieneHoras=true;
                tarifaHoras = (TarifaHoras) tarifa;
            }
        }
        float importe=0;
        for(Llamada llamada : llamadas){
            if(tieneDias && tarifaDias.getDia()==llamada.getFecha().getTime().getDay()){
                importe += llamada.getDuracion()*tarifaDias.getPrecio();
            }else if (tieneHoras && llamada.getFecha().getTime().getHours()>= tarifaHoras.getHoraIni() && llamada.getFecha().getTime().getHours()<= tarifaHoras.getHoraFin()){
                importe += llamada.getDuracion()*tarifaHoras.getPrecio();
            }else{
                importe += llamada.getDuracion()*tarifaBasica.getPrecio();
            }
        }
        System.out.println("El importe de la factura es: " + importe);
    }

    public Factura getFacturaCodigo(String codfac) throws FacturaNoExisteException {
        return mapaFactuarsCod.get(codfac);
    }

    public void listarFacturas(){
        System.out.println(mapaFactuarsCod.toString());
    }

    public ArrayList<Factura> getListaFacturas(){ return listaFacturas;}
}
