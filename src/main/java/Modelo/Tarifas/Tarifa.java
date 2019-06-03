package Modelo.Tarifas;

import java.io.Serializable;

public class Tarifa implements Serializable {
    public float precio = 0;

    public Tarifa(){
        this.precio = precio;
    }

    public Tarifa(float precio) {
        this.precio= precio;
    }

    public float getPrecio(){
        return precio;
    }

    public void setPrecio(float precio){
        this.precio = precio;
    }

    @Override
    public String toString() {
        return String.valueOf(precio);
    }
}
