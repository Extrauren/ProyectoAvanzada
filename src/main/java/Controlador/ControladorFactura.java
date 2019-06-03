package Controlador;

import Modelo.Factura;
import Modelo.Llamada;
import Modelo.Tarifas.Tarifa;
import Controlador.Excepciones.ClienteNoExisteException;
import Controlador.Excepciones.FacturaNoExisteException;
import Controlador.Factory.FabricaTarifa;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashMap;

public class ControladorFactura implements Serializable {

    private HashMap<String, Factura> mapaFactuarsCod = new HashMap<>();             //codfac como clave
    private ArrayList<Factura> listaFacturas = new ArrayList<>();
    private ControladorCliente controladorCliente;
    private ControladorLlamada controladorLlamada;

    public ControladorFactura(ControladorCliente modCLi, ControladorLlamada modLlama){
        this.controladorCliente = modCLi;
        this.controladorLlamada = modLlama;
    }

    public void emitirFactura(String nif) throws ClienteNoExisteException {
        ArrayList<Tarifa> tarifas = controladorCliente.getCliente(nif).getTarifa();
        ArrayList<Llamada> llamadas = controladorLlamada.muestraLlamadaCliente(nif);
        Tarifa tarifa = tarifas.get(0);

        float importe=0;
        Calendar fechaIni = Calendar.getInstance();
        for(Llamada llamada : llamadas){
            importe+= llamada.getDuracion() * tarifa.getPrecio();
            if(llamada.getFecha().before(fechaIni)){
                fechaIni = llamada.getFecha();
            }
        }
        System.out.println("El importe de la factura es: " + importe);
        String codfac = String.valueOf(listaFacturas.size()+1);
        Factura nueva = new Factura(nif,codfac, tarifa, fechaIni,importe);
        System.out.println(nueva.toString());
        listaFacturas.add(nueva);
        mapaFactuarsCod.put(codfac, nueva);
    }

    public Factura getFacturaCodigo(String codfac) throws FacturaNoExisteException {
        if(!mapaFactuarsCod.containsKey(codfac)){
            System.out.println("No existe la factura");
        }
        return mapaFactuarsCod.get(codfac);
    }

    public String listarFacturas(){
        if(mapaFactuarsCod.isEmpty()){
            System.out.println("No hay facturas disponibles");
        }
        return  mapaFactuarsCod.toString();
    }

    public ArrayList<Factura> getListaFacturas(){ return listaFacturas;}
}
