package Controlador.Ejecutar;

import Controlador.Controlador;

import java.io.*;

public class GuardarDatos implements Serializable{
    public static void escritura(Controlador control) throws IOException {
        try {
            File fich = new File("Datos.obj");
            if (fich.createNewFile())
                System.out.println("no existia, se ha creado el fichero");

            FileOutputStream fout = new FileOutputStream(fich);
            ObjectOutputStream oout = new ObjectOutputStream(fout);

            oout.writeObject(control);
            fout.close();
            oout.close();


        }catch (FileNotFoundException e) {
            System.out.println("error no fichero");
        }catch (IOException e){
            System.out.println("error no escritura");
        }
    }

    public Controlador lectura(){
        ObjectInputStream oois = null;
        Controlador control= new Controlador();

        try{

            File fich = new File("Datos.obj");
            FileInputStream ffis = new FileInputStream(fich);
            oois = new ObjectInputStream(ffis);


            control = (Controlador) oois.readObject();
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
        return control;
    }
}
