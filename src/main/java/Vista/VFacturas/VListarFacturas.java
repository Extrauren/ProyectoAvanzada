package Vista.VFacturas;

import Controlador.Controlador;

import javax.swing.*;
import java.awt.*;

public class VListarFacturas extends JDialog {



    public VListarFacturas(){
    }

    public void ejecutaListarFacturas(Controlador con){
        this.setTitle("Listar Facturas");
        this.setVisible(true);
        this.setModal(true);
        this.setSize(500,300);
        this.setLayout(new GridLayout(3,1, 8, 8));

        //elementos graficos

        JList otro = new JList(con.listarFacturas());
        this.add(otro);


    }
}

