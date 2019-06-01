package Modelo;

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
import java.util.Calendar;
import java.util.HashMap;

public class ModeloFactura implements Serializable {

    private HashMap<String, Factura> mapaFactuarsCod = new HashMap<>();             //codfac como clave
    private ArrayList<Factura> listaFacturas = new ArrayList<>();
    private ModeloCliente modeloCliente;
    private ModeloLlamada modeloLlamada;

    public ModeloFactura(ModeloCliente modCLi, ModeloLlamada modLlama){
        this.modeloCliente = modCLi;
        this.modeloLlamada = modLlama;
    }

    public void emitirFactura(String nif) throws ClienteNoExisteException {
        FabricaTarifa fabricaTarifa = new FabricaTarifa();
        ArrayList<Tarifa> tarifas = modeloCliente.getCliente(nif).getTarifa();
        ArrayList<Llamada> llamadas = modeloLlamada.muestraLlamadaCliente(nif);
        boolean tieneHoras = false;
        boolean tieneDias = false;
        //TarifaDias tarifaDias = null;
        //TarifaHoras tarifaHoras = null;
        Tarifa tarifa = tarifas.get(0);
        /*for(Tarifa tarifa : tarifas){
            if(tarifa.getClass().equals(tarifaDias)){
                tieneDias = true;
                tarifaDias = (TarifaDias) tarifa;
            }else if(tarifa.getClass().equals(tarifaHoras)){
                tieneHoras=true;
                tarifaHoras = (TarifaHoras) tarifa;
            }
        }*/
        float importe=0;
        Calendar fechaIni = Calendar.getInstance();
        for(Llamada llamada : llamadas){
            importe+= llamada.getDuracion() * tarifa.getPrecio();
            if(llamada.getFecha().before(fechaIni)){
                fechaIni = llamada.getFecha();
            }
            /*if(tieneDias && tarifaDias.getDia()==llamada.getFecha().getTime().getDay()){
                importe += llamada.getDuracion()*tarifaDias.getPrecio();
            }else if (tieneHoras && llamada.getFecha().getTime().getHours()>= tarifaHoras.getHoraIni() && llamada.getFecha().getTime().getHours()<= tarifaHoras.getHoraFin()){
                importe += llamada.getDuracion()*tarifaHoras.getPrecio();
            }else{
                importe += llamada.getDuracion()*tarifaBasica.getPrecio();
            }*/
        }
        System.out.println("El importe de la factura es: " + importe);
        Factura nueva = new Factura(String.valueOf(listaFacturas.size()+1), tarifa, fechaIni,importe);

    }

    public Factura getFacturaCodigo(String codfac) throws FacturaNoExisteException {
        return mapaFactuarsCod.get(codfac);
    }

    public String listarFacturas(){
        System.out.println(mapaFactuarsCod.toString());
        return  mapaFactuarsCod.toString();
    }

    public ArrayList<Factura> getListaFacturas(){ return listaFacturas;}
}
