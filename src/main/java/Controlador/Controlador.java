package Controlador;

import Controlador.Tarifas.Tarifa;
import Modelo.Excepciones.ClienteNoExisteException;
import Modelo.Excepciones.FacturaNoExisteException;
import Modelo.Factory.FabricaCliente;
import Modelo.Factory.FabricaTarifa;
import Modelo.ModeloCliente;
import Modelo.ModeloFactura;
import Modelo.ModeloLlamada;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Calendar;

public class Controlador implements Serializable {

    private ModeloCliente modeloCliente;
    private ModeloFactura modeloFactura;
    private ModeloLlamada modeloLlamada;
    private FabricaCliente fabricaCliente;
    private FabricaTarifa fabricaTarifa;

    public Controlador(){
        modeloCliente = new ModeloCliente();
        modeloLlamada = new ModeloLlamada();
        modeloFactura = new ModeloFactura(modeloCliente, modeloLlamada);

        this.fabricaCliente = new FabricaCliente();
        this.fabricaTarifa = new FabricaTarifa();
    }
    //t odo lo relacionado con clientes
    public void insertaClientePar(String nombre, String dni, String dir, String correo, String apellido){
        Tarifa tarifa = fabricaTarifa.getTarifaBasica(0.15f);
        ArrayList<Tarifa> tarifas = new ArrayList<>();
        tarifas.add(tarifa);
        Cliente cliente;

        cliente = fabricaCliente.getClienteParticular(nombre,dni, dir, correo, Calendar.getInstance(),tarifas, apellido);
        modeloCliente.anyadeClietne(cliente);
    }

    public void insertarClienteEm(String nombre, String dni, String dir, String correo){
        Tarifa tarifa = fabricaTarifa.getTarifaBasica(0.15f);
        ArrayList<Tarifa> tarifas = new ArrayList<>();
        tarifas.add(tarifa);
        Cliente cliente;

        cliente = fabricaCliente.getClienteEmpresa(nombre,dni, dir, correo, Calendar.getInstance(),tarifas);
        modeloCliente.anyadeClietne(cliente);
    }

    public void borrarCliente(String nif) throws ClienteNoExisteException {
        modeloCliente.borrarCliente(nif);

    }

    public String[] listadoClientes(){
        return modeloCliente.listadoClientes();
    }

    public Cliente[] recuperaClienteDni(String nif){
        return modeloCliente.recuperarClientePorDNI(nif);
    }


    //t odo lo relacionado con facturas
    public void emitirFactura(String texto) throws ClienteNoExisteException {
        modeloFactura.emitirFactura(texto);
    }

    public String[] listarFacturas(){
        ArrayList<Factura> lista = modeloFactura.getListaFacturas();
        if(lista==null){
            String[] aux = new String[1];
            aux[0] = "lista vacia";
            return aux;
        }
        String[] aux = new String[lista.size()];

        for(int i=0 ; i<lista.size(); i++) {
            aux[i] = lista.get(i).toString();
        }
        return aux;
    }

    public String recuperaFactura(String dat) throws FacturaNoExisteException {
        return modeloFactura.getFacturaCodigo(dat).toString();
    }


    //llamadas

    public String[] muestraLlamadaCliente(String dat){
        ArrayList<Llamada> lista = modeloLlamada.muestraLlamadaCliente(dat);

        if(lista==null){
            String[] aux = new String[1];
            aux[0] = "lista vacia";
            return aux;
        }
        String[] aux = new String[lista.size()];

        for(int i=0 ; i<lista.size(); i++) {
            aux[i] = lista.get(i).toString();
        }
        return aux;


    }

    public void altaLlamada(String dni, int num, Float dur){
        modeloLlamada.altaLLamada(dni, num, dur);
    }
}
