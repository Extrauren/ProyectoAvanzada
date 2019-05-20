package Vista.VClientes;

import Controlador.Cliente;
import Modelo.ModeloCliente;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class VistaListarClientes extends JDialog {

    private ModeloCliente modeloCliente;

    public VistaListarClientes(){
        this.modeloCliente = new ModeloCliente();
    }

    public void ejecutaListarClientes(){
        this.setTitle("Listar Cliente");
        this.setVisible(true);
        this.setModal(true);
        this.setSize(500,300);
        this.setLayout(new GridLayout(3,1, 0, 6));

        //Elementos gráficos

        JLabel intro = new JLabel("Listado de todos los clientes de la base de datos: ", SwingConstants.CENTER);
        this.add(intro);

        JLabel clientes = new JLabel();
        this.add(clientes);


        JButton mostrar = new JButton("Mostrar");
        mostrar.setBackground(Color.cyan);
        this.add(mostrar);

        //zona action listeners

        mostrar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                modeloCliente.listarClientes();
            }
        });
    }


}
