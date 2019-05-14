package Vista.VFacturas;

import Modelo.ModeloFactura;

import javax.swing.*;
import java.awt.*;

public class VRecuperarFactura extends JDialog {

    private ModeloFactura modeloFactura;

    public VRecuperarFactura(){
        this.modeloFactura = new ModeloFactura();
    }

    public void ejecutarRecuperarFactura(){

        this.setTitle("Recuperar Factura");
        this.setVisible(true);
        this.setModal(true);
        this.setSize(500,300);
        this.setLayout(new GridLayout(3,1, 5, 6));

        //elementos graficos

        JLabel info = new JLabel("Introduce el codigo de la factura para recuper sus datos: ", SwingConstants.CENTER);
        this.add(info);

        JTextArea texto = new JTextArea();
        this.add(texto);

        JButton aceptar = new JButton("Aceptar");
        aceptar.setBackground(Color.yellow);
        this.add(aceptar);
    }
}
