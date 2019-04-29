package Modelo;

import Controlador.Llamada;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashMap;

public class CRUDLlamada implements Serializable {


    HashMap<String, ArrayList<Llamada>> mapaLlamadas = new HashMap<>();            // NIF clave y llamada valor (posible añadir otro mapa)
    ArrayList<Llamada> listaLlamadas = new ArrayList<>();

    public void altaLLamada(String NIF, int telefono, Calendar fechaLlamada, float duracion){
        Llamada llamada;
        ArrayList<Llamada> llamadas= new ArrayList<>();
        llamada = new Llamada(telefono, fechaLlamada, duracion);
        llamadas.add(llamada);
        mapaLlamadas.put(NIF, llamadas);
        listaLlamadas.add(llamada);
    }

    public ArrayList<Llamada> muestraLlamadaCliente(String nif){

        return mapaLlamadas.get(nif);
    }

    public ArrayList<Llamada> getListaLlamadas() {
        return listaLlamadas;
    }

}
