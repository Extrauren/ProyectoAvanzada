package Vista.VLlamadas;

import Modelo.ModeloLlamada;

import javax.swing.*;
import java.awt.*;

public class VistaLlamadas extends JDialog {

    private ModeloLlamada modeloLlamada;

    public VistaLlamadas(){
        this.modeloLlamada = new ModeloLlamada();
    }

    public void ejecutarVentanaLlamadas() {

        JButton alta = new JButton("Alta Llamada");
        alta.setBackground(Color.lightGray);
        JButton listar = new JButton("Listar Llamadas");
        listar.setBackground(Color.lightGray);
        JButton cancelar = new JButton("Atras");
        cancelar.setBackground(Color.green);

        this.setLayout(new GridLayout(3,1));
        this.setTitle("Llamadas");
        this.setVisible(true);

        this.add(alta);
        this.add(listar);
        this.add(cancelar);

        this.setModal(true);
        this.setSize(500,300);

    }

}
