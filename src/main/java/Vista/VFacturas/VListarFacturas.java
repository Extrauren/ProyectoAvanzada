package Vista.VFacturas;

import Modelo.ModeloFactura;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class VListarFacturas extends JDialog {

    private ModeloFactura modeloFactura;

    public VListarFacturas(){
        this.modeloFactura = new ModeloFactura();
    }

    public void ejecutaListarFacturas(){
        this.setTitle("Listar Facturas");
        this.setVisible(true);
        this.setModal(true);
        this.setSize(500,300);
        this.setLayout(new GridLayout(3,1, 8, 8));

        //elementos graficos

        JButton aceptar = new JButton("Aceptar");
        aceptar.setBackground(Color.yellow);
        this.add(aceptar);

        //zona action listener

        aceptar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                modeloFactura.listarFacturas();
            }
        });



    }
}

