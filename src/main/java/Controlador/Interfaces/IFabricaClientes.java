package Controlador.Interfaces;

import Modelo.Cliente;
import Modelo.Tarifas.Tarifa;

import java.util.ArrayList;
import java.util.Calendar;

public interface IFabricaClientes {
    Cliente getClienteParticular(String nombre, String NIF, String direccion, String correo, Calendar fechaAlta, ArrayList<Tarifa> tarifa, String apellido);
    Cliente getClienteEmpresa(String nombre, String NIF, String direccion, String correo, Calendar fechaAlta, ArrayList<Tarifa> tarifa);
}
