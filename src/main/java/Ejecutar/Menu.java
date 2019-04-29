package Ejecutar;

import Controlador.Factura;
import Controlador.Llamada;
import Controlador.Tarifas.Tarifa;
import Controlador.Tarifas.TarifaBasica;
import Controlador.Tarifas.TarifaDias;
import Controlador.Tarifas.TarifaHoras;
import Excepciones.ClienteNoExisteException;
import Excepciones.ErrorEntreFechasException;
import Excepciones.FacturaNoExisteException;
import Modelo.CRUDCliente;
import Modelo.CRUDFactura;
import Modelo.CRUDLlamada;
import Modelo.CRUDMenu;
import Modelo.Factory.FabricaCliente;
import Modelo.Factory.FabricaTarifa;
import Modelo.Genericidad.CRUDGenerico;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collection;

public class Menu implements Serializable {

    CRUDMenu crudMenu;
    CRUDCliente crudCliente;
    CRUDLlamada crudLlamada;
    CRUDFactura crudFactura;
    CRUDGenerico crudGenerico;
    FabricaTarifa fabricaTarifa;
    FabricaCliente fabricaCliente;

    public Menu(){
        crudMenu = new CRUDMenu();
        crudCliente = new CRUDCliente();
        crudLlamada = new CRUDLlamada();
        crudFactura = new CRUDFactura();
        crudGenerico = new CRUDGenerico();
        fabricaTarifa = new FabricaTarifa();
        fabricaCliente = new FabricaCliente();
    }


    public void main(){

        boolean finalizar = false;
        int opcion, tel, horaIni, horaFin, tipo;
        float duracion;
        String nombre, nif, direccion, correo, apellido, clase, codfac;
        Calendar fechaAlta, fecha;
        Tarifa tarifa;
        while(!finalizar){


            boolean atras = false;
            opcion = this.crudMenu.pideMenuGlobal();


            switch(opcion){
                case 1:
                    while(!atras) {
                        opcion = crudMenu.pideMenuCliente();
                        switch (opcion) {
                            case 1:
                                System.out.println("Has seleccionado la opcion 1, dar de alta un nuevo cliente \n");
                                nombre = crudMenu.pideNombreCliente();
                                fechaAlta = Calendar.getInstance();
                                nif= crudMenu.pideNIFCliente();
                                ArrayList<Tarifa> tarifas = new ArrayList<>();
                                TarifaBasica basica = (TarifaBasica) fabricaTarifa.getTarifaBasica(0.15f);
                                tarifas.add(basica);
                                direccion = crudMenu.pideDireccionCleinte();
                                correo = crudMenu.pideCorreoCliente();
                                clase = crudMenu.pideTipoCliente();
                                tipo=crudMenu.pideTipoTarifa();
                                while(tipo < 3) {
                                    if (tipo == 1) {
                                        horaIni = crudMenu.pideHora();
                                        horaFin = crudMenu.pideHora();
                                        TarifaHoras horas = (TarifaHoras) fabricaTarifa.getTarifaHoras(basica, 0.05f, horaIni, horaFin);
                                        tarifas.add(horas);
                                        tipo = crudMenu.pideTipoTarifa();
                                    }
                                    if (tipo == 2) {
                                        int dia = crudMenu.pideDiaSemana();
                                        TarifaDias dias = (TarifaDias) fabricaTarifa.getTarifaDias(basica, 0.05f, dia);
                                        tarifas.add(dias);
                                        tipo=crudMenu.pideTipoTarifa();
                                    }
                                }
                                if (clase.equals("particular")){
                                    apellido=crudMenu.pideApellido();
                                    crudCliente.añadeClietne(fabricaCliente.getClienteParticular(nombre, nif, direccion, correo, fechaAlta, tarifas, apellido));
                                }else{
                                    crudCliente.añadeClietne(fabricaCliente.getClienteEmpresa(nombre, nif, direccion, correo, fechaAlta, tarifas));
                                }

                                try {
                                    System.out.println("Cliente creado" + crudCliente.getCliente(nif).toString());
                                } catch (ClienteNoExisteException e) {
                                    e.printStackTrace();
                                }
                                break;
                            case 2:
                                System.out.println("Has seleccionado la opcion 2, borrar un cliente");
                                nif = crudMenu.pideNIFCliente();
                                try {
                                    crudCliente.borrarCliente(nif);
                                } catch (ClienteNoExisteException e) {
                                    e.printStackTrace();
                                }
                                break;
                            case 3:
                                System.out.println("Has seleccionado la opcion 3, cambiar la tarifa");
                                ArrayList<Tarifa> tarifas2 = new ArrayList<>();
                                TarifaBasica basica2 = (TarifaBasica) fabricaTarifa.getTarifaBasica(0.15f);
                                tarifas2.add(basica2);
                                tipo=crudMenu.pideTipoTarifa();
                                while(tipo < 3) {
                                    if (tipo == 1) {
                                        horaIni = crudMenu.pideHora();
                                        horaFin = crudMenu.pideHora();
                                        TarifaHoras horas2 = (TarifaHoras) fabricaTarifa.getTarifaHoras(basica2, 0.05f, horaIni, horaFin);
                                        tarifas2.add(horas2);
                                        tipo = crudMenu.pideTipoTarifa();
                                    }
                                    if (tipo == 2) {
                                        int dia = crudMenu.pideDiaSemana();
                                        TarifaDias dias = (TarifaDias) fabricaTarifa.getTarifaDias(basica2, 0.05f, dia);
                                        tarifas2.add(dias);
                                        crudMenu.pideTipoTarifa();
                                    }
                                }
                                String dni=crudMenu.pideNIFCliente();
                                try {
                                    crudCliente.cambiaTarifa(dni, tarifas2);
                                } catch (ClienteNoExisteException e) {
                                    e.printStackTrace();
                                }
                                break;
                            case 4:
                                System.out.println("Has seleccionado la opcion 4, recuperar datos por NIF");
                                nif = crudMenu.pideNIFCliente();
                                try {
                                    crudCliente.getCliente(nif);
                                } catch (ClienteNoExisteException e) {
                                    e.printStackTrace();
                                }
                                break;
                            case 5:
                                System.out.println("Has seleccionado la opcion 5, listar todos los clientes");
                                crudCliente.listarClientes();
                                break;
                            case 6:
                                System.out.println("Atras");
                                atras = true;
                                break;
                            default:
                                System.out.println("Solo números entre 1 y 6");
                        }
                    }
                    break;
                case 2:
                    System.out.println("Has seleccionado la opcion 2, Llamadas\n");
                    while(!atras) {
                        opcion = crudMenu.pideMenuLlamadas();
                        switch (opcion) {
                            case 1:
                                System.out.println("Has seleccionado la opcion 1, dar de alta una nueva llamada");
                                nif = crudMenu.pideNIFCliente();
                                tel = crudMenu.pideTelefono();
                                fechaAlta = Calendar.getInstance();
                                duracion = crudMenu.pideDuracion();
                                crudLlamada.altaLLamada(nif, tel, fechaAlta, duracion);
                                break;
                            case 2:
                                System.out.println("Has seleccionado la opcion 2, listar las llamadas de un cliente");
                                nif = crudMenu.pideNIFCliente();
                                System.out.println(crudLlamada.muestraLlamadaCliente(nif));
                                break;
                            case 3:
                                System.out.println("Has seleccionado la opcion 3, sacar llamada entre fechas");
                                Calendar fecha1 = crudMenu.pideFecha();
                                fecha = crudMenu.pideFecha();
                                ArrayList<Llamada> todas = crudLlamada.getListaLlamadas();
                                Collection<Llamada> lista = null;
                                try {
                                    lista = crudGenerico.extraerPeriodo(fecha1, fecha, todas);
                                    for (Llamada iter : lista) {
                                        System.out.println(iter.toString());
                                    }
                                } catch (ErrorEntreFechasException e) {
                                    e.printStackTrace();
                                }
                                break;
                            case 4:
                                System.out.println("Atras");
                                atras = true;
                                break;
                            default:
                                System.out.println("Solo numeros entre 1 y 4");
                        }
                    }
                    break;
                case 3:
                    System.out.println("Has seleccionado la opcion 3, Facturas\n");
                    while(!atras) {
                        opcion = crudMenu.pideMenuFactura();
                        switch (opcion) {
                            case 1:
                                System.out.println("Has seleccionado la opcion 1, emitir una factura");
                                String NIF = crudMenu.pideNIFCliente();
                                try {
                                    crudFactura.emitirFactura(NIF);
                                } catch (ClienteNoExisteException e) {
                                    e.printStackTrace();
                                }
                                break;
                            case 2:
                                System.out.println("Has seleccionado la opcion 2, recuperar datos factura");
                                codfac = crudMenu.pideCodigoFactura();
                                try {
                                    crudFactura.getFacturaCodigo(codfac);
                                } catch (FacturaNoExisteException e) {
                                    e.printStackTrace();
                                }
                                break;
                            case 3:
                                System.out.println("Has seleccionado la opcion 3,recuperar todas las facturas de un cliente");
                                crudFactura.listarFacturas();
                                break;
                            case 4:
                                System.out.println("Has seleccionado la opcion 4, recuperar factura entre fechas");
                                Calendar fecha1 = crudMenu.pideFecha();
                                Calendar fecha2 = crudMenu.pideFecha();
                                ArrayList<Factura> todas = crudFactura.getListaFacturas();
                                Collection<Factura> lista = null;
                                try {
                                    lista = crudGenerico.extraerPeriodo(fecha1, fecha2, todas);
                                    for (Factura iter : lista) {
                                        System.out.println(iter.toString());
                                    }
                                }catch (ErrorEntreFechasException e) {
                                    e.printStackTrace();
                                }
                                break;
                            case 5:
                                System.out.println("Atras");
                                atras = true;
                                break;
                            default:
                                System.out.println("Solo numeros entre 1 y 5");
                        }
                    }
                    break;
                case 4:
                    System.out.println("Adios!");
                    finalizar=true;
                    break;
                default:
                    System.out.println("Solo números entre 1 y 4");
            }

        }

    }
}
