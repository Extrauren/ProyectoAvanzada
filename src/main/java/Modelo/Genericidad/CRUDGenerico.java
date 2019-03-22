package Modelo.Genericidad;

import Controlador.Fecha;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collection;


public class CRUDGenerico {

    public  <T extends Fecha> Collection<T> extraerPeriodo(Calendar fechaIni, Calendar fechaFin, Collection<T> conjunto) {

        Collection<T> extraccion = new ArrayList<T>();
        for (T iter : conjunto) {
            if (iter.getFecha().compareTo(fechaIni) >= 0 && iter.getFecha().compareTo(fechaFin) <= 0) 
                extraccion.add(iter);
        }
        return extraccion;
    }
}