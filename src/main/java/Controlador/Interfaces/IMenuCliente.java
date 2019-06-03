package Controlador.Interfaces;

import Modelo.Tarifas.Tarifa;

public interface IMenuCliente {

    String pideNombreCliente();
    String pideNIFCliente();
    String pideDireccionCleinte();
    String pideCorreoCliente();
    Tarifa pideTarifaClietne();
    String pideTipoCliente();
    String pideApellido();
    int pideTipoTarifa();
    int pideHora();
    int pideDiaSemana();

}
