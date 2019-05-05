package Modelo.Ejecutar;

import Modelo.CRUD.ModeloCliente;
import Modelo.CRUD.CRUDFactura;
import Modelo.CRUD.CRUDLlamada;

public class AlmacenDatos {
    private CRUDLlamada crudLlamada;
    private CRUDFactura crudFactura;
    private ModeloCliente modeloCliente;

    AlmacenDatos(ModeloCliente modeloCliente, CRUDLlamada crudLlamada, CRUDFactura crudFactura){
        this.modeloCliente = modeloCliente;
        this.crudLlamada = crudLlamada;
        this.crudFactura = crudFactura;
    }



}
