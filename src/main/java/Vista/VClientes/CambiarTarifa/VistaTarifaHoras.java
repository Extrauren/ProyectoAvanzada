package Vista.VClientes.CambiarTarifa;

import Controlador.Controlador;

import javax.swing.*;
import java.awt.*;

public class VistaTarifaHoras extends JDialog {

    public void ejecutaTarifaHoras(Controlador con) {

        this.setTitle("Tarifa por horas");
        this.setVisible(true);
        this.setModal(true);
        this.setSize(500, 300);
        this.setLayout(new GridLayout(3, 1, 8, 8));
    }
}