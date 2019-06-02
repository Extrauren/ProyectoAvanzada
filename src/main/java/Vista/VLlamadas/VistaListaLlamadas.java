package Vista.VLlamadas;

import Controlador.Controlador;
import Modelo.ModeloLlamada;
import Vista.VentanaGenerica;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class VistaListaLlamadas extends JDialog {

    public VistaListaLlamadas(){

    }

    public void ejecutarListarLlamadas(Controlador con) {
        this.setTitle("Listar Llamadas");
        this.setVisible(true);
        this.setModal(true);
        this.setSize(500, 300);
        this.setLayout(new GridLayout(3, 1, 8, 8));

        //elementos grafcos

        JLabel info = new JLabel("Introduce el nif del cliente del que quieras recuperar sus llamadas: ", SwingConstants.CENTER);
        this.add(info);

        JTextField texto = new JTextField();
        this.add(texto);

        JButton aceptar = new JButton("Aceptar");
        aceptar.setBackground(Color.green);
        this.add(aceptar);

        //Zona de acction listeners

        aceptar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                String nif = texto.getText();
                String[] llamadas = con.muestraLlamadaCliente(nif);
                VentanaGenerica.ventanaMostrarLista("Llamada de "+nif, llamadas);
                dispose();
            }
        });

    }



}
