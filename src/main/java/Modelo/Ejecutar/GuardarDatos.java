package Modelo.Ejecutar;

import java.io.*;

public class GuardarDatos implements Serializable{
    public void escritura(AlmacenDatos menu) throws IOException {
        try {
            FileOutputStream fout = new FileOutputStream("Datos.obj");
            ObjectOutputStream oout = new ObjectOutputStream(fout);

            oout.writeObject(menu);

            oout.close();
        }catch (FileNotFoundException e) {
            System.out.println("Error, no se ha creado el fichero");
        }catch (IOException e){
            System.out.println("Error, no se ha escrito");
        }
    }

    public Menu lectura(){
        ObjectInputStream oois = null;
        Menu menu = new Menu();

        try{

            File fich = new File("Datos.obj");
            FileInputStream ffis = new FileInputStream(fich);
            oois = new ObjectInputStream(ffis);


            menu = (Menu) oois.readObject();
            System.out.println("Fichero leido de forma correcta.");

        } catch(FileNotFoundException e){
            System.out.println("file exception");
        } catch(IOException e){
            System.out.println("Io exception");
            e.printStackTrace();
        } catch(ClassNotFoundException e){
            System.out.println("Class exception");
        }

        //oois.close();
        return menu;
    }
}
