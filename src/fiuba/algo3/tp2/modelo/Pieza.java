package fiuba.algo3.tp2.modelo;


import java.util.List;

public abstract class Pieza {

    int vida;
    int costo;
    int tamanio;
    List<Posicion> posiciones;

    public int obtenerVida(){ return vida; }

    public int obtenerTamanio() { return tamanio; }

    public abstract void recibirDanio(int danio);

}
