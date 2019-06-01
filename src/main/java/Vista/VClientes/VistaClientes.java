package Vista.VClientes;

import Controlador.Controlador;
import Modelo.ModeloCliente;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.Serializable;

public class VistaClientes extends JDialog implements Serializable {

    private Controlador control;
    private VistaInsertarCliente vistaInsertarCliente;
    private VistaEliminarCliente vistaEliminarCliente;
    private VistaListarClientes vistaListarClientes;
    private VistaMostrarCliente vistaMostrarCliente;
    private VistaCambiarTarifa vistaCambiarTarifa;

    public VistaClientes() {
        this.vistaInsertarCliente = new VistaInsertarCliente();
        this.vistaEliminarCliente = new VistaEliminarCliente();
        this.vistaListarClientes = new VistaListarClientes();
        this.vistaMostrarCliente = new VistaMostrarCliente();
        this.vistaCambiarTarifa = new VistaCambiarTarifa();
    }


    public void ejecutarVentanaClientes(Controlador control) {

        this.control = control;

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
        JButton cancelar = new JButton("Atras");
        cancelar.setBackground(Color.cyan);

        this.setLayout(new GridLayout(2,3, 6, 6));
        this.setTitle("Clientes");
        this.setVisible(true);

        this.add(insertar);
        this.add(eliminar);
        this.add(listar);
        this.add(listaruno);
        this.add(cambiarTarifa);
        this.add(cancelar);

        this.setModal(true);
        this.setSize(500,300);

        //Zona de actioListeners

        insertar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                vistaInsertarCliente = new VistaInsertarCliente();
                vistaInsertarCliente.ejecutaInsertarCliente(control);
            }
        });

        eliminar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                vistaEliminarCliente.ejecutaEliminarCliente(control);
            }
        });

        listar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                vistaListarClientes = new VistaListarClientes();
                vistaListarClientes.ejecutaListarClientes(control);
            }
        });

        listaruno.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                vistaMostrarCliente.ejecutaMostrarCLiente(control);
            }
        });

        cambiarTarifa.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                vistaCambiarTarifa.ejecutaCambiarTarifa(control);
            }
        });
    }
}
