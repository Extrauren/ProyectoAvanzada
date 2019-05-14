package Vista.VClientes;

import Modelo.ModeloCliente;

import javax.swing.*;
import java.awt.*;

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
        this.setLayout(new GridLayout(2,1, 0, 6));

        //Elementos gráficos

        JLabel intro = new JLabel("Listado de todos los clientes de la base de datos: ", SwingConstants.CENTER);
        this.add(intro);

        JLabel clientes = new JLabel();
        this.add(clientes);

    }

}
