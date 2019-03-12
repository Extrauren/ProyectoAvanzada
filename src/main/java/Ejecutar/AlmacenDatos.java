package Ejecutar;

import Modelo.CRUDCliente;
import Modelo.CRUDFactura;
import Modelo.CRUDLlamada;

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
