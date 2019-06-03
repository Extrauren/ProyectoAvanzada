package Controlador.Factory;

import Modelo.Cliente;
import Modelo.Empresa;
import Modelo.Particular;
import Modelo.Tarifas.Tarifa;
import Controlador.Interfaces.IFabricaClientes;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Calendar;

public class FabricaCliente implements IFabricaClientes, Serializable {

    public FabricaCliente(){
        super();
    }


    @Override
    public Cliente getClienteParticular(String nombre, String NIF, String direccion, String correo, Calendar fechaAlta, ArrayList<Tarifa> tarifa, String apellido) {
        return new Particular(nombre, NIF, direccion, correo, fechaAlta, tarifa, apellido);
    }

    @Override
    public Cliente getClienteEmpresa(String nombre, String NIF, String direccion, String correo, Calendar fechaAlta, ArrayList<Tarifa> tarifa) {
        return new Empresa(nombre, NIF, direccion, correo, fechaAlta, tarifa);
    }
}
