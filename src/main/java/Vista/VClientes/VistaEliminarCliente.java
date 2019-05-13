package Vista.VClientes;

import Modelo.ModeloCliente;

import javax.swing.*;
import java.awt.*;

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


    }

}
