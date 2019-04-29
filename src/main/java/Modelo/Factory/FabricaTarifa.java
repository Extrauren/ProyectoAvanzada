package Modelo.Factory;

import Controlador.Tarifas.Tarifa;
import Controlador.Tarifas.TarifaBasica;
import Controlador.Tarifas.TarifaDias;
import Controlador.Tarifas.TarifaHoras;
import Vista.IFabricaTarifas;

public class FabricaTarifa implements IFabricaTarifas {

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
