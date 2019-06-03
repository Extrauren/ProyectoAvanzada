package Controlador;

import Modelo.Llamada;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;

public class ControladorLlamada implements Serializable {


    HashMap<String, ArrayList<Llamada>> mapaLlamadas = new HashMap<>();            // NIF clave y llamada valor (posible añadir otro mapa)
    ArrayList<Llamada> listaLlamadas = new ArrayList<>();

    public void altaLLamada(String NIF, int telefono,  float duracion){
        Llamada llamada;
        ArrayList<Llamada> llamadas=mapaLlamadas.get(NIF);
        if(llamadas==null)
            llamadas = new ArrayList<Llamada>();
        llamada = new Llamada(telefono, duracion);
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
