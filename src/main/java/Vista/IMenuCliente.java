package Vista;

import Controlador.Cliente;
import Controlador.Tarifa;
import java.util.Calendar;

public interface IMenuCliente {

    String pideNombreCliente();
    String pideNIFCliente();
    String pideDireccionCleinte();
    String pideCorreoCliente();
    Tarifa pideTarifaClietne();
    String pideTipoCliente();
    String pideApellido();

}
