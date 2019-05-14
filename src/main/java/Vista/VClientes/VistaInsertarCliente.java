package Vista.VClientes;

import Modelo.ModeloCliente;

import javax.swing.*;
import java.awt.*;

public class VistaInsertarCliente extends JDialog {

    private ModeloCliente modeloCliente;

    VistaInsertarCliente(){
        this.modeloCliente = new ModeloCliente();
    }

    public void ejecutaInsertarCliente(){
        this.setTitle("Anyadir Cliente");
        this.setVisible(true);
        this.setModal(true);
        this.setSize(500,300);
        this.setLayout(new GridLayout(5,2, 0, 6));

        //Elementos graficos

        JLabel nombre = new JLabel("Nombre: ", SwingConstants.CENTER);
        this.add(nombre);

        JTextArea introducirNombre = new JTextArea();
        this.add(introducirNombre);

        JLabel nif = new JLabel("NIF: ", SwingConstants.CENTER);
        this.add(nif);

        JTextArea introducirNIF = new JTextArea();
        this.add(introducirNIF);

        JLabel dir = new JLabel("Direccion : ", SwingConstants.CENTER);
        this.add(dir);

        JTextArea introducirDir = new JTextArea();
        this.add(introducirDir);

        JLabel correo = new JLabel("Correo Electronico : ", SwingConstants.CENTER);
        this.add(correo);

        JTextArea introducirCorreo = new JTextArea();
        this.add(introducirCorreo);

        JButton aceptar = new JButton("Aceptar");
        aceptar.setBackground(Color.cyan);
        this.add(aceptar);

    }

}
