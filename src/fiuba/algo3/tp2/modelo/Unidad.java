package fiuba.algo3.tp2.modelo;

public abstract class Unidad implements Atacable{

    int vida;
    Posicion posicion;
    int costo;

    public abstract void atacar(Edificio edificio);

    public int obtenerVida(){
        return vida;
    }


}

