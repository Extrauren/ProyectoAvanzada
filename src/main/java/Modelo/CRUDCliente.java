package Modelo;

import Controlador.Cliente;
import Controlador.Empresa;
import Controlador.Particular;
import Controlador.Tarifas.Tarifa;
import Excepciones.ClienteNoExisteException;

import java.io.Serializable;
import java.util.Calendar;
import java.util.HashMap;

public class CRUDCliente implements Serializable {


    HashMap<String, Cliente> mapaClientes = new HashMap<>();



    public void altaClienteParticular(String nombre, String NIF, String direccion, String correo, Calendar fechaAlta, Tarifa tarifa, String apellido){
        Cliente cliente;
        cliente = new Particular(nombre, NIF, direccion, correo, fechaAlta, tarifa, apellido);
        mapaClientes.put(NIF, cliente);

    }
    public void altaClienteEmpresa(String nombre, String NIF, String direccion, String correo, Calendar fechaAlta, Tarifa tarifa){
        Cliente cliente;
        cliente = new Empresa(nombre, NIF, direccion, correo, fechaAlta, tarifa);
        mapaClientes.put(NIF, cliente);
    }

    public void borrarCliente(String NIF) throws ClienteNoExisteException{
        mapaClientes.remove(NIF);
    }

    public void cambiaTarifa(String NIF, Tarifa tarifa) throws  ClienteNoExisteException{   //Luego se cambia por la clase Tarifa
        Cliente cliente;
        cliente = mapaClientes.get(NIF);
        cliente.setTarifa(tarifa);
        System.out.println(cliente.toString());

    }

    public Cliente getCliente(String NIF) throws ClienteNoExisteException {
        return mapaClientes.get(NIF);

    }

    public  void listarClientes(){
        System.out.println(mapaClientes.toString());
    }

}
