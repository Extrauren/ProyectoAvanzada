package Modelo.Ejecutar;

import Modelo.ModeloCliente;
import Modelo.ModeloFactura;
import Modelo.ModeloLlamada;

public class AlmacenDatos {
    private ModeloLlamada modeloLlamada;
    private ModeloFactura modeloFactura;
    private ModeloCliente modeloCliente;

    AlmacenDatos(ModeloCliente modeloCliente, ModeloLlamada modeloLlamada, ModeloFactura modeloFactura){
        this.modeloCliente = modeloCliente;
        this.modeloLlamada = modeloLlamada;
        this.modeloFactura = modeloFactura;
    }



}
