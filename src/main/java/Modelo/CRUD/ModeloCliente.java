package Modelo.CRUD;

import Controlador.Cliente;
import Controlador.Empresa;
import Controlador.Particular;
import Controlador.Tarifas.Tarifa;
import Modelo.Excepciones.ClienteNoExisteException;
import Modelo.Excepciones.ErrorEntreFechasException;
import Modelo.Factory.FabricaCliente;
import Modelo.Factory.FabricaTarifa;
import Modelo.Genericidad.CRUDGenerico;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collection;
import java.util.HashMap;

public class ModeloCliente implements Serializable {


    HashMap<String, Cliente> mapaClientes = new HashMap<>();
    ArrayList<Cliente> listaClietnes = new ArrayList<>();
    private FabricaCliente fabricaCliente;
    private FabricaTarifa fabricaTarifa;
    private CRUDGenerico crudGenerico;


    public void anyadeClietne(Cliente cliente){
        String nif = cliente.getNIF();
        mapaClientes.put(nif, cliente);
        listaClietnes.add(cliente);
    }

    public void borrarCliente(String NIF) throws ClienteNoExisteException{
        mapaClientes.remove(NIF);
        for(int i =0; i<getNumClientes(); i++){
            if(listaClietnes.get(i).getNIF().equals(NIF)){
                listaClietnes.remove(i);
            }
        }
    }

    public void cambiaTarifa(String NIF, ArrayList<Tarifa> tarifa) throws  ClienteNoExisteException{   //Luego se cambia por la clase Tarifa
        Cliente cliente;
        cliente = mapaClientes.get(NIF);
        cliente.setTarifa(tarifa);
        System.out.println(cliente.toString());

    }

    public Cliente getCliente(String NIF) throws ClienteNoExisteException {
        return mapaClientes.get(NIF);

    }

    public Cliente[] listarClientes(){
        Cliente[] listado = new Cliente[this.getNumClientes()];
        for (int i = 0; i < this.getNumClientes(); i++) {
            listado[i] = this.getListaClientes().get(i);
        }
        return listado;
    }

    public void insertarDatosClienteVista(String nombre, String nif, String correo, String direccion, boolean tipo, float tarifaBase, String apellido) {

        ArrayList<Tarifa> listaTarifas = new ArrayList<>();
        FabricaTarifa fabricaTarifas = new FabricaTarifa();

        Tarifa tarifaBasica = fabricaTarifas.getTarifaBasica(tarifaBase);

        Calendar fechaAlta = Calendar.getInstance();
        listaTarifas.add(tarifaBasica);

        FabricaCliente fabricaClientes = new FabricaCliente();
        if (tipo) {
            Particular particular = (Particular) fabricaClientes.getClienteParticular( nombre,  nif,  direccion,  correo,  fechaAlta,  listaTarifas,  apellido);
            this.anyadeClietne(particular);
        } else {
            Empresa empresa = (Empresa) fabricaClientes.getClienteEmpresa(nombre, nif, correo, direccion, fechaAlta, listaTarifas);
            this.anyadeClietne(empresa);

        }

    }

    public boolean eliminarClienteDNI(String nif) {
        Cliente cs;
        try {
            cs = this.getCliente(nif);
            if (this.getListaClientes().contains(cs)) {
                this.borrarCliente(cs.getNIF());
                return true;
            }
            return false;
        } catch (ClienteNoExisteException e) {
            e.printStackTrace();
        }
        return false;
    }

    public String recuperarClientePorDNI(String nif) {
        try{
            return this.getCliente(nif).getNombre();
        }catch (ClienteNoExisteException e) {
            e.printStackTrace();
        }
        return null;
    }

    public Cliente[] listarFacturas(Calendar fechaIni, Calendar fechaFin){

        Cliente[] listado = new Cliente[this.getNumClientes()];
        try {
            crudGenerico.compruebaFecha(fechaIni, fechaFin);
            ArrayList<Cliente> todas = this.getListaClientes();
            Collection<Cliente> lista = crudGenerico.extraerPeriodo(fechaIni, fechaFin, todas);
            int i = 0;
            for (Cliente iter : lista) {
                listado[i] = iter;
                i++;
            }
        }catch (ErrorEntreFechasException e){
            System.out.println("Error");
        }
        return listado;
    }

    public void insertarTarifaBasica(String nif, float precio) throws ClienteNoExisteException {
        Tarifa nueva = fabricaTarifa.getTarifaBasica(precio);
        this.getCliente(nif).getTarifa().add(nueva);
    }

    public void insertarTarifaDia(String DNI, int dia, float precio) throws  ClienteNoExisteException{
        Tarifa tarifaPadre = null;
        for(Tarifa iter :  this.getCliente(DNI).getTarifa()){
            if(iter.equals(this.getCliente(DNI).getTarifa().size()-1)){
                tarifaPadre = iter;
            }
        }
        Tarifa nueva = fabricaTarifa.getTarifaDias(tarifaPadre, precio ,dia);
        this.getCliente(DNI).getTarifa().add(nueva);
    }
    public void insertarTarifaHoras(String DNI, int fechaIni, int fechaFin, float precio) throws ClienteNoExisteException{
        Tarifa tarifaPadre = null;
        for(Tarifa iter :  this.getCliente(DNI).getTarifa()){
            if(iter.equals(this.getCliente(DNI).getTarifa().size()-1)){
                tarifaPadre = iter;
            }
        }
        Tarifa nueva = fabricaTarifa.getTarifaHoras(tarifaPadre,precio,fechaIni, fechaFin);
        this.getCliente(DNI).getTarifa().add(nueva);
    }
    public void borrarTarifas(String DNI) throws ClienteNoExisteException {
        this.getCliente(DNI).getTarifa().clear();
    }

    public Tarifa[] listaTarifaCliente(String DNI) throws ClienteNoExisteException {
        Tarifa[] listado = new Tarifa[this.getCliente(DNI).getTarifa().size()];
        for(int i = 0; i < this.getCliente(DNI).getTarifa().size(); i++){
            listado[i] = this.getCliente(DNI).getTarifa().get(i);
        }
        System.out.println(this.getCliente(DNI).getTarifa().size());
        return listado;
    }

    public  void mostrarClientes(){
        System.out.println(mapaClientes.toString());
    }

    public  HashMap<String, Cliente> getMapaClientes(){
        return this.mapaClientes;
    }

    public ArrayList<Cliente> getListaClientes(){
        return this.listaClietnes;
    }

    public int getNumClientes(){
        return mapaClientes.size();
    }

}
