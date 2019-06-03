package Vista.VClientes.CambiarTarifa;

import Controlador.Controlador;
import Controlador.Factory.FabricaTarifa;
import Modelo.Cliente;
import Modelo.Tarifas.Tarifa;
import Modelo.Tarifas.TarifaDias;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class VistaTarifaDias extends JDialog {

    private FabricaTarifa fabricaTarifa;

    public VistaTarifaDias() {
    }

    public void ejecutaVistaTarifaDias(Controlador con) {

        this.setTitle("Tarifa por dias");
        this.setVisible(true);
        this.setModal(true);
        this.setSize(500, 300);
        this.setLayout(new GridLayout(5, 1, 8, 8));

        JLabel introNif = new JLabel("Introduce el NIF del cliente al que quieras anñadir una tarifa por dias: ", SwingConstants.CENTER);
        this.add(introNif);

        JTextField nif = new JTextField();
        this.add(nif);

        JLabel introDia = new JLabel("Introduce el dia de la seman: (1 lunes ... 7 domingo)", SwingConstants.CENTER);
        this.add(introDia);

        JTextField dia = new JTextField();
        this.add(dia);

        JButton aceptar = new JButton("Aceptar");
        this.add(aceptar);
        aceptar.setBackground(Color.cyan);


        //zona acction listener

        aceptar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                con.anyadirTarifaDia(nif.getText(), Integer.parseInt(dia.getText()));
            }
        });
    }
}