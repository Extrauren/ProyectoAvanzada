package Modelo.Ejecutar;

import Controlador.Factura;
import Controlador.Llamada;
import Controlador.Tarifas.Tarifa;
import Controlador.Tarifas.TarifaBasica;
import Controlador.Tarifas.TarifaDias;
import Controlador.Tarifas.TarifaHoras;
import Modelo.Excepciones.ClienteNoExisteException;
import Modelo.Excepciones.ErrorEntreFechasException;
import Modelo.Excepciones.FacturaNoExisteException;
import Modelo.ModeloCliente;
import Modelo.ModeloFactura;
import Modelo.ModeloLlamada;
import Modelo.ModeloMenu;
import Modelo.Factory.FabricaCliente;
import Modelo.Factory.FabricaTarifa;
import Modelo.ModeloGenerico;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collection;

public class Menu implements Serializable {

    ModeloMenu modeloMenu;
    ModeloCliente modeloCliente;
    ModeloLlamada modeloLlamada;
    ModeloFactura modeloFactura;
    ModeloGenerico modeloGenerico;
    FabricaTarifa fabricaTarifa;
    FabricaCliente fabricaCliente;

    public Menu(){
        modeloMenu = new ModeloMenu();
        modeloCliente = new ModeloCliente();
        modeloLlamada = new ModeloLlamada();
        modeloFactura = new ModeloFactura(modeloCliente, modeloLlamada);
        modeloGenerico = new ModeloGenerico();
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
            opcion = this.modeloMenu.pideMenuGlobal();


            switch(opcion){
                case 1:
                    while(!atras) {
                        opcion = modeloMenu.pideMenuCliente();
                        switch (opcion) {
                            case 1:
                                System.out.println("Has seleccionado la opcion 1, dar de alta un nuevo cliente \n");
                                nombre = modeloMenu.pideNombreCliente();
                                fechaAlta = Calendar.getInstance();
                                nif= modeloMenu.pideNIFCliente();
                                ArrayList<Tarifa> tarifas = new ArrayList<>();
                                TarifaBasica basica = (TarifaBasica) fabricaTarifa.getTarifaBasica(0.15f);
                                tarifas.add(basica);
                                direccion = modeloMenu.pideDireccionCleinte();
                                correo = modeloMenu.pideCorreoCliente();
                                clase = modeloMenu.pideTipoCliente();
                                tipo= modeloMenu.pideTipoTarifa();
                                while(tipo < 3) {
                                    if (tipo == 1) {
                                        horaIni = modeloMenu.pideHora();
                                        horaFin = modeloMenu.pideHora();
                                        TarifaHoras horas = (TarifaHoras) fabricaTarifa.getTarifaHoras(basica, 0.05f, horaIni, horaFin);
                                        tarifas.add(horas);
                                        tipo = modeloMenu.pideTipoTarifa();
                                    }
                                    if (tipo == 2) {
                                        int dia = modeloMenu.pideDiaSemana();
                                        TarifaDias dias = (TarifaDias) fabricaTarifa.getTarifaDias(basica, 0.05f, dia);
                                        tarifas.add(dias);
                                        tipo= modeloMenu.pideTipoTarifa();
                                    }
                                }
                                if (clase.equals("particular")){
                                    apellido= modeloMenu.pideApellido();
                                    modeloCliente.anyadeClietne(fabricaCliente.getClienteParticular(nombre, nif, direccion, correo, fechaAlta, tarifas, apellido));
                                }else{
                                    modeloCliente.anyadeClietne(fabricaCliente.getClienteEmpresa(nombre, nif, direccion, correo, fechaAlta, tarifas));
                                }

                                try {
                                    System.out.println("Cliente creado" + modeloCliente.getCliente(nif).toString());
                                } catch (ClienteNoExisteException e) {
                                    e.printStackTrace();
                                }
                                break;
                            case 2:
                                System.out.println("Has seleccionado la opcion 2, borrar un cliente");
                                nif = modeloMenu.pideNIFCliente();
                                try {
                                    modeloCliente.borrarCliente(nif);
                                } catch (ClienteNoExisteException e) {
                                    e.printStackTrace();
                                }
                                break;
                            case 3:
                                System.out.println("Has seleccionado la opcion 3, cambiar la tarifa");
                                ArrayList<Tarifa> tarifas2 = new ArrayList<>();
                                TarifaBasica basica2 = (TarifaBasica) fabricaTarifa.getTarifaBasica(0.15f);
                                tarifas2.add(basica2);
                                tipo= modeloMenu.pideTipoTarifa();
                                while(tipo < 3) {
                                    if (tipo == 1) {
                                        horaIni = modeloMenu.pideHora();
                                        horaFin = modeloMenu.pideHora();
                                        TarifaHoras horas2 = (TarifaHoras) fabricaTarifa.getTarifaHoras(basica2, 0.05f, horaIni, horaFin);
                                        tarifas2.add(horas2);
                                        tipo = modeloMenu.pideTipoTarifa();
                                    }
                                    if (tipo == 2) {
                                        int dia = modeloMenu.pideDiaSemana();
                                        TarifaDias dias = (TarifaDias) fabricaTarifa.getTarifaDias(basica2, 0.05f, dia);
                                        tarifas2.add(dias);
                                        modeloMenu.pideTipoTarifa();
                                    }
                                }
                                String dni= modeloMenu.pideNIFCliente();
                                try {
                                    modeloCliente.cambiaTarifa(dni, tarifas2);
                                } catch (ClienteNoExisteException e) {
                                    e.printStackTrace();
                                }
                                break;
                            case 4:
                                System.out.println("Has seleccionado la opcion 4, recuperar datos por NIF");
                                nif = modeloMenu.pideNIFCliente();
                                try {
                                    modeloCliente.getCliente(nif);
                                } catch (ClienteNoExisteException e) {
                                    e.printStackTrace();
                                }
                                break;
                            case 5:
                                System.out.println("Has seleccionado la opcion 5, listar todos los clientes");
                                modeloCliente.mostrarClientes();
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
                        opcion = modeloMenu.pideMenuLlamadas();
                        switch (opcion) {
                            case 1:
                                System.out.println("Has seleccionado la opcion 1, dar de alta una nueva llamada");
                                nif = modeloMenu.pideNIFCliente();
                                tel = modeloMenu.pideTelefono();
                                fechaAlta = Calendar.getInstance();
                                duracion = modeloMenu.pideDuracion();
                                modeloLlamada.altaLLamada(nif, tel, duracion);
                                break;
                            case 2:
                                System.out.println("Has seleccionado la opcion 2, listar las llamadas de un cliente");
                                nif = modeloMenu.pideNIFCliente();
                                System.out.println(modeloLlamada.muestraLlamadaCliente(nif));
                                break;
                            case 3:
                                System.out.println("Has seleccionado la opcion 3, sacar llamada entre fechas");
                                Calendar fecha1 = modeloMenu.pideFecha();
                                fecha = modeloMenu.pideFecha();
                                ArrayList<Llamada> todas = modeloLlamada.getListaLlamadas();
                                Collection<Llamada> lista = null;
                                try {
                                    lista = modeloGenerico.extraerPeriodo(fecha1, fecha, todas);
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
                        opcion = modeloMenu.pideMenuFactura();
                        switch (opcion) {
                            case 1:
                                System.out.println("Has seleccionado la opcion 1, emitir una factura");
                                String NIF = modeloMenu.pideNIFCliente();
                                try {
                                    modeloFactura.emitirFactura(NIF);
                                } catch (ClienteNoExisteException e) {
                                    e.printStackTrace();
                                }
                                break;
                            case 2:
                                System.out.println("Has seleccionado la opcion 2, recuperar datos factura");
                                codfac = modeloMenu.pideCodigoFactura();
                                try {
                                    modeloFactura.getFacturaCodigo(codfac);
                                } catch (FacturaNoExisteException e) {
                                    e.printStackTrace();
                                }
                                break;
                            case 3:
                                System.out.println("Has seleccionado la opcion 3,recuperar todas las facturas de un cliente");
                                modeloFactura.listarFacturas();
                                break;
                            case 4:
                                System.out.println("Has seleccionado la opcion 4, recuperar factura entre fechas");
                                Calendar fecha1 = modeloMenu.pideFecha();
                                Calendar fecha2 = modeloMenu.pideFecha();
                                ArrayList<Factura> todas = modeloFactura.getListaFacturas();
                                Collection<Factura> lista = null;
                                try {
                                    lista = modeloGenerico.extraerPeriodo(fecha1, fecha2, todas);
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
