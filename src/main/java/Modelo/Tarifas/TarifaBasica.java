package Modelo.Tarifas;

public class TarifaBasica extends Tarifa{


    public TarifaBasica() {
        super();
    }

    public TarifaBasica(float precio){
        super(precio);
    }

    @Override
    public float getPrecio(){
        return precio;
    }

}
