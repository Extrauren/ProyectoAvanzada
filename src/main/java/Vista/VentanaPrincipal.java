package Vista;

import Modelo.CRUD.CRUDCliente;
import Modelo.CRUD.CRUDFactura;
import Modelo.CRUD.CRUDLlamada;

import javax.swing.*;
import java.awt.*;
import java.io.Serializable;

public class VentanaPrincipal implements Serializable {

    private CRUDCliente crudCliente;
    private CRUDFactura crudFactura;
    private CRUDLlamada crudLlamada;

    public VentanaPrincipal(){

        this.crudCliente = new CRUDCliente();
        this.crudFactura = new CRUDFactura();
        this.crudLlamada = new CRUDLlamada();

    }

    public void ensenyaVentanaPrincipal(){
        //Definimos la ventana y los 2 contenedores el de los botones y el texto
        JFrame ventana = new JFrame("Telefonia");
        JPanel panelBotones = new JPanel();
        JPanel panelTexto = new JPanel();

        //Creamos el titulo y le ponemos una fuente y un tamaño nuevo
        JLabel titulo = new JLabel("Telefonia");
        titulo.setFont(new Font("Serif", Font.PLAIN, 30));

        //Creamos los botones para acceder a las respectivas vistas
        JButton clientes= new JButton("Clientes");
        JButton facturas = new JButton("Facturas");
        JButton llamadas = new JButton("Llamadas");

        //Añadimos al contenedor de texto el titulo
        panelTexto.add(titulo);

        //Añadimos al contenedor de los botones los botones
        panelBotones.add(clientes,BorderLayout.WEST);
        panelBotones.add(facturas,BorderLayout.CENTER);
        panelBotones.add(llamadas,BorderLayout.EAST);
        // Añadimos los paneles a la ventana */
        ventana.add(panelBotones);
        ventana.add(panelTexto , BorderLayout.NORTH);

        //Tamaño de la ventana y que se cierre y que se muestre
        ventana.setSize(500,150);
        ventana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        ventana.setResizable(false);
        ventana.setVisible(true);


    }

}
