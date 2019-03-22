package Modelo;

import Controlador.Cliente;
import Controlador.Llamada;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashMap;

public class CRUDLlamada implements Serializable {


    HashMap<String, Llamada> mapaLlamadas = new HashMap<>();            // NIF clave y llamada valor (posible añadir otro mapa)
    ArrayList<Llamada> listaLlamadas = new ArrayList<>();

    public void altaLLamada(String NIF, int telefono, Calendar fechaLlamada, float duracion){
        Llamada llamada;
        llamada = new Llamada(telefono, fechaLlamada, duracion);
        mapaLlamadas.put(NIF, llamada);
        listaLlamadas.add(llamada);
    }

    public Llamada mustraLlamadaCliente(String nif){

        return mapaLlamadas.get(nif);
    }

    public ArrayList<Llamada> getListaLlamadas() {
        return listaLlamadas;
    }

}
