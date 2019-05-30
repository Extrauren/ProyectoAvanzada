package Vista.VFacturas;

import Modelo.Excepciones.FacturaNoExisteException;
import Modelo.ModeloFactura;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class VRecuperarFactura extends JDialog {



    public VRecuperarFactura(){
    }

    public void ejecutarRecuperarFactura(ModeloFactura modeloFactura){

        this.setTitle("Recuperar Factura");
        this.setVisible(true);
        this.setModal(true);
        this.setSize(500,300);
        this.setLayout(new GridLayout(3,1, 5, 6));

        //elementos graficos

        JLabel info = new JLabel("Introduce el codigo de la factura para recuper sus datos: ", SwingConstants.CENTER);
        this.add(info);

        JTextField texto = new JTextField();
        this.add(texto);

        JButton aceptar = new JButton("Aceptar");
        aceptar.setBackground(Color.yellow);
        this.add(aceptar);

        //zona action listener

        aceptar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                try {
                    modeloFactura.getFacturaCodigo(texto.getText());
                } catch (FacturaNoExisteException e) {
                    e.printStackTrace();
                }
            }
        });
    }
}