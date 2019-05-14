package Vista.VFacturas;

import Modelo.ModeloFactura;

import javax.swing.*;
import java.awt.*;

public class VListarFacturas extends JDialog {

    private ModeloFactura modeloFactura;

    public VListarFacturas(){
        this.modeloFactura = new ModeloFactura();
    }

    public void ejecutaListarFacturas(){
        this.setTitle("Listar Facturas");
        this.setVisible(true);
        this.setModal(true);
        this.setSize(500,300);
        this.setLayout(new GridLayout(3,1, 8, 8));

        //elementos graficos

        JLabel info = new JLabel("Introduce el nif del cliente del que quieras recuperar sus facuturas: ", SwingConstants.CENTER);
        this.add(info);

        JTextArea tecto = new JTextArea();
        this.add(tecto);

        JButton aceptar = new JButton("Aceptar");
        aceptar.setBackground(Color.yellow);
        this.add(aceptar);



    }
}

