package Vista.VClientes;

import Modelo.Excepciones.ClienteNoExisteException;
import Modelo.ModeloCliente;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class VistaEliminarCliente extends JDialog {

    private ModeloCliente modeloCliente;

    VistaEliminarCliente(){
        this.modeloCliente = new ModeloCliente();
    }

    public void ejecutaEliminarCliente(){

        this.setTitle("Eliminar Cliente");
        this.setVisible(true);
        this.setModal(true);
        this.setSize(500,300);
        this.setLayout(new GridLayout(3,1, 8, 8));

        //Elementos graficos

        JLabel nif = new JLabel("NIF: ");
        this.add(nif);

        JTextArea introduceNIF = new JTextArea();
        this.add(introduceNIF);

        JButton aceptar = new JButton("Aceptar");
        aceptar.setBackground(Color.cyan);
        this.add(aceptar);

        //Zona acction listener

        aceptar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                try {
                    modeloCliente.borrarCliente(nif.getText());
                } catch (ClienteNoExisteException e) {
                    e.printStackTrace();
                }
            }
        });
    }

}
