package Vista.VClientes;

import Controlador.Controlador;

import javax.swing.*;
import java.awt.*;

public class VistaListarClientes extends JDialog {


    public VistaListarClientes(){
    }

    public void ejecutaListarClientes(Controlador con){
        this.setTitle("Listar Cliente");
        this.setVisible(true);
        this.setModal(true);
        this.setSize(500,300);
        this.setLayout(new GridLayout(3,1, 0, 6));

        //Elementos gráficos

        JLabel intro = new JLabel("Listado de todos los clientes de la base de datos: ", SwingConstants.CENTER);
        this.add(intro);

        JList otro = new JList(con.listadoClientes());
        this.add(otro);
        //JLabel clientes = new JLabel();
        //this.add(clientes);


        //JButton mostrar = new JButton("Mostrar");
        //mostrar.setBackground(Color.cyan);
        //this.add(mostrar);
        //llamar al controlador


        //zona action listeners

        /*mostrar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                modeloCliente.listarClientes();
            }
        });*/
    }


}
