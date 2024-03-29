package Modelo;

import Modelo.Tarifas.Tarifa;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Calendar;

public class Particular extends Cliente implements Serializable {

    private String apellido;

    public Particular(String nombre, String NIF, String direccion, String correo, Calendar fechaAlta, ArrayList<Tarifa> tarifa, String apellido) {
        super(nombre, NIF, direccion, correo, fechaAlta, tarifa);
        this.apellido = apellido;
    }

    public Particular() {
        super();
    }
}
