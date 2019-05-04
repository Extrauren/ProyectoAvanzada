package Modelo.CRUD;

import Controlador.Tarifas.Tarifa;
import Modelo.Interfaces.*;

import java.io.Serializable;
import java.util.Calendar;
import java.util.Scanner;

import static java.lang.Integer.parseInt;

public class CRUDMenu implements IMenu, IMenuCliente, IMenuLlamada, IMenuFactura, IMenuGenerico, Serializable {

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
        System.out.println("3. Llamada entre fechas");
        System.out.println("4. Salir\n");
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
        System.out.println("4. Recuperar facturas entre fehcas");
        System.out.println("5. Atras\n");
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
        String direccion = sn.nextLine();
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
        float valor = sn.nextFloat();
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
    public int pideTipoTarifa() {
        System.out.println("Que tipo de tarifa deseas contratar: [1]Horas(0.05), [2]Dia(0), [3]Salir");
        int opcion = sn.nextInt();
        sn.nextLine();
        return opcion;
    }

    @Override
    public int pideHora() {
        System.out.println("Introduce una hora: ");
        int hora = sn.nextInt();
        sn.nextLine();
        return hora;
    }

    @Override
    public int pideDiaSemana() {
        System.out.println("Introduce el dia de la semana: ");
        int dia = sn.nextInt();
        sn.nextLine();
        return dia;
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

    @Override
    public Calendar pideFecha() {
        System.out.println("Introduce una fecha: dd/mm/yy");
        String fecha = sn.nextLine();
        String[] parts = fecha.split("/");
        Calendar fechaCal = Calendar.getInstance();
        fechaCal.set(parseInt(parts[2]), parseInt(parts[1]), parseInt(parts[0]));
        return fechaCal;
    }
}