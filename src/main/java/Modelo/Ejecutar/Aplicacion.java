package Modelo.Ejecutar;

import java.io.IOException;
import java.io.Serializable;

public class Aplicacion implements Serializable {

    public static void main(String[] args){
        GuardarDatos data = new GuardarDatos();
        Menu menu = data.lectura();
        menu.main();

        System.out.println("vamos a guardar");
        try {
            AlmacenDatos almacenDatos = new AlmacenDatos(menu.crudCliente, menu.crudLlamada, menu.crudFactura);
            data.escritura(almacenDatos);
        }catch (IOException e){
            System.out.println("error al guardar los datos");
        }
    }
}