package fiuba.algo3.tp2.modelo.Campo;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import fiuba.algo3.tp2.modelo.Exception.*;
import fiuba.algo3.tp2.modelo.Interfaces.Direccion;
import fiuba.algo3.tp2.modelo.Piezas.*;

import static fiuba.algo3.tp2.modelo.Constantes.*;
import static java.lang.Math.sqrt;

public class Mapa {

    HashMap<Posicion, Pieza> piezasDelMapa;
    Posicion posicionLimite;

    public Mapa() {

        this.piezasDelMapa = new HashMap<>();
        this.posicionLimite = new Posicion(FILA_DEFAULT_MAPA, COLUMNA_DEFAULT_MAPA);

    }

    public int getTamanio() {
        return (posicionLimite.obtenerTamanioLimite());
    }

    public ArrayList<Posicion> generarLista(Posicion unaPosicion, int tamanio){

        ArrayList<Posicion> unaLista = new ArrayList<>();

        for(int i = 0; i < sqrt(tamanio); i++){
            for(int j = 0; j < sqrt(tamanio); j++){

                unaLista.add(new Posicion(unaPosicion.getFila() + i,
                        unaPosicion.getColumna() + j));

            }
        }

        return unaLista;
    }

    public void colocarPieza(Pieza unaPieza, Posicion unaPosicion){

        ArrayList<Posicion> unaLista = this.generarLista(unaPosicion, unaPieza.obtenerTamanio());

        this.agregarPiezaAMapa(unaLista, unaPieza);
        unaPieza.agregarPosicion(unaLista);

    }

    private void agregarPiezaAMapa(ArrayList<Posicion> unaListaPiezas, Pieza unaPieza){

        for(Posicion unaPosicion : unaListaPiezas){

            this.validarPosicion(unaPosicion);
            piezasDelMapa.put(unaPosicion, unaPieza);

        }

    }

    public void validarPosicion(Posicion unaPosicion) {

        if (!unaPosicion.estaContenidaEnDimensiones(posicionLimite))
            throw new UbicacionErroneaException();

        for (Posicion posActual : piezasDelMapa.keySet()) {

            if (posActual.compararPosicion(unaPosicion))
                throw new UbicacionOcupadaException();

        }

    }

    public Pieza recuperarPieza(Posicion unaPosicion) {

        Pieza unaPieza = null;

        for (Posicion posActual : piezasDelMapa.keySet()) {

            if (posActual.compararPosicion(unaPosicion)){

                unaPieza = piezasDelMapa.get(posActual);

            }

        }

        return unaPieza;

    }

    public void moverUnidad(Posicion posicion, Direccion direccion) {

        Posicion nuevaPosicion = direccion.obtenerNuevaPosicion(posicion);
        this.validarPosicion(nuevaPosicion);
        Unidad aldeano = (Unidad) this.recuperarPieza(posicion);
        aldeano.cambiarPosicion(nuevaPosicion);
        piezasDelMapa.remove(posicion);
        piezasDelMapa.put(nuevaPosicion, aldeano);

    }

    public void borrarUnidad(Unidad unidad, Posicion unaPosicion) {

        try {

            this.validarPosicion(unaPosicion);

        }
        catch (UbicacionOcupadaException e) {

            for (Posicion posActual : piezasDelMapa.keySet()) {

                if (posActual.compararPosicion(unaPosicion)){
                    piezasDelMapa.remove(posActual, unidad);
                }

            }

        }

    }

    public void actualizarPiezas() {

        List<Pieza> unaLista = new ArrayList<>();

        for(Posicion unaPosicion: piezasDelMapa.keySet()) {
            if (piezasDelMapa.get(unaPosicion).obtenerVida() == 0) {
                unaLista.add(piezasDelMapa.get(unaPosicion));
            }
        }

        piezasDelMapa.values().removeAll(unaLista);

    }

    public ArrayList<Pieza> obtenerPiezasQueEstanEnRango(Posicion posicion, int tamanio, int distancia) {
        ArrayList<Pieza> piezas = new ArrayList<Pieza>();

        Posicion posicionInicio = new Posicion(posicion.getFila() - distancia, posicion.getColumna() - distancia);
        for(int i = 0; i < sqrt(tamanio) + (distancia*2); i++){
            for(int j = 0; j < sqrt(tamanio) + (distancia*2); j++){

                Posicion posicionActual = new Posicion(posicionInicio.getFila() + i,posicionInicio.getColumna() + j);
                Pieza pieza = recuperarPieza(posicionActual);
                if( pieza != null && !piezas.contains(pieza))
                    piezas.add(pieza);
            }
        }
        return piezas;
    }
}
