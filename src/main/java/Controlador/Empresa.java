package Controlador;

import java.util.Calendar;

public class Empresa extends Cliente {
    public Empresa(String nombre, String NIF, String direccion, String correo, Calendar fechaAlta, Tarifa tarifa) {
        super(nombre, NIF, direccion, correo, fechaAlta, tarifa);
    }

    public Empresa() {
        super();
    }
}
