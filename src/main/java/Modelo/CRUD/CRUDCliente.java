package Modelo.CRUD;

import Controlador.Cliente;
import Controlador.Tarifas.Tarifa;
import Modelo.Excepciones.ClienteNoExisteException;
import Modelo.Factory.FabricaCliente;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;

public class CRUDCliente implements Serializable {


    HashMap<String, Cliente> mapaClientes = new HashMap<>();
    ArrayList<Cliente> listaClietnes = new ArrayList<>();
    private FabricaCliente fabricaCliente;


    public void anyadeClietne(Cliente cliente){
        String nif = cliente.getNIF();
        mapaClientes.put(nif, cliente);
        listaClietnes.add(cliente);
    }

    public void borrarCliente(String NIF) throws ClienteNoExisteException{
        mapaClientes.remove(NIF);
        for(int i =0; i<getNumClientes(); i++){
            if(listaClietnes.get(i).getNIF().equals(NIF)){
                listaClietnes.remove(i);
            }
        }
    }

    public void cambiaTarifa(String NIF, ArrayList<Tarifa> tarifa) throws  ClienteNoExisteException{   //Luego se cambia por la clase Tarifa
        Cliente cliente;
        cliente = mapaClientes.get(NIF);
        cliente.setTarifa(tarifa);
        System.out.println(cliente.toString());

    }

    public Cliente getCliente(String NIF) throws ClienteNoExisteException {
        return mapaClientes.get(NIF);

    }


    public  void mostrarClientes(){
        System.out.println(mapaClientes.toString());
    }

    public  HashMap<String, Cliente> getMapaClientes(){
        return this.mapaClientes;
    }

    public ArrayList<Cliente> getListaClientes(){
        return this.listaClietnes;
    }

    public int getNumClientes(){
        return mapaClientes.size();
    }

}
