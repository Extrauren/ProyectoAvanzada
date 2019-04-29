package Controlador.Tarifas;

import java.util.Calendar;

public class TarifaDias extends Tarifa {

    private Tarifa tarifa;
    private int dia;

    public TarifaDias(Tarifa tarifa, float precio, int dia) {
        super(precio);
        this.tarifa = tarifa;
        this.dia = dia;
    }

    public float getPrecio(Calendar fecha){
        float padre = tarifa.getPrecio();
        float costeActual;

        if(Calendar.DAY_OF_WEEK == this.dia){
            costeActual = super.precio;
            if(padre < costeActual){
                costeActual = padre;
            }
        }else{
            costeActual = padre;
        }
        return costeActual;
    }

    public int getDia(){
        return this.dia;
    }

}
