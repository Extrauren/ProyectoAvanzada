package Modelo.Ejecutar;

import Vista.VentanaPrincipal;

import java.io.*;

public class GuardarDatos implements Serializable{
    public static void escritura(VentanaPrincipal ventana) throws IOException {
        try {
            File fich = new File("Datos.obj");
            if (fich.createNewFile())
                System.out.println("no existia, se ha creado el fichero");

            FileOutputStream fout = new FileOutputStream(fich);
            ObjectOutputStream oout = new ObjectOutputStream(fout);

            oout.writeObject(ventana);



        }catch (FileNotFoundException e) {
            System.out.println("error no fichero");
        }catch (IOException e){
            System.out.println("error no escritura");
        }
    }

    public static VentanaPrincipal lectura(){
        ObjectInputStream oois = null;
        VentanaPrincipal ventana = new VentanaPrincipal();

        try{

            File fich = new File("Datos.obj");
            FileInputStream ffis = new FileInputStream(fich);
            oois = new ObjectInputStream(ffis);


            ventana = (VentanaPrincipal) oois.readObject();
            System.out.println("Fichero leido de forma correcta.");

        } catch(FileNotFoundException e){
            System.out.println("No existe el fichero");
        } catch(IOException e){
            System.out.println("Io exception");
            e.printStackTrace();
        } catch(ClassNotFoundException e){
            System.out.println("Class exception");
        }

        //oois.close();
        return ventana;
    }
}
