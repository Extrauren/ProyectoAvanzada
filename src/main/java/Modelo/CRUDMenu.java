package Modelo;

import java.util.Scanner;

public class CRUDMenu implements IMenu{

    Scanner sn = new Scanner(System.in);

    @Override
    public int pideMenuGlobal() {
        System.out.println("¿Con que deseas tramitar?\n");

        System.out.println("1. Clientes");
        System.out.println("2. Llamadas");
        System.out.println("3. Facturas");
        System.out.println("4. Finalizar");

        System.out.println("Escribe una de las opciones: \n");
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
        System.out.println("6. Salir");

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
        System.out.println("3. Salir");
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
        System.out.println("4. Atras");
        System.out.println("Escribe una de las opciones: ");
        opcion = sn.nextInt();
        return opcion;
    }

}
