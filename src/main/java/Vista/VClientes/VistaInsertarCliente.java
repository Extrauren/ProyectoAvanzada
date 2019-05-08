package Vista.VClientes;

import Modelo.ModeloCliente;

import javax.swing.*;
import java.awt.*;

public class VistaInsertarCliente extends JDialog {

    private ModeloCliente modeloCliente;

    VistaInsertarCliente(){
        this.modeloCliente = new ModeloCliente();
    }

    public void ejecutaVistaModeloCliente(){
        this.setTitle("Anyadir Cliente");
        this.setVisible(true);
        this.setModal(true);
        this.setSize(500,300);
        this.setLayout(new GridLayout(5,2));
        //Elementos graficos

        JLabel nombre = new JLabel("Introduce el nombre:");
        this.add(nombre);

        JTextArea introducirNombre = new JTextArea();
        this.add(introducirNombre);
    }

}
