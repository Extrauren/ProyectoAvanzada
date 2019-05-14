package Vista.VClientes;

import Modelo.ModeloCliente;

import javax.swing.*;
import java.awt.*;

public class VistaCambiarTarifa extends JDialog {

    private ModeloCliente modeloCliente;

    public VistaCambiarTarifa() {
        this.modeloCliente = new ModeloCliente();
    }

    public void ejecutaCambiarTarifa() {
        this.setTitle("Cambiar Tarifa");
        this.setVisible(true);
        this.setModal(true);
        this.setSize(500, 300);
        this.setLayout(new GridLayout(2, 3, 6, 6));

        //Comonentes graficos

        JButton anyadirHoras = new JButton("Añadir Tarifa Por Horas");
        anyadirHoras.setBackground(Color.lightGray);
        this.add(anyadirHoras);

        JButton anyadirDias = new JButton("Añadir Tarifa Por Dia");
        anyadirDias.setBackground(Color.lightGray);
        this.add(anyadirDias);

        JButton borrar = new JButton("Borrar Tarifas Extras");
        borrar.setBackground(Color.lightGray);
        this.add(borrar);

        JLabel nada = new JLabel();
        this.add(nada);

        JButton atras = new JButton("Atras");
        atras.setBackground(Color.cyan);
        this.add(atras);
        

    }
}