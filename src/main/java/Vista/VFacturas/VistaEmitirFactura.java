package Vista.VFacturas;

import Modelo.ModeloFactura;

import javax.swing.*;
import java.awt.*;

public class VistaEmitirFactura extends JDialog {

    private ModeloFactura modeloFactura;

    public VistaEmitirFactura(){
        this.modeloFactura = new ModeloFactura();
    }

    public void ejecutarEmitirFactura(){

        this.setTitle("Emitir Factiras");
        this.setVisible(true);
        this.setModal(true);
        this.setSize(500,300);
        this.setLayout(new GridLayout(3,1, 6, 6));

        //Elementos Graficos

        JLabel info = new JLabel("Introduce el NIF de un cliente para emitir una factura con sus llamadas: ",  SwingConstants.CENTER);
        this.add(info);

        JTextArea texto = new JTextArea();
        this.add(texto);

        JButton aceptar = new JButton("Aceptar");
        aceptar.setBackground(Color.yellow);
        this.add(aceptar);
    }
}
