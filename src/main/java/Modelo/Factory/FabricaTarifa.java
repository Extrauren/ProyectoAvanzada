package Modelo.Factory;

import Controlador.Tarifas.Tarifa;
import Controlador.Tarifas.TarifaBasica;
import Controlador.Tarifas.TarifaDias;
import Controlador.Tarifas.TarifaHoras;
import Modelo.Interfaces.IFabricaTarifas;

import java.io.Serializable;

public class FabricaTarifa implements IFabricaTarifas, Serializable {

    public FabricaTarifa(){
        super();
    }

    @Override
    public Tarifa getTarifaBasica(float precio) {
        return new TarifaBasica(precio);
    }

    @Override
    public Tarifa getTarifaDias(Tarifa tarifaPadre, float precio, int diaSemana) {
        return new TarifaDias(tarifaPadre, precio, diaSemana);
    }

    @Override
    public Tarifa getTarifaHoras(Tarifa tarifaPadre, float precio, int horaIni, int horaFin) {
        return new TarifaHoras(tarifaPadre, precio, horaIni, horaFin);
    }

}
