package Modelo;

import Controlador.Cliente;
import Controlador.Empresa;
import Controlador.Particular;
import Controlador.Tarifas.Tarifa;
import Modelo.Excepciones.ClienteNoExisteException;


import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;

public class ModeloCliente implements Serializable {


    HashMap<String, Cliente> mapaClientes = new HashMap<>();
    ArrayList<Cliente> listaClietnes = new ArrayList<>();

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

    public Cliente getCliente(String NIF) throws ClienteNoExisteException {
        return mapaClientes.get(NIF);

    }
    public void anyadeClietne(Cliente cliente){
        String nif = cliente.getNIF();
        mapaClientes.put(nif, cliente);
        listaClietnes.add(cliente);
        System.out.println("añadido");

    }
    public Cliente[] recuperarClientePorDNI(String nif) {
        Cliente unCliente[] = new Cliente[1];
        try {
            unCliente[0] = this.getCliente(nif);
        } catch (ClienteNoExisteException e) {
            e.printStackTrace();
        }
        return unCliente;
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

    public void listarClientes() {
        for (Cliente c : listaClietnes) {
            System.out.println("Cliente: " + c.toString());
        }

    }

    public String listadoClientes(){
        String salida = "";
        for(Cliente c : this.listaClietnes){
            salida = salida + c.toString();
        }
        return salida;
    }

}
