package fiuba.algo3.tp2.modelo;


import java.util.ArrayList;

public abstract class Pieza {

    protected int vida;
    protected int costo;
    protected int tamanio;
    protected ArrayList<Posicion> posiciones;

    public int obtenerVida(){ return vida; }

    public int obtenerTamanio() { return tamanio; }


    public abstract void recibirDanio(int unDanio);

    public void agregarPosicion(ArrayList<Posicion> unaLista) {posiciones = unaLista;}
}
