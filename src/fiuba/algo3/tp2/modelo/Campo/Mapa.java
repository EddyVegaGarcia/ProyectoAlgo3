package fiuba.algo3.tp2.modelo.Campo;

import java.util.ArrayList;
import java.util.HashMap;
import fiuba.algo3.tp2.modelo.Exception.*;
import fiuba.algo3.tp2.modelo.Interfaces.Direccion;
import fiuba.algo3.tp2.modelo.Piezas.*;

import static fiuba.algo3.tp2.modelo.Campo.Constantes.*;
import static java.lang.Math.sqrt;

public class Mapa {

    HashMap<Posicion, Pieza> piezasDelMapa;
    Posicion posicionLimite;

    public Mapa() {

        this.piezasDelMapa = new HashMap<>();
        this.posicionLimite = new Posicion(FILA_DEFAULT_MAPA, COLUMNA_DEFAULT_MAPA);

    }

    public Mapa(int fila , int columna){

        this.piezasDelMapa = new HashMap<>();
        this.posicionLimite = new Posicion(fila,columna);

    }

    public int getTamanio() {
        return (posicionLimite.obtenerTamanioLimite());
    }

    public void colocarPieza(Pieza unaPieza, Posicion unaPosicion){

        ArrayList<Posicion> unaLista = new ArrayList<>();

        for(int i = 0; i < sqrt(unaPieza.obtenerTamanio()); i++){
            for(int j = 0; j < sqrt(unaPieza.obtenerTamanio()); j++){

                unaLista.add(new Posicion(unaPosicion.getFila() + i,
                        unaPosicion.getColumna() + j));

            }
        }

        this.agregarPiezaAMapa(unaLista, unaPieza);
        unaPieza.agregarPosicion(unaLista);

    }

    private void agregarPiezaAMapa(ArrayList<Posicion> unaListaPiezas, Pieza unaPieza){

        for(Posicion unaPosicion : unaListaPiezas){

            this.validarPosicion(unaPosicion);
            piezasDelMapa.put(unaPosicion, unaPieza);

        }

    }

    private void validarPosicion(Posicion unaPosicion) {

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
        Pieza aldeano = this.recuperarPieza(posicion);
        piezasDelMapa.remove(posicion);
        piezasDelMapa.put(nuevaPosicion, aldeano);
        aldeano.cambiarPosicion(nuevaPosicion);

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

}
