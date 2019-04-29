package Controlador.Tarifas;

import java.util.Calendar;
import java.util.Date;

public class TarifaHoras extends Tarifa {

    private Tarifa tarifa;
    private int horaIni;
    private int horaFin;

    public TarifaHoras(Tarifa tarifaPadre, float precio, int horaIni, int horaFin) {
        super(precio);
        this.tarifa = tarifaPadre;
        this.horaIni = horaIni;
        this.horaFin = horaFin;
    }

    public float getPrecio(Calendar fecha) {
        float padre = tarifa.getPrecio();
        float costeActual;
        if (Calendar.HOUR_OF_DAY>= horaIni && Calendar.HOUR_OF_DAY< horaFin) {
            costeActual = super.precio;
            if (padre < costeActual) {
                costeActual = padre;
            }
        } else {
            costeActual = padre;
        }
        return costeActual;
    }

    public int getHoraFin() {
        return horaFin;
    }

    public int getHoraIni() {
        return horaIni;
    }
}
