package Modelo.Ejecutar;

import Modelo.CRUD.CRUDCliente;
import Modelo.CRUD.CRUDFactura;
import Modelo.CRUD.CRUDLlamada;

public class AlmacenDatos {
    private CRUDLlamada crudLlamada;
    private CRUDFactura crudFactura;
    private CRUDCliente crudCliente;

    AlmacenDatos(CRUDCliente crudCliente, CRUDLlamada crudLlamada, CRUDFactura crudFactura){
        this.crudCliente = crudCliente;
        this.crudLlamada = crudLlamada;
        this.crudFactura = crudFactura;
    }



}
