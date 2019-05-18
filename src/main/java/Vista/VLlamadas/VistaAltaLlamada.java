package Vista.VLlamadas;

import Modelo.ModeloLlamada;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class VistaAltaLlamada extends JDialog {

    private ModeloLlamada modeloLlamada;

    public VistaAltaLlamada(){
        this.modeloLlamada = new ModeloLlamada();
    }

    public void ejecutaAltaLlamada(){
        this.setTitle("Dar de alta una llamada");
        this.setVisible(true);
        this.setModal(true);
        this.setSize(500,300);
        this.setLayout(new GridLayout(5,2, 8, 8));

        //elementos grafcos

        JLabel nif = new JLabel("Introdice el NIF: ", SwingConstants.CENTER);
        this.add(nif);
        JTextField texNif = new JTextField();
        this.add(texNif);

        JLabel telefono = new JLabel("Introduce el Telefono: ",SwingConstants.CENTER);
        this.add(telefono);
        JTextField textTelefono = new JTextField();
        this.add(textTelefono);

        JLabel fechaAlta = new JLabel("Introduce la fecha: ", SwingConstants.CENTER);
        this.add(fechaAlta);
        JTextField textFecha = new JTextField("(dd/mm/yyyy)");
        this.add(textFecha);

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
                modeloLlamada.altaLLamada(texNif.getText(), Integer.parseInt(textTelefono.getText()), Float.parseFloat(textDuracion.getText()));
            }
        });

    }
}
