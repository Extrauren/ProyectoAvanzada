package Controlador;

import Modelo.Cliente;
import Modelo.Factura;
import Modelo.Llamada;
import Modelo.Tarifas.Tarifa;
import Controlador.Excepciones.ClienteNoExisteException;
import Controlador.Excepciones.FacturaNoExisteException;
import Controlador.Factory.FabricaCliente;
import Controlador.Factory.FabricaTarifa;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Calendar;

public class Controlador implements Serializable {

    private ControladorCliente controladorCliente;
    private ControladorFactura controladorFactura;
    private ControladorLlamada controladorLlamada;
    private FabricaCliente fabricaCliente;
    private FabricaTarifa fabricaTarifa;

    public Controlador(){
        controladorCliente = new ControladorCliente();
        controladorLlamada = new ControladorLlamada();
        controladorFactura = new ControladorFactura(controladorCliente, controladorLlamada);

        this.fabricaCliente = new FabricaCliente();
        this.fabricaTarifa = new FabricaTarifa();
    }

    //todo lo relacionado con clientes

    public void insertaClientePar(String nombre, String dni, String dir, String correo, String apellido){

        Tarifa tarifa = fabricaTarifa.getTarifaBasica(0.15f);
        ArrayList<Tarifa> tarifas = new ArrayList<>();
        tarifas.add(tarifa);
        Cliente cliente;

        cliente = fabricaCliente.getClienteParticular(nombre,dni, dir, correo, Calendar.getInstance(),tarifas, apellido);
        controladorCliente.anyadeClietne(cliente);
    }

    public void insertarClienteEm(String nombre, String dni, String dir, String correo){
        Tarifa tarifa = fabricaTarifa.getTarifaBasica(0.15f);
        ArrayList<Tarifa> tarifas = new ArrayList<>();
        tarifas.add(tarifa);
        Cliente cliente;

        cliente = fabricaCliente.getClienteEmpresa(nombre,dni, dir, correo, Calendar.getInstance(),tarifas);
        controladorCliente.anyadeClietne(cliente);
    }

    public void borrarCliente(String nif) throws ClienteNoExisteException {
        controladorCliente.borrarCliente(nif);

    }

    public String[] listadoClientes(){
        return controladorCliente.listadoClientes();
    }

    public Cliente[] recuperaClienteDni(String nif){
        return controladorCliente.recuperarClientePorDNI(nif);
    }

    public void anyadirUnaTarifa(String nif, Tarifa tarifa){ controladorCliente.anyadirUnaTarifa(nif, tarifa);}

    public void anyadirTarifaDia(String nif, int dia){
        try {
            controladorCliente.insertarTarifaDia(nif, dia);
        } catch (ClienteNoExisteException e) {
            e.printStackTrace();
        }
    }

    //todo lo relacionado con facturas
    public void emitirFactura(String texto) throws ClienteNoExisteException {
        controladorFactura.emitirFactura(texto);
    }

    public String[] listarFacturas(){
        ArrayList<Factura> lista = controladorFactura.getListaFacturas();
        if(lista==null || lista.size()==0){
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
        Factura aux = controladorFactura.getFacturaCodigo(dat);
        if(aux==null)
            return "No existe esta factura";
        return aux.toString();
    }


    //todo lo relacionado con llamadas
    public String[] muestraLlamadaCliente(String dat){
        ArrayList<Llamada> lista = controladorLlamada.muestraLlamadaCliente(dat);

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
        controladorLlamada.altaLLamada(dni, num, dur);
    }
}
