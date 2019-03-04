package Vista;

import Controlador.Tarifa;

public interface IMenuCliente {

    String pideNombreCliente();
    String pideNIFCliente();
    String pideDireccionCleinte();
    String pideCorreoCliente();
    Tarifa pideTarifaClietne();
    String pideTipoCliente();
    String pideApellido();

}
