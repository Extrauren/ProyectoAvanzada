package Modelo;

import Modelo.Tarifas.Tarifa;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Calendar;

public class Empresa extends Cliente implements Serializable {
    public Empresa(String nombre, String NIF, String direccion, String correo, Calendar fechaAlta, ArrayList<Tarifa> tarifa) {
        super(nombre, NIF, direccion, correo, fechaAlta, tarifa);
    }

    public Empresa() {
        super();
    }
}
