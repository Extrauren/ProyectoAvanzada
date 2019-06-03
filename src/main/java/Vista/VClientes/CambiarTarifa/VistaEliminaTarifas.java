package Vista.VClientes.CambiarTarifa;

import Controlador.Controlador;

import javax.swing.*;
import java.awt.*;

public class VistaEliminaTarifas extends JDialog {

    public void ejecutaEliminarTarifasExtras(Controlador con) {

        this.setTitle("Eliminar Cliente");
        this.setVisible(true);
        this.setModal(true);
        this.setSize(500, 300);
        this.setLayout(new GridLayout(3, 1, 8, 8));
    }
}
