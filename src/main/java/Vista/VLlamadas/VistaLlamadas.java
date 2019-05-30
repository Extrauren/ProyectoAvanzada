package Vista.VLlamadas;

import Modelo.ModeloLlamada;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class VistaLlamadas extends JDialog {

    private VistaAltaLlamada vistaAltaLlamada;
    private VistaListaLlamadas vistaListaLlamadas;

    public VistaLlamadas(){
        this.vistaAltaLlamada = new VistaAltaLlamada();
        this.vistaListaLlamadas = new VistaListaLlamadas();
    }

    public void ejecutarVentanaLlamadas(ModeloLlamada modeloLlamada) {

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

        //Zona action listeners

        alta.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                vistaAltaLlamada.ejecutaAltaLlamada(modeloLlamada);
            }
        });

        listar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                vistaListaLlamadas.ejecutarListarLlamadas(modeloLlamada);
            }
        });

    }

}
