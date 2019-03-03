package Controlador;

import java.util.Calendar;

public class Llamada {
    private int telefono;
    private Calendar fechaLlamada;
    private float duracion;

    public Llamada(int telefono, Calendar fechaLlamada, float duracion){
        this.duracion = duracion;
        this.fechaLlamada = fechaLlamada;
        this.telefono = telefono;
    }

    public Calendar getFechaLlamada() {
        return fechaLlamada;
    }
}
