package Vista.VLlamadas;

import Modelo.ModeloLlamada;

import javax.swing.*;
import java.awt.*;

public class VistaAltaLlamada extends JDialog {

    private ModeloLlamada modeloLlamada;

    public VistaAltaLlamada(){
        this.modeloLlamada = new ModeloLlamada();
    }

    public void EjecutaAltaLlamada(){
        this.setTitle("Dar de alta una llamada");
        this.setVisible(true);
        this.setModal(true);
        this.setSize(500,300);
        this.setLayout(new GridLayout(5,2, 8, 8));

        //elementos grafcos



    }
}
