package Controlador;


import Controlador.Factory.FabricaTarifa;
import Modelo.Cliente;
import Modelo.Tarifas.Tarifa;
import Controlador.Excepciones.ClienteNoExisteException;
import Modelo.Tarifas.TarifaBasica;


import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;

public class ControladorCliente implements Serializable {

    FabricaTarifa fabricaTarifa;
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
        if(!mapaClientes.containsKey(nif)) {
            mapaClientes.put(nif, cliente);
            listaClietnes.add(cliente);
            System.out.println("añadido");
        }else{
            System.out.println("El cliente ya existia");
        }

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
        if(mapaClientes.containsKey(NIF)){
            Cliente cli = recuperarClientePorDNI(NIF)[0];
            mapaClientes.remove(NIF);
            listaClietnes.remove(cli);
            System.out.println("Cliente eliminado");
        }else{
            System.out.println("El cliente no exisitia");
        }
    }

    public void cambiaTarifa(String NIF, ArrayList<Tarifa> tarifa) throws ClienteNoExisteException{
        Cliente cliente= mapaClientes.get(NIF);
        cliente.setTarifa(tarifa);
        System.out.println(cliente.toString());

    }

    public void anyadirUnaTarifa(String nif, Tarifa tarifa){
        Cliente cliente = mapaClientes.get(nif);
        ArrayList<Tarifa> listaTarifas = cliente.getTarifa();
        listaTarifas.add(tarifa);
        cliente.setTarifa(listaTarifas);
    }
    public void insertarTarifaDia(String DNI, int dia) throws  ClienteNoExisteException{
        Tarifa tarifaPadre = null;
        for(Tarifa iter :  this.getCliente(DNI).getTarifa()){
            if(iter.equals(this.getCliente(DNI).getTarifa().size()-1)){
                tarifaPadre = iter;
            }
        }
        Tarifa nueva = fabricaTarifa.getTarifaDias(tarifaPadre, 0.1f ,dia);
        this.getCliente(DNI).getTarifa().add(nueva);
    }

    public void listarClientes() {
        if(mapaClientes.isEmpty()){

        }else{
            for (Cliente c : listaClietnes) {
                System.out.println("Cliente: " + c.toString());
            }
        }
    }

    public String[] listadoClientes(){
        String[] salida = new String[listaClietnes.size()];
        int i=0;
        if(mapaClientes.isEmpty()){
            System.out.println("No hay clientes");
        }else {
            for (Cliente c : this.listaClietnes) {
                salida[i] = c.toString();
                i++;
            }
        }
        return salida;
    }

}
