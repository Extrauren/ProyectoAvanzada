package Vista;

import javax.swing.*;
import java.awt.*;

public class VentanaGenerica {

    public static void ventanaMostrar(String titulo,String texto){

        JDialog vent = new JDialog();

        vent.setTitle(titulo);
        Container contMostrar= vent.getContentPane();
        contMostrar.setLayout(new BoxLayout(contMostrar, BoxLayout.Y_AXIS));

        JLabel textoM = new JLabel(texto);
        vent.getContentPane().add(textoM);
        vent.setPreferredSize(new Dimension(400,300));
        vent.pack();
        vent.setVisible(true);
    }

    public static void ventanaMostrarLista(String titulo, String[] datos){
        JDialog vent = new JDialog();
        vent.setTitle(titulo);
        Container cont = vent.getContentPane();
        cont.setLayout(new BoxLayout(cont, BoxLayout.Y_AXIS));
        JList lista = new JList(datos);
        vent.getContentPane().add(lista);
        vent.setPreferredSize(new Dimension(400,300));
        vent.pack();
        //vent.setLayout(new FlowLayout());
        vent.setVisible(true);

    }

}
