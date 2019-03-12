package Excepciones;

public class FacturaNoExisteException extends Exception{

    public FacturaNoExisteException(){
        super("La factura no existe");
    }
}
