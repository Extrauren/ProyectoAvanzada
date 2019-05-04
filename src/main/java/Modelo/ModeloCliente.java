package Modelo;

import Controlador.Cliente;
import Controlador.Empresa;
import Controlador.Particular;
import Controlador.Tarifas.Tarifa;
import Modelo.CRUD.CRUDCliente;
import Modelo.Excepciones.ClienteNoExisteException;
import Modelo.Excepciones.ErrorEntreFechasException;
import Modelo.Factory.FabricaCliente;
import Modelo.Factory.FabricaTarifa;
import Modelo.Genericidad.CRUDGenerico;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collection;
import java.util.Scanner;

public class ModeloCliente implements Serializable {

    private CRUDCliente crudCliente;
    private CRUDGenerico crudGenerico;
    private Scanner scanner = new Scanner(System.in);
    private FabricaTarifa fabricaTarifas = new FabricaTarifa();


    public ModeloCliente(CRUDCliente crud){
        this.crudCliente = crud;
    }

    public Cliente[] listarClientes(){
        Cliente[] listado = new Cliente[crudCliente.getNumClientes()];
        for (int i = 0; i < crudCliente.getNumClientes(); i++) {
            listado[i] = crudCliente.getListaClientes().get(i);
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
            crudCliente.anyadeClietne(particular);
        } else {
            Empresa empresa = (Empresa) fabricaClientes.getClienteEmpresa(nombre, nif, correo, direccion, fechaAlta, listaTarifas);
            crudCliente.anyadeClietne(empresa);

        }

    }

    public boolean eliminarClienteDNI(String nif) {
        Cliente cs;
        try {
            cs = crudCliente.getCliente(nif);
            if (crudCliente.getListaClientes().contains(cs)) {
                crudCliente.borrarCliente(cs.getNIF());
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
            return crudCliente.getCliente(nif).getNombre();
        }catch (ClienteNoExisteException e) {
            e.printStackTrace();
        }
        return null;
    }

    public Cliente[] listarFacturas(Calendar fechaIni, Calendar fechaFin){

        Cliente[] listado = new Cliente[crudCliente.getNumClientes()];
        try {
            ModeloGenerico.compruebaFecha(fechaIni, fechaFin);
            ArrayList<Cliente> todas = crudCliente.getListaClientes();
            Collection<Cliente> lista = crudGenerico.extraerPeriodo(todas, fechaIni, fechaFin);
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
        Tarifa nueva = fabricaTarifas.getTarifaBasica(precio);
        crudCliente.getCliente(nif).getTarifa().add(nueva);
    }

    public void insertarTarifaDia(String DNI, int dia, float precio) throws  ClienteNoExisteException{
        Tarifa tarifaPadre = null;
        for(Tarifa iter :  crudCliente.getCliente(DNI).getTarifa()){
            if(iter.equals(crudCliente.getCliente(DNI).getTarifa().size()-1)){
                tarifaPadre = iter;
            }
        }
        Tarifa nueva = fabricaTarifas.getTarifaDias(tarifaPadre, precio ,dia);
        crudCliente.getCliente(DNI).getTarifa().add(nueva);
    }
    public void insertarTarifaHoras(String DNI, int fechaIni, int fechaFin, float precio) throws ClienteNoExisteException{
        Tarifa tarifaPadre = null;
        for(Tarifa iter :  crudCliente.getCliente(DNI).getTarifa()){
            if(iter.equals(crudCliente.getCliente(DNI).getTarifa().size()-1)){
                tarifaPadre = iter;
            }
        }
        Tarifa nueva = fabricaTarifas.getTarifaHoras(tarifaPadre,precio,fechaIni, fechaFin);
        crudCliente.getCliente(DNI).getTarifa().add(nueva);
    }
    public void borrarTarifas(String DNI) throws ClienteNoExisteException {
        crudCliente.getCliente(DNI).getTarifa().clear();
    }

    public Tarifa[] listaTarifaCliente(String DNI) throws ClienteNoExisteException {
        Tarifa[] listado = new Tarifa[crudCliente.getCliente(DNI).getTarifa().size()];
        for(int i = 0; i < crudCliente.getCliente(DNI).getTarifa().size(); i++){
            listado[i] = crudCliente.getCliente(DNI).getTarifa().get(i);
        }
        System.out.println(crudCliente.getCliente(DNI).getTarifa().size());
        return listado;
    }

}
