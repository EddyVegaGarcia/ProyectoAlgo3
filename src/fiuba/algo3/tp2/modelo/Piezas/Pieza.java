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

    public int obtenerTamanio() { return tamanio; }

    public void recibirDanio(int unDanio) {

        if (vida - unDanio <= 0) {
            vida = 0;
            throw new PiezaDestruidaException();
        }
        this.vida = vida - unDanio;

    }

    public void agregarPosicion(ArrayList<Posicion> unaLista) {posiciones = unaLista;}

    public Posicion obtenerPosicion(){
        return posiciones.get(0);
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

    public abstract String obtenerNombre();

    public void refrescar(){
        accionesRealizadas = 0;
    }

    public void validarRangoDeAtaque(Posicion posicionPiezaAtacada, int distanciaDeAtaque) {

        if(!posicionPiezaAtacada.estaContenidaEnRangoDeAtaque(this.obtenerPosicion(), distanciaDeAtaque))
            throw new PiezaAtacadaNoEstaEnRangoDeAtaqueExeception();

    }

    protected void validarRangoDeAtaqueAEdificio(ArrayList<Posicion> unaListaPosiciones, int unaDistanciaDeAtaque) {

        boolean estaContenido = false;

        for(Posicion unaPosicion : unaListaPosiciones){

            estaContenido = unaPosicion.estaContenidaEnRangoDeAtaque(this.obtenerPosicion(), unaDistanciaDeAtaque);

        }

        if(estaContenido)
            return;
        else
            throw new PiezaAtacadaNoEstaEnRangoDeAtaqueExeception();

    }
}
