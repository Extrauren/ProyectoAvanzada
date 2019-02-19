package Modelo;

import Controlador.Cliente;
import Controlador.Llamada;

import java.util.Calendar;
import java.util.HashMap;

public class CRUDLlamada {


    HashMap<String, Llamada> mapaLlamadas = new HashMap<>();            // NIF clave y llamada valor (posible añadir otro mapa)
    private Llamada llamada;

    public void altaLLamada(String NIF, int telefono, Calendar fechaLlamada, int duracion){
        llamada = new Llamada(telefono, fechaLlamada, duracion);
        mapaLlamadas.put(NIF, llamada);
    }

    public HashMap<String, Llamada> listarLlamadas(){
        return mapaLlamadas;
    }

}
