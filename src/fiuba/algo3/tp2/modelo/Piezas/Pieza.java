package fiuba.algo3.tp2.modelo.Piezas;

import fiuba.algo3.tp2.modelo.Campo.*;
import fiuba.algo3.tp2.modelo.Exception.*;
import fiuba.algo3.tp2.modelo.UnidadFactory.PiezaType;

import java.util.ArrayList;

public abstract class Pieza {

    protected int vida;
    protected int costo;
    protected int tamanio;
    protected ArrayList<Posicion> posiciones;
    protected int accionesRealizadas = 0;

    public int obtenerVida(){ return vida; }

    public Posicion obtenerPrimeraPosicion() { return posiciones.get(0);
    }

    public int obtenerTamanio() { return tamanio; }

    public void recibirDanio(int unDanio) {

        if (vida - unDanio <= 0) {
            vida = 0;
            throw new PiezaDestruidaException();
        }
        this.vida = vida - unDanio;

    }

    public void agregarPosicion(ArrayList<Posicion> unaLista) {posiciones = unaLista;}

    public ArrayList<Posicion> obtenerPosicion(){
        return posiciones;
    }

    public void validarAcciones(){

        if(accionesRealizadas == 1)
            throw new AccionUnicaRealizadaException();
    }

    protected void accionRealizada() {
        accionesRealizadas = 1;
    }

    public abstract double getTamanio();

    public abstract PiezaType obtenerType();

    public void refrescar(){
        accionesRealizadas = 0;
    }

    protected void validarRangoDeAtaque(ArrayList<Posicion> unaListaPosiciones, int unaDistanciaDeAtaque) {

        for(Posicion unaPosicion : unaListaPosiciones){

            if(unaPosicion.estaContenidaEnRangoDeAtaque(posiciones.get(0), unaDistanciaDeAtaque))
                return;
        }
        throw new PiezaAtacadaNoEstaEnRangoDeAtaqueExeception();

    }

    public abstract void verificarPosibleConstruccion();

    public abstract void verificarPosibleReparacion();
}
