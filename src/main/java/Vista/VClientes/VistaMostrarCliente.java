package Vista.VClientes;

import Modelo.Excepciones.ClienteNoExisteException;
import Modelo.ModeloCliente;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class VistaMostrarCliente extends JDialog {

    private ModeloCliente modeloCliente;

    public VistaMostrarCliente(){
        this.modeloCliente = new ModeloCliente();
    }

    public void ejecutaMostrarCLiente(){
        this.setTitle("Listar Cliente");
        this.setVisible(true);
        this.setModal(true);
        this.setSize(500,300);
        this.setLayout(new GridLayout(3,1, 0, 6));

        //Elementos Graficos

        JLabel intro = new JLabel("Introduce el NIF de un cliente para mostrar sus datos: ", SwingConstants.CENTER);
        this.add(intro);

        JLabel cliente = new JLabel();
        this.add(cliente);

        JButton aceptar = new JButton("Aceptar");
        this.add(aceptar);
        aceptar.setBackground(Color.cyan);

        //zona action listeners

        aceptar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                try {
                    modeloCliente.getCliente(intro.getText());
                } catch (ClienteNoExisteException e) {
                    e.printStackTrace();
                }
            }
        });

    }
}
