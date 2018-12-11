package fiuba.algo3.tp2.modelo.Piezas;

import fiuba.algo3.tp2.modelo.Campo.*;
import fiuba.algo3.tp2.modelo.Exception.*;

import java.util.ArrayList;

public abstract class Pieza {

    protected int vida;
    protected int costo;
    protected int tamanio;
    protected ArrayList<Posicion> posiciones;
    protected int accionesRealizadas = 0;

    public int obtenerVida(){ return vida; }

    public int obtenerTamanio() { return tamanio; }

    public void recibirDanio(int unDanio) { this.vida = vida - unDanio;}

    public void agregarPosicion(ArrayList<Posicion> unaLista) {posiciones = unaLista;}

    public Posicion obtenerPosicion(){
        return posiciones.get(0);
    }

    public void validarAcciones(){
        if(accionesRealizadas == 1)
            throw new AccionUnicaRealizadaException();
    }

    protected void accionRealizada() {
        accionesRealizadas++;
    }

    public abstract String nombre();

    public abstract boolean podesAtacar();

    public abstract boolean podesConstruirArmaDeAsedio();

    public abstract boolean podesCrearUnAldeano();

    public abstract boolean podesReparar();

    public abstract double getTamanio();

}
