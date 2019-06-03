package Controlador.Ejecutar;

import Controlador.ControladorCliente;
import Controlador.ControladorFactura;
import Controlador.ControladorLlamada;

public class AlmacenDatos {
    private ControladorLlamada controladorLlamada;
    private ControladorFactura controladorFactura;
    private ControladorCliente controladorCliente;

    AlmacenDatos(ControladorCliente controladorCliente, ControladorLlamada controladorLlamada, ControladorFactura controladorFactura){
        this.controladorCliente = controladorCliente;
        this.controladorLlamada = controladorLlamada;
        this.controladorFactura = controladorFactura;
    }



}
