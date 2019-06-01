package Vista;

import Controlador.Controlador;
import Modelo.Ejecutar.GuardarDatos;
import Modelo.ModeloCliente;
import Modelo.ModeloFactura;
import Modelo.ModeloLlamada;
import Vista.VClientes.VistaClientes;
import Vista.VFacturas.VistaFacturas;
import Vista.VLlamadas.VistaLlamadas;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.IOException;
import java.io.Serializable;

public class VentanaPrincipal implements Serializable {

    private Controlador control;
    //private VistaClientes vistaClientes;
    //private VistaFacturas vistaFacturas;
    //private VistaLlamadas vistaLlamadas;

    public VentanaPrincipal(Controlador con){
        this.control = con;
        //this.vistaClientes = new VistaClientes();
        //this.vistaFacturas = new VistaFacturas();
        //this.vistaLlamadas = new VistaLlamadas();
    }

    public void cosa(){
        try {
            GuardarDatos.escritura(control);
        } catch (IOException e) {
            e.printStackTrace();
        }
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
        clientes.setBackground(Color.cyan);
        facturas.setBackground(Color.yellow);
        llamadas.setBackground(Color.green);

        //Añadimos al contenedor de texto el titulo

        panelTexto.add(titulo);

        //Añadimos al contenedor de los botones los botones

        panelBotones.add(clientes);
        panelBotones.add(facturas);
        panelBotones.add(llamadas);

        // Añadimos los paneles a la ventana

        ventana.add(panelBotones);
        ventana.add(panelTexto , BorderLayout.NORTH);

        //Tamaño de la ventana y que se cierre y que se muestre

        ventana.setSize(500,150);
        ventana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        ventana.setResizable(false);
        ventana.setVisible(true);

        //Zona de los ActionListeners

        ventana.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing (WindowEvent windowEvent) {
                System.out.println("Cerrando");
                cosa();
                super.windowClosing(windowEvent);
            }
        });

        clientes.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new VistaClientes().ejecutarVentanaClientes(control);
            }
        });

        facturas.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                new VistaFacturas().ejecutarVentanaFacturas(control);
            }
        });

        llamadas.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                new VistaLlamadas().ejecutarVentanaLlamadas(control);
            }
        });
    }

}
