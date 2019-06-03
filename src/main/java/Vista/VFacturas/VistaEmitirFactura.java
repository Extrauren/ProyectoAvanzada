package Vista.VFacturas;

import Controlador.Controlador;
import Controlador.Excepciones.ClienteNoExisteException;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class VistaEmitirFactura extends JDialog {



    public VistaEmitirFactura(){

    }

    public void ejecutarEmitirFactura(Controlador con){

        this.setTitle("Emitir Factiras");
        this.setVisible(true);
        this.setModal(true);
        this.setSize(500,300);
        this.setLayout(new GridLayout(3,1, 6, 6));

        //Elementos Graficos

        JLabel info = new JLabel("Introduce el NIF de un cliente para emitir una factura con sus llamadas: ",  SwingConstants.CENTER);
        this.add(info);

        JTextField texto = new JTextField();
        this.add(texto);

        JButton aceptar = new JButton("Aceptar");
        aceptar.setBackground(Color.yellow);
        this.add(aceptar);

        //Zona action listener

        aceptar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                try {
                    con.emitirFactura(texto.getText());
                } catch (ClienteNoExisteException e) {
                    e.printStackTrace();
                }
            }
        });
    }
}
