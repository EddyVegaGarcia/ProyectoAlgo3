package fiuba.algo3.tp2.modelo.Piezas;

import fiuba.algo3.tp2.modelo.Campo.*;

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

    public Posicion obtenerPosicion(){
        return posiciones.get(0);
    }

    //protected abstract ArrayList<> obtenerPosicion();
}
