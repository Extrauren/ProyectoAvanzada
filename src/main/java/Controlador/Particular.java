package Controlador;

import java.util.Calendar;

public class Particular extends Cliente {

    private String apellido;

    public Particular(String nombre, String NIF, String direccion, String correo, Calendar fechaAlta, Tarifa tarifa, String apellido) {
        super(nombre, NIF, direccion, correo, fechaAlta, tarifa);
        this.apellido = apellido;
    }

    public Particular() {
        super();
    }
}
