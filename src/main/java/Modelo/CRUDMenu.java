package Modelo;

import Controlador.Cliente;
import Controlador.Empresa;
import Controlador.Particular;
import Controlador.Tarifa;
import Vista.IMenu;
import Vista.IMenuCliente;
import java.util.Scanner;

public class CRUDMenu implements IMenu, IMenuCliente {

    Scanner sn = new Scanner(System.in);

    @Override
    public int pideMenuGlobal() {
        System.out.println("¿Con que deseas tramitar?\n");

        System.out.println("1. Clientes");
        System.out.println("2. Llamadas");
        System.out.println("3. Facturas");
        System.out.println("4. Finalizar\n");

        System.out.println("Escribe una de las opciones: ");
        int opcion = sn.nextInt();

        return opcion;
    }

    @Override
    public int pideMenuCliente() {
        int opcion;
        System.out.println("Has seleccionado la opcion 1, Clientes\n");
        System.out.println("¿Que opcion eliges?\n");

        System.out.println("1. Dar de alta un nuevo cliente");
        System.out.println("2. Borrar un cliente");
        System.out.println("3. Cambiar la tarifa");
        System.out.println("4. Recuperar datos por NIF");
        System.out.println("5. Listar todos los clientes");
        System.out.println("6. Salir\n");

        System.out.println("Escribe una de las opciones: ");
        opcion = sn.nextInt();
        return opcion;
    }

    @Override
    public int pideMenuLlamadas() {
        int opcion;
        System.out.println("¿Que opcion eliges?\n");
        System.out.println("1. Dar de alta una llamada");
        System.out.println("2. Listar las llamadas de un cliente");
        System.out.println("3. Salir\n");
        System.out.println("Escribe una de las opciones: ");
        opcion = sn.nextInt();

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
        return opcion;
    }


    @Override
    public String pideNombreCliente() {
        String nombre;
        System.out.println("Introduce el nombre del cliente: ");
        nombre = sn.nextLine();
        return nombre;
    }

    @Override
    public String pideNIFCliente() {
        String NIF;
        System.out.println("Introduce el NIF del cliente: ");
        NIF = sn.nextLine();
        return NIF;
    }

    @Override
    public String pideDireccionCleinte() {
        String direccion;
        System.out.println("Introduce la direccion del cliente: ");
        direccion= sn.nextLine();
        return direccion;
    }

    @Override
    public String pideCorreoCliente() {
        String correo;
        System.out.println("Introduce el correo del cliente: ");
        correo = sn.nextLine();
        return correo;
    }

    @Override
    public Tarifa pideTarifaClietne() {
        Tarifa tarifa;
        int valor;
        System.out.println("Introduce la nueva tarifa del cliente: ");
        valor = sn.nextInt();
        tarifa = new Tarifa(valor);
        return tarifa;
    }

    @Override
    public String pideTipoCliente() {
        String clase;
        System.out.println("Introduce que clase de cliente deseas crear: (particular o empresa)");
        clase = sn.nextLine();
        return clase;
    }

    @Override
    public String pideApellido() {
        String apellido;
        System.out.println("Introduce el apellido del cliente: ");
        apellido = sn.nextLine();
        return apellido;
    }
}
