package Controlador;

import Modelo.Interfaces.Fecha;

import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.Calendar;

public class Llamada implements Serializable, Fecha {
    private int telefono;
    private Calendar fechaLlamada;
    private float duracion;

    public Llamada(int telefono, Calendar fechaLlamada, float duracion){
        this.duracion = duracion;
        this.fechaLlamada = fechaLlamada;
        this.telefono = telefono;
    }

    public Llamada(int telefono, float duracion) {
        this.telefono = telefono;
        this.fechaLlamada = Calendar.getInstance();
        this.duracion = duracion;
    }

    public Calendar getFecha() {
        return fechaLlamada;
    }

    public float getDuracion(){
        return this.duracion;
    }

    private String fechaTexto(Calendar fecha){
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        return sdf.format(fecha.getTime());
    }

    public String toString(){
        return "Telefono: "+ telefono + ", fecha: "+fechaTexto(fechaLlamada)+", duracion: "+duracion;
    }
}
