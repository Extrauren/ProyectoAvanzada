package Vista.VClientes;

import Controlador.Controlador;
import Vista.VClientes.CambiarTarifa.VistaEliminaTarifas;
import Vista.VClientes.CambiarTarifa.VistaTarifaDias;
import Vista.VClientes.CambiarTarifa.VistaTarifaHoras;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class VistaCambiarTarifa extends JDialog {


    public VistaCambiarTarifa() {
    }

    public void ejecutaCambiarTarifa(Controlador con) {
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

        //zona action listeners

        anyadirHoras.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                new VistaTarifaHoras().ejecutaTarifaHoras(con);
            }
        });

        anyadirDias.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                new VistaTarifaDias().ejecutaVistaTarifaDias(con);
            }
        });

        borrar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                new VistaEliminaTarifas().ejecutaEliminarTarifasExtras(con);
            }
        });

        atras.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                dispose();
            }
        });
    }
}