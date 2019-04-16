package Vista;

import Controlador.Tarifas.Tarifa;

public interface IFabricaTarifas {

    Tarifa getTarifaBasica(float precio);
    Tarifa getTarifaDias(Tarifa tarifaPadre, float precio, int diaSemana);
    Tarifa getTarifaHoras(Tarifa tarifaPadre, float precio, int horaIni, int horaFin);

}
