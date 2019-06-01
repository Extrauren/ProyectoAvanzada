package Vista.VClientes;


import Controlador.Cliente;
import Controlador.Controlador;
import Controlador.Tarifas.Tarifa;
import Modelo.Factory.FabricaCliente;
import Modelo.Factory.FabricaTarifa;
import Modelo.ModeloCliente;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Calendar;

public class VistaInsertarCliente extends JDialog {

    private Controlador control;

    VistaInsertarCliente(){

    }

    public void ejecutaInsertarCliente(Controlador control){
        this.control = control;

        this.setTitle("Anyadir Cliente");
        this.setVisible(true);
        this.setModal(true);
        this.setSize(500,300);
        this.setLayout(new GridLayout(6,2, 0, 6));

        //Elementos graficos

        JLabel nombre = new JLabel("Nombre: ", SwingConstants.CENTER);
        this.add(nombre);

        JTextField introducirNombre = new JTextField();
        this.add(introducirNombre);

        JLabel nif = new JLabel("NIF: ", SwingConstants.CENTER);
        this.add(nif);

        JTextField introducirNIF = new JTextField();
        this.add(introducirNIF);

        JLabel dir = new JLabel("Direccion : ", SwingConstants.CENTER);
        this.add(dir);

        JTextField introducirDir = new JTextField();
        this.add(introducirDir);

        JLabel correo = new JLabel("Correo Electronico : ", SwingConstants.CENTER);
        this.add(correo);

        JTextField introducirCorreo = new JTextField();
        this.add(introducirCorreo);


        JRadioButton radioButton = new JRadioButton("¿Particular?");
        this.add(radioButton);

        JTextField apellido = new JTextField("Apellido");
        apellido.setEnabled(false);
        this.add(apellido);

        JButton aceptar = new JButton("Aceptar");
        aceptar.setBackground(Color.cyan);
        this.add(aceptar);

        //Zona acctionListeners

        aceptar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {

                if(radioButton.isSelected()){
                    control.insertaClientePar(introducirNombre.getText(), introducirNIF.getText(), introducirDir.getText(), introducirCorreo.getText(), apellido.getText());

                }else{
                    control.insertarClienteEm(introducirNombre.getText(), introducirNIF.getText(), introducirDir.getText(), introducirCorreo.getText());
                }


            }
        });
        radioButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                if(radioButton.isSelected())
                    apellido.setEnabled(true);
                else
                    apellido.setEnabled(false);
            }
        });

    }

}
