package Vista;

import Controlador.Cliente;
import Controlador.Empresa;
import Controlador.Particular;
import Controlador.Tarifa;
import Modelo.CRUDCliente;
import Modelo.CRUDMenu;

import java.util.Calendar;
import java.util.Scanner;

public class Menu {

    private static CRUDMenu crudMenu = new CRUDMenu();
    private static CRUDCliente crudCliente = new CRUDCliente();
    public static void main (String[] args){

        //Se introduce dentro el menu que pide datos por consola

        Scanner sn = new Scanner(System.in);
        boolean finalizar = false;
        int opcion;                                                 //Guardaremos la opcion del usuario
        String nombre;
        String NIF;
        String direccion;
        String correo;
        Calendar fechaAlta;
        Tarifa tarifa;
        String apellido;
        String clase;
        while(!finalizar){

            boolean atras = false;
            opcion = crudMenu.pideMenuGlobal();


            switch(opcion){

                case 1:
                    while(!atras) {
                        opcion = crudMenu.pideMenuCliente();
                        switch (opcion) {
                            case 1:
                                System.out.println("Has seleccionado la opcion 1, dar de alta un nuevo cliente");
                                nombre = crudMenu.pideNombreCliente();
                                NIF= crudMenu.pideNIFCliente();
                                direccion = crudMenu.pideDireccionCleinte();
                                correo = crudMenu.pideCorreoCliente();
                                fechaAlta = Calendar.getInstance();
                                tarifa = crudMenu.pideTarifaClietne();
                                clase = crudMenu.pideTipoCliente();
                                if (clase.equals("particular")){
                                    apellido=crudMenu.pideApellido();
                                    crudCliente.altaClienteParticular(nombre, NIF, direccion, correo, fechaAlta, tarifa, apellido);

                                }else{
                                    crudCliente.altaClienteEmpresa(nombre, NIF, direccion, correo, fechaAlta, tarifa);
                                }
                                break;
                            case 2:
                                System.out.println("Has seleccionado la opcion 2, borrar un cliente");
                                NIF = crudMenu.pideNIFCliente();
                                crudCliente.borrarCliente(NIF);
                                break;
                            case 3:
                                System.out.println("Has seleccionado la opcion 3, cambiar la tarifa");
                                tarifa = crudMenu.pideTarifaClietne();
                                NIF = crudMenu.pideNIFCliente();
                                crudCliente.cambiaTarifa(NIF, tarifa);
                                break;
                            case 4:
                                System.out.println("Has seleccionado la opcion 4, recuperar datos por NIF");
                                NIF = crudMenu.pideNIFCliente();
                                crudCliente.getCliente(NIF);
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
                                break;
                            case 2:
                                System.out.println("Has seleccionado la opcion 2, listar las llamadas de un cliente");
                                break;
                            case 3:
                                System.out.println("Atras");
                                atras = true;
                                break;
                            default:
                                System.out.println("Solo numeros entre 1 y 3");
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
                                break;
                            case 2:
                                System.out.println("Has seleccionado la opcion 2, recuperar datos factura");
                                break;
                            case 3:
                                System.out.println("Has seleccionado la opcion 3,recuperar todas las facturas de un cliente");
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
