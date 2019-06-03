package Vista.VClientes;


import Controlador.Controlador;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

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

        JFrame vClientes = new JFrame();

        JLabel nombre = new JLabel("Nombre: ", SwingConstants.CENTER);
        this.add(nombre);

        JTextField introducirNombre = new JTextField(10);
        this.add(introducirNombre);

        JLabel nif = new JLabel("NIF: ", SwingConstants.CENTER);
        this.add(nif);

        JTextField introducirNIF = new JTextField(10);
        this.add(introducirNIF);

        JLabel dir = new JLabel("Direccion : ", SwingConstants.CENTER);
        this.add(dir);

        JTextField introducirDir = new JTextField(10);
        this.add(introducirDir);

        JLabel correo = new JLabel("Correo Electronico : ", SwingConstants.CENTER);
        this.add(correo);

        JTextField introducirCorreo = new JTextField(10);
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

                if(nombre.getText().equals("") || introducirCorreo.getText().equals("") ||  introducirDir.getText().equals("")) {
                    JOptionPane.showMessageDialog(vClientes, "Los campos son obligatorios");
                    return;
                }

                if(nif.getText().equals("") || nif.getText().length() != 9) {
                    JOptionPane.showMessageDialog(vClientes, "El dni no cumple con el formato 8N 1L :NNNNNNNNL");
                    return;
                }

                if(radioButton.isSelected() && !introducirNombre.getText().equals("") && !introducirNIF.getText().equals("") && !introducirDir.getText().equals("")
                        && !introducirCorreo.getText().equals("") && !apellido.getText().equals("") ){
                    control.insertaClientePar(introducirNombre.getText(), introducirNIF.getText(), introducirDir.getText(), introducirCorreo.getText(), apellido.getText());

                }else if(!radioButton.isSelected() && !introducirNombre.getText().equals("")
                        && !introducirNIF.getText().equals("") && !introducirDir.getText().equals("") && !introducirCorreo.getText().equals("")){
                    control.insertarClienteEm(introducirNombre.getText(), introducirNIF.getText(), introducirDir.getText(), introducirCorreo.getText());
                }
                dispose();

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
