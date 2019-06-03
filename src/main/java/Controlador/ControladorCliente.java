package Controlador;

import Modelo.Cliente;
import Modelo.Tarifas.Tarifa;
import Controlador.Excepciones.ClienteNoExisteException;


import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;

public class ControladorCliente implements Serializable {


    HashMap<String, Cliente> mapaClientes = new HashMap<>();
    ArrayList<Cliente> listaClietnes = new ArrayList<>();

    public String mostrarClientes(){
        //System.out.println(mapaClientes.toString());
        return mapaClientes.toString();
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
        System.out.println(NIF);
        Cliente cli = recuperarClientePorDNI(NIF)[0];
        mapaClientes.remove(NIF);
        listaClietnes.remove(cli);

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

    public String[] listadoClientes(){
        String[] salida = new String[listaClietnes.size()];
        int i=0;
        for(Cliente c : this.listaClietnes){
            salida[i] = c.toString();
            i++;
        }
        return salida;
    }

}
