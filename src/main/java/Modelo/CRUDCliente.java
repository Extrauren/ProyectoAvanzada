package Modelo;

import Controlador.Cliente;
import Controlador.Empresa;
import Controlador.Particular;
import Controlador.Tarifa;
import com.sun.xml.internal.ws.api.ha.StickyFeature;

import javax.swing.plaf.nimbus.NimbusLookAndFeel;
import java.util.Calendar;
import java.util.HashMap;

public class CRUDCliente {


    HashMap<String, Cliente> mapaClientes = new HashMap<>();
    private Cliente cliente;


    public void altaClienteParticular(String nombre, String NIF, String direccion, String correo, Calendar fechaAlta, Tarifa tarifa, String apellido){

        cliente = new Particular(nombre, NIF, direccion, correo, fechaAlta, tarifa, apellido);
        mapaClientes.put(NIF, cliente);

    }
    public void altaClienteEmpresa(String nombre, String NIF, String direccion, String correo, Calendar fechaAlta, Tarifa tarifa){

        cliente = new Empresa(nombre, NIF, direccion, correo, fechaAlta, tarifa);
        mapaClientes.put(NIF, cliente);
    }

    public void borrarCliente(String NIF){
        mapaClientes.remove(NIF);
    }

    public void cambiaTarifa(String NIF, int tarifa){               //Luego se cambia por la clase Tarifa
        cliente = mapaClientes.get(NIF);
        cliente.setTarifa(tarifa);
    }

    public Cliente getCliente(String NIF){
        return mapaClientes.get(NIF);
    }

    public  HashMap<String, Cliente> listarClientes(){

        return mapaClientes;
    }

}
