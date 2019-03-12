package Controlador;

import java.io.Serializable;

public class Tarifa implements Serializable {
    public int valor = 10;

    public Tarifa(int importe) {
        this.valor= importe;
    }
}
