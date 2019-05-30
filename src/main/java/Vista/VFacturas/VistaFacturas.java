package Vista.VFacturas;

import Modelo.ModeloFactura;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class VistaFacturas extends JDialog {

    private VistaEmitirFactura vistaEmitirFactura;
    private VListarFacturas vListarFacturas;
    private VRecuperarFactura vRecuperarFactura;

    public VistaFacturas(){
        this.vistaEmitirFactura = new VistaEmitirFactura();
        this.vListarFacturas = new VListarFacturas();
        this.vRecuperarFactura = new VRecuperarFactura();
    }

    public void ejecutarVentanaFacturas(ModeloFactura modeloFactura) {

        JLabel nada = new JLabel();
        JButton emitir = new JButton("Emitir Una Factura");
        emitir.setBackground(Color.lightGray);
        JButton listar = new JButton("Listar Facturas");
        listar.setBackground(Color.lightGray);
        JButton mostrarFactura = new JButton("Mostrar Una Factura");
        mostrarFactura.setBackground(Color.lightGray);
        JButton cancelar = new JButton("Atras");
        cancelar.setBackground(Color.yellow);

        this.setLayout(new GridLayout(2,3, 6 ,6));
        this.setTitle("Facturas");
        this.setVisible(true);

        this.add(emitir);
        this.add(listar);
        this.add(mostrarFactura);
        this.add(nada);
        this.add(cancelar);

        this.setModal(true);
        this.setSize(500,300);

        //Actions listeners

        emitir.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                vistaEmitirFactura.ejecutarEmitirFactura(modeloFactura);
            }
        });

        listar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                vListarFacturas.ejecutaListarFacturas(modeloFactura);
            }
        });

        mostrarFactura.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                vRecuperarFactura.ejecutarRecuperarFactura(modeloFactura);
            }
        });
    }

}
