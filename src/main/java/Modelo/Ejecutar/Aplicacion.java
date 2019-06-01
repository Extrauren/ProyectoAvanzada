package Modelo.Ejecutar;

import Vista.VentanaPrincipal;
import java.io.Serializable;

public class Aplicacion implements Serializable {

    public static void main(String[] args){
        GuardarDatos data = new GuardarDatos();

        //En caso de querer ejecutar la version de consola

        /*Menu menu = data.lectura();
        menu.main();*/

        //En caso de ejecutar la version gráfica
        VentanaPrincipal vp = new VentanaPrincipal(data.lectura());
        vp.ensenyaVentanaPrincipal();
    }
}