package Controlador;

import java.util.Calendar;

public class Cliente {

    private String nombre;
    private String NIF;
    private String direccion;
    private String correo;
    private Calendar fechaAlta;
    private int tarifa;

    Cliente(String nombre, String NIF, String direccion, String correo, Calendar fechaAlta, int tarifa){
        this.nombre=nombre;
        this.NIF=NIF;
        this.direccion=direccion;
        this.correo=correo;
        this.fechaAlta=fechaAlta;
        this.tarifa=tarifa;
    }

    public Calendar getFechaAlta() {
        return fechaAlta;
    }

    public int getTarifa() {
        return tarifa;
    }

    public void setTarifa(int tarifa) {
        this.tarifa = tarifa;
    }
}


