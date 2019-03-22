package Controlador;

import java.io.Serializable;
import java.util.Calendar;

public class Cliente implements Serializable, Fecha {

    private String nombre;
    private String NIF;
    private String direccion;
    private String correo;
    private Calendar fechaAlta;
    private Tarifa tarifa;

    Cliente(String nombre, String NIF, String direccion, String correo, Calendar fechaAlta, Tarifa tarifa){
        this.nombre=nombre;
        this.NIF=NIF;
        this.direccion=direccion;
        this.correo=correo;
        this.fechaAlta=fechaAlta;
        this.tarifa=tarifa;
    }

    public Cliente() {

    }


    public Calendar getFecha() {
        return this.fechaAlta;
    }

    public Tarifa getTarifa() {
        return this.tarifa;
    }

    public void setTarifa(Tarifa tarifa) {
        this.tarifa = tarifa;
    }

    public String toString(){
       String cadena = this.nombre + " / " + this.NIF + " / " + this.direccion + " / " + this.correo + " / " + this.fechaAlta + " / " + this.tarifa;
       return cadena;
    }

}


