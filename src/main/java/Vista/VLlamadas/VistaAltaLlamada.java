package Vista.VLlamadas;

import Controlador.Controlador;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class VistaAltaLlamada extends JDialog {

    public VistaAltaLlamada(){
    }

    public void ejecutaAltaLlamada(Controlador con){
        this.setTitle("Dar de alta una llamada");
        this.setVisible(true);
        this.setModal(true);
        this.setSize(500,300);
        this.setLayout(new GridLayout(5,2, 8, 8));

        //elementos grafcos

        JPanel vLlamada = new JPanel();

        JLabel nif = new JLabel("Introdice el NIF: ", SwingConstants.CENTER);
        this.add(nif);
        JTextField texNif = new JTextField();
        this.add(texNif);

        JLabel telefono = new JLabel("Introduce el Telefono: ",SwingConstants.CENTER);
        this.add(telefono);
        JTextField textTelefono = new JTextField();
        this.add(textTelefono);

        JLabel duracion = new JLabel("Introduce la duracion: ", SwingConstants.CENTER);
        this.add(duracion);
        JTextField textDuracion = new JTextField();
        this.add(textDuracion);

        JLabel info = new JLabel();
        this.add(info);

        JButton aceptar = new JButton("Aceptar");
        aceptar.setBackground(Color.green);
        this.add(aceptar);

        //Zona de action listener

        aceptar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {

                if(nif.getText().equals("") || nif.getText().length() != 9) {
                    JOptionPane.showMessageDialog(vLlamada, "El dni no cumple con el formato 8N 1L :NNNNNNNNL");
                    return;
                }

                if(telefono.getText().equals("") || telefono.getText().length() != 9) {
                    JOptionPane.showMessageDialog(vLlamada, "El telefono tiene que tener 9 digitos");
                    return;
                }

                con.altaLlamada(texNif.getText(), Integer.parseInt(textTelefono.getText()), Float.parseFloat(textDuracion.getText()));
                dispose();
            }
        });

    }
}
