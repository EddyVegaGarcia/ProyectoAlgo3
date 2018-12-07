package fiuba.algo3.tp2.modelo;

import java.util.ArrayList;
import java.util.HashMap;
import fiuba.algo3.tp2.modelo.Exception.*;
import static fiuba.algo3.tp2.modelo.Constantes.*;

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

    public void colocarPieza(Pieza unaPieza, Posicion unaPosicion){

        if(unaPieza.obtenerTamanio() > 1){
            this.colocarEdificio((Edificio) unaPieza, unaPosicion);
        }
        else
            this.colocarUnidad((Unidad) unaPieza, unaPosicion);

    }

    public int getTamanio() {
        return (posicionLimite.obtenerTamanioLimite());
    }


    private void colocarEdificio(Edificio edificio, Posicion posicion) {

        ArrayList<Posicion> unaLista = new ArrayList<>();

        unaLista.add(posicion);
        unaLista.add(new Posicion(posicion.getFila(), posicion.getColumna() + 1));
        unaLista.add(new Posicion(posicion.getFila() + 1, posicion.getColumna()));
        unaLista.add(new Posicion(posicion.getFila() + 1, posicion.getColumna() + 1));

        this.agregarPiezaAMapa(unaLista, edificio);
        edificio.agregarPosicion(unaLista);

    }

    private void colocarUnidad(Unidad unaUnidad, Posicion posicion) {

        ArrayList<Posicion> unaLista = new ArrayList<>();
        unaLista.add(posicion);
        this.agregarPiezaAMapa(unaLista, unaUnidad);
        unaUnidad.agregarPosicion(unaLista);

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
