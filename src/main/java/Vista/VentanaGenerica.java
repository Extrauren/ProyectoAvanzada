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

        vent.pack();
        vent.setVisible(true);
    }

}
