package Modelo.Factory;

import Controlador.Cliente;
import Controlador.Empresa;
import Controlador.Particular;
import Controlador.Tarifas.Tarifa;
import Modelo.Interfaces.IFabricaClientes;

import java.util.ArrayList;
import java.util.Calendar;

public class FabricaCliente implements IFabricaClientes {

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
