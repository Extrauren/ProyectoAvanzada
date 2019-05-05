package Modelo.Genericidad;

import Modelo.Interfaces.Fecha;
import Modelo.Excepciones.ErrorEntreFechasException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collection;
import java.util.Scanner;


public class CRUDGenerico {

    public  <T extends Fecha> Collection<T> extraerPeriodo(Calendar fechaIni, Calendar fechaFin, Collection<T> conjunto) throws ErrorEntreFechasException {

        Collection<T> extraccion = new ArrayList<T>();
        for (T iter : conjunto) {
            if (iter.getFecha().compareTo(fechaIni) >= 0 && iter.getFecha().compareTo(fechaFin) <= 0)
                extraccion.add(iter);
        }
        return extraccion;
    }
    /*public static Calendar pedirFecha(){

        int dia, mes, anyo, hora, min;
        Scanner sc = new Scanner(System.in);
        System.out.println("Introduce la fecha: (xx/xx/xxxx)");
        String fech = sc.nextLine();

        dia = Integer.parseInt(fech.substring(0,2));
        mes = Integer.parseInt(fech.substring(3,5));
        anyo = Integer.parseInt(fech.substring(6,10));

        hora = min = 0;
        Calendar fecha = null;
        Calendar.getInstance().set(anyo, mes, dia, hora, min);
        return fecha;
    }
    public static Calendar pedirFechaConHora(){
        int dia, mes, anyo, hora, min;
        Scanner sc = new Scanner(System.in);
        System.out.println("Introduce la fecha: (xx/xx/xxxx)");
        String fech = sc.nextLine();
        dia = Integer.parseInt(fech.substring(0,2));
        mes = Integer.parseInt(fech.substring(3,5));
        anyo = Integer.parseInt(fech.substring(6,10));

        System.out.println("¿Introducir hora?");
        String horaTrue =  sc.nextLine();
        if(horaTrue.equals("si")){
            System.out.println("Introduce la hora de la llamada: (xx:xx)");
            String f =  sc.nextLine();
            hora = Integer.parseInt(f.substring(0, 2));
            min = Integer.parseInt(f.substring(3, 5));
        }else{
            hora = min = 0;
        }
        hora = min = 0;
        Calendar fecha = null;
        Calendar.getInstance().set(anyo, mes, dia, hora, min);
        return fecha;
    }*/
    public static boolean compruebaFecha(Calendar ini, Calendar fin) throws ErrorEntreFechasException {
        if(ini.before(fin))
            return true;
        throw new ErrorEntreFechasException();
    }
}