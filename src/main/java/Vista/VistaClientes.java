package Vista;

import Modelo.CRUD.ModeloCliente;

import javax.swing.*;
import java.awt.*;
import java.io.Serializable;

import static javax.swing.WindowConstants.EXIT_ON_CLOSE;

public class VistaClientes extends Container implements Serializable {

    private ModeloCliente recolectorCliente;


    public VistaClientes(ModeloCliente modeloCliente) {
        this.recolectorCliente = modeloCliente;
    }

    public VistaClientes() {

    }


    public void ejecutarVentanaClientes() {

        JFrame vClientes = new JFrame("Clientes");

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

        vClientes.setLayout(new GridLayout(3,3));
        vClientes.setVisible(true);

        vClientes.add(insertar);
        vClientes.add(eliminar);
        vClientes.add(listar);
        vClientes.add(listaruno);
        vClientes.add(cambiarTarifa);
        vClientes.add(CEntreFechas);
        vClientes.add(nada);
        vClientes.add(cancelar);

        vClientes.setSize(500,300);

    }
}
