package Modelo;

import Controlador.Tarifa;
import Vista.IMenu;
import Vista.IMenuCliente;
import Vista.IMenuFactura;
import Vista.IMenuLlamada;

import java.io.Serializable;
import java.util.Scanner;

public class CRUDMenu implements IMenu, IMenuCliente, IMenuLlamada, IMenuFactura, Serializable {

    Scanner sn;
    public CRUDMenu() {
        sn = new Scanner(System.in);
    }

    @Override
    public int pideMenuGlobal() {
        System.out.println("¿Con que deseas tramitar?\n");

        System.out.println("1. Clientes");
        System.out.println("2. Llamadas");
        System.out.println("3. Facturas");
        System.out.println("4. Finalizar\n");

        System.out.println("Escribe una de las opciones: ");
        int opcion = sn.nextInt();
        sn.nextLine();

        return opcion;
    }

    @Override
    public int pideMenuCliente() {
        System.out.println("Has seleccionado la opcion 1, Clientes\n");
        System.out.println("¿Que opcion eliges?\n");

        System.out.println("1. Dar de alta un nuevo cliente");
        System.out.println("2. Borrar un cliente");
        System.out.println("3. Cambiar la tarifa");
        System.out.println("4. Recuperar datos por NIF");
        System.out.println("5. Listar todos los clientes");
        System.out.println("6. Salir\n");

        System.out.println("Escribe una de las opciones: ");
        int opcion = sn.nextInt();
        sn.nextLine();
        return opcion;
    }

    @Override
    public int pideMenuLlamadas() {
        System.out.println("¿Que opcion eliges?\n");
        System.out.println("1. Dar de alta una llamada");
        System.out.println("2. Listar las llamadas de un cliente");
        System.out.println("3. Salir\n");
        System.out.println("Escribe una de las opciones: ");
        int opcion = sn.nextInt();
        sn.nextLine();
        return opcion;
    }

    @Override
    public int pideMenuFactura() {
        int opcion;
        System.out.println("¿Que opcion eliges?\n");

        System.out.println("1. Emitir factura");
        System.out.println("2. Recuperar datos factura");
        System.out.println("3. Recuperar todas las facturas de un cliente");
        System.out.println("4. Atras\n");
        System.out.println("Escribe una de las opciones: ");
        opcion = sn.nextInt();
        sn.nextLine();
        return opcion;
    }


    @Override
    public String pideNombreCliente() {
        System.out.println("Introduce el nombre del cliente: ");
        String nombre = sn.nextLine();
        return nombre;
    }

    @Override
    public String pideNIFCliente() {
        System.out.println("Introduce el NIF del cliente: ");
        String nif = sn.nextLine();
        return nif;
    }

    @Override
    public String pideDireccionCleinte() {
        System.out.println("Introduce la direccion del cliente: ");
        String direccion= sn.nextLine();
        return direccion;
    }

    @Override
    public String pideCorreoCliente() {
        System.out.println("Introduce el correo del cliente: ");
        String correo = sn.nextLine();
        return correo;
    }

    @Override
    public Tarifa pideTarifaClietne() {
        System.out.println("Introduce la tarifa del cliente: ");
        int valor = sn.nextInt();
        Tarifa tarifa = new Tarifa(valor);
        sn.nextLine();
        return tarifa;
    }

    @Override
    public String pideTipoCliente() {
        System.out.println("Introduce que clase de cliente deseas crear: (particular o empresa)");
        String clase = sn.nextLine();
        return clase;
    }

    @Override
    public String pideApellido() {
        System.out.println("Introduce el apellido del cliente: ");
        String apellido = sn.nextLine();
        return apellido;
    }

    @Override
    public int pideTelefono() {
        System.out.println("Introduce el telefono: ");
        int telefono = sn.nextInt();
        sn.nextLine();
        return telefono;
    }

    @Override
    public float pideDuracion() {
        System.out.println("Introduce la duracion: ");
        float duracion = sn.nextFloat();
        sn.nextLine();
        return duracion;
    }

    @Override
    public String pideCodigoFactura() {
        System.out.println("Introduce el codigo de la factua: ");
        String codfac = sn.nextLine();
        return codfac;
    }

}
