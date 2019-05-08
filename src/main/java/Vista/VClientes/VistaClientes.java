package Vista.VClientes;

import Modelo.ModeloCliente;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.Serializable;

public class VistaClientes extends JDialog implements Serializable {


    private VistaInsertarCliente vistaInsertarCliente;
    public VistaClientes() {
        this.vistaInsertarCliente = new VistaInsertarCliente();
    }


    public void ejecutarVentanaClientes() {

        JLabel nada = new JLabel();
        JButton insertar = new JButton("Insertar Cliente");
        insertar.setBackground(Color.lightGray);
        JButton eliminar = new JButton("Eliminar Cliente");
        eliminar.setBackground(Color.lightGray);
        JButton listar = new JButton("Listar Clientes");
        listar.setBackground(Color.lightGray);
        JButton listaruno = new JButton("Mostrar Cliente");
        listaruno.setBackground(Color.lightGray);
        JButton cambiarTarifa = new JButton("Cambiar Tarifa Cliente");
        cambiarTarifa.setBackground(Color.lightGray);
        JButton CEntreFechas = new JButton("Cliente Entre Fechas");
        CEntreFechas.setBackground(Color.lightGray);
        JButton cancelar = new JButton("Atras");
        cancelar.setBackground(Color.cyan);

        this.setLayout(new GridLayout(3,3));
        this.setTitle("Clientes");
        this.setVisible(true);

        this.add(insertar);
        this.add(eliminar);
        this.add(listar);
        this.add(listaruno);
        this.add(cambiarTarifa);
        this.add(CEntreFechas);
        this.add(nada);
        this.add(cancelar);

        this.setModal(true);
        this.setSize(500,300);

        //Zona de actioListeners

        insertar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                vistaInsertarCliente.ejecutaVistaModeloCliente();
            }
        });
    }
}
