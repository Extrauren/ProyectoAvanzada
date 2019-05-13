package Vista.VFacturas;

import Modelo.ModeloFactura;

import javax.swing.*;
import java.awt.*;

public class VistaFacturas extends JDialog {

    private ModeloFactura modeloFactura;

    public VistaFacturas(){
        this.modeloFactura = new ModeloFactura();
    }

    public void ejecutarVentanaFacturas() {

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

    }

}
