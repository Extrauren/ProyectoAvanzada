package Controlador.Ejecutar;

import Modelo.Factura;
import Modelo.Llamada;
import Modelo.Tarifas.Tarifa;
import Modelo.Tarifas.TarifaBasica;
import Modelo.Tarifas.TarifaDias;
import Modelo.Tarifas.TarifaHoras;
import Controlador.Excepciones.ClienteNoExisteException;
import Controlador.Excepciones.ErrorEntreFechasException;
import Controlador.Excepciones.FacturaNoExisteException;
import Controlador.ControladorCliente;
import Controlador.ControladorFactura;
import Controlador.ControladorLlamada;
import Controlador.ControladorMenu;
import Controlador.Factory.FabricaCliente;
import Controlador.Factory.FabricaTarifa;
import Controlador.ControladorGenerico;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collection;

public class Menu implements Serializable {

    ControladorMenu controladorMenu;
    ControladorCliente controladorCliente;
    ControladorLlamada controladorLlamada;
    ControladorFactura controladorFactura;
    ControladorGenerico controladorGenerico;
    FabricaTarifa fabricaTarifa;
    FabricaCliente fabricaCliente;

    public Menu(){
        controladorMenu = new ControladorMenu();
        controladorCliente = new ControladorCliente();
        controladorLlamada = new ControladorLlamada();
        controladorFactura = new ControladorFactura(controladorCliente, controladorLlamada);
        controladorGenerico = new ControladorGenerico();
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
            opcion = this.controladorMenu.pideMenuGlobal();


            switch(opcion){
                case 1:
                    while(!atras) {
                        opcion = controladorMenu.pideMenuCliente();
                        switch (opcion) {
                            case 1:
                                System.out.println("Has seleccionado la opcion 1, dar de alta un nuevo cliente \n");
                                nombre = controladorMenu.pideNombreCliente();
                                fechaAlta = Calendar.getInstance();
                                nif= controladorMenu.pideNIFCliente();
                                ArrayList<Tarifa> tarifas = new ArrayList<>();
                                TarifaBasica basica = (TarifaBasica) fabricaTarifa.getTarifaBasica(0.15f);
                                tarifas.add(basica);
                                direccion = controladorMenu.pideDireccionCleinte();
                                correo = controladorMenu.pideCorreoCliente();
                                clase = controladorMenu.pideTipoCliente();
                                tipo= controladorMenu.pideTipoTarifa();
                                while(tipo < 3) {
                                    if (tipo == 1) {
                                        horaIni = controladorMenu.pideHora();
                                        horaFin = controladorMenu.pideHora();
                                        TarifaHoras horas = (TarifaHoras) fabricaTarifa.getTarifaHoras(basica, 0.05f, horaIni, horaFin);
                                        tarifas.add(horas);
                                        tipo = controladorMenu.pideTipoTarifa();
                                    }
                                    if (tipo == 2) {
                                        int dia = controladorMenu.pideDiaSemana();
                                        TarifaDias dias = (TarifaDias) fabricaTarifa.getTarifaDias(basica, 0.05f, dia);
                                        tarifas.add(dias);
                                        tipo= controladorMenu.pideTipoTarifa();
                                    }
                                }
                                if (clase.equals("particular")){
                                    apellido= controladorMenu.pideApellido();
                                    controladorCliente.anyadeClietne(fabricaCliente.getClienteParticular(nombre, nif, direccion, correo, fechaAlta, tarifas, apellido));
                                }else{
                                    controladorCliente.anyadeClietne(fabricaCliente.getClienteEmpresa(nombre, nif, direccion, correo, fechaAlta, tarifas));
                                }

                                try {
                                    System.out.println("Cliente creado" + controladorCliente.getCliente(nif).toString());
                                } catch (ClienteNoExisteException e) {
                                    e.printStackTrace();
                                }
                                break;
                            case 2:
                                System.out.println("Has seleccionado la opcion 2, borrar un cliente");
                                nif = controladorMenu.pideNIFCliente();
                                try {
                                    controladorCliente.borrarCliente(nif);
                                } catch (ClienteNoExisteException e) {
                                    e.printStackTrace();
                                }
                                break;
                            case 3:
                                System.out.println("Has seleccionado la opcion 3, cambiar la tarifa");
                                ArrayList<Tarifa> tarifas2 = new ArrayList<>();
                                TarifaBasica basica2 = (TarifaBasica) fabricaTarifa.getTarifaBasica(0.15f);
                                tarifas2.add(basica2);
                                tipo= controladorMenu.pideTipoTarifa();
                                while(tipo < 3) {
                                    if (tipo == 1) {
                                        horaIni = controladorMenu.pideHora();
                                        horaFin = controladorMenu.pideHora();
                                        TarifaHoras horas2 = (TarifaHoras) fabricaTarifa.getTarifaHoras(basica2, 0.05f, horaIni, horaFin);
                                        tarifas2.add(horas2);
                                        tipo = controladorMenu.pideTipoTarifa();
                                    }
                                    if (tipo == 2) {
                                        int dia = controladorMenu.pideDiaSemana();
                                        TarifaDias dias = (TarifaDias) fabricaTarifa.getTarifaDias(basica2, 0.05f, dia);
                                        tarifas2.add(dias);
                                        controladorMenu.pideTipoTarifa();
                                    }
                                }
                                String dni= controladorMenu.pideNIFCliente();
                                try {
                                    controladorCliente.cambiaTarifa(dni, tarifas2);
                                } catch (ClienteNoExisteException e) {
                                    e.printStackTrace();
                                }
                                break;
                            case 4:
                                System.out.println("Has seleccionado la opcion 4, recuperar datos por NIF");
                                nif = controladorMenu.pideNIFCliente();
                                try {
                                    controladorCliente.getCliente(nif);
                                } catch (ClienteNoExisteException e) {
                                    e.printStackTrace();
                                }
                                break;
                            case 5:
                                System.out.println("Has seleccionado la opcion 5, listar todos los clientes");
                                controladorCliente.mostrarClientes();
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
                        opcion = controladorMenu.pideMenuLlamadas();
                        switch (opcion) {
                            case 1:
                                System.out.println("Has seleccionado la opcion 1, dar de alta una nueva llamada");
                                nif = controladorMenu.pideNIFCliente();
                                tel = controladorMenu.pideTelefono();
                                fechaAlta = Calendar.getInstance();
                                duracion = controladorMenu.pideDuracion();
                                controladorLlamada.altaLLamada(nif, tel, duracion);
                                break;
                            case 2:
                                System.out.println("Has seleccionado la opcion 2, listar las llamadas de un cliente");
                                nif = controladorMenu.pideNIFCliente();
                                System.out.println(controladorLlamada.muestraLlamadaCliente(nif));
                                break;
                            case 3:
                                System.out.println("Has seleccionado la opcion 3, sacar llamada entre fechas");
                                Calendar fecha1 = controladorMenu.pideFecha();
                                fecha = controladorMenu.pideFecha();
                                ArrayList<Llamada> todas = controladorLlamada.getListaLlamadas();
                                Collection<Llamada> lista = null;
                                try {
                                    lista = controladorGenerico.extraerPeriodo(fecha1, fecha, todas);
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
                        opcion = controladorMenu.pideMenuFactura();
                        switch (opcion) {
                            case 1:
                                System.out.println("Has seleccionado la opcion 1, emitir una factura");
                                String NIF = controladorMenu.pideNIFCliente();
                                try {
                                    controladorFactura.emitirFactura(NIF);
                                } catch (ClienteNoExisteException e) {
                                    e.printStackTrace();
                                }
                                break;
                            case 2:
                                System.out.println("Has seleccionado la opcion 2, recuperar datos factura");
                                codfac = controladorMenu.pideCodigoFactura();
                                try {
                                    controladorFactura.getFacturaCodigo(codfac);
                                } catch (FacturaNoExisteException e) {
                                    e.printStackTrace();
                                }
                                break;
                            case 3:
                                System.out.println("Has seleccionado la opcion 3,recuperar todas las facturas de un cliente");
                                controladorFactura.listarFacturas();
                                break;
                            case 4:
                                System.out.println("Has seleccionado la opcion 4, recuperar factura entre fechas");
                                Calendar fecha1 = controladorMenu.pideFecha();
                                Calendar fecha2 = controladorMenu.pideFecha();
                                ArrayList<Factura> todas = controladorFactura.getListaFacturas();
                                Collection<Factura> lista = null;
                                try {
                                    lista = controladorGenerico.extraerPeriodo(fecha1, fecha2, todas);
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
