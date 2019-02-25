package Controlador;

import javax.swing.table.TableRowSorter;
import java.util.Calendar;

public class Cliente {

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

    public Calendar getFechaAlta() {
        return fechaAlta;
    }

    public Tarifa getTarifa() {
        return tarifa;
    }

    public void setTarifa(Tarifa tarifa) {
        this.tarifa = tarifa;
    }
}


