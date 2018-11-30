package fiuba.algo3.tp2.modelo;

//import java.lang.reflect.Array;

import java.util.HashMap;
import fiuba.algo3.tp2.modelo.Exception.*;
import static fiuba.algo3.tp2.modelo.Constantes.*;


public class Mapa {

    HashMap<Posicion, Pieza> piezasDelMapa;
    int dimension_filas;
    int dimension_columnas;


    public Mapa() {

        this.piezasDelMapa = new HashMap<>();
        this.dimension_filas = FILA_DEFAULT_MAPA;
        this.dimension_columnas = COLUMNA_DEFAULT_MAPA;

    }

    public Mapa(int fila , int columna){

        this.piezasDelMapa = new HashMap<>();
        this.dimension_filas = fila;
        this.dimension_columnas = columna;

    }


    /*  METODOS PUBLICOS*/
    public void colocarPieza(Pieza unaPieza, Posicion unaPosicion){

        if(unaPieza.obtenerTamanio() > 1){
            this.colocarEdificio((Edificio) unaPieza, unaPosicion);
        }
        else
            this.colocarUnidad((Unidad)unaPieza, unaPosicion);

    }

    /*   METODOS PRIVADOS  */

    private void colocarEdificio(Edificio edificio, Posicion posicion) {
        for (int i = posicion.getFila() ; i <= (edificio.obtenerTamanio() / 4) ; i++) {
            for (int j = posicion.getColumna() ; j <= (edificio.obtenerTamanio() / 4) ; j++) {
                Posicion posActual = new Posicion(i, j);
                this.validarPosicion(posActual);
                piezasDelMapa.put(posActual, edificio);
            }
        }
    }

    private void colocarUnidad(Unidad unidad, Posicion posicion) {
        this.validarPosicion(posicion);
        piezasDelMapa.put(posicion, unidad);
    }
    private void validarPosicion(Posicion unaPosicion) {
        if (!unaPosicion.estaContenidaEnDimensiones(dimension_filas, dimension_columnas))
            throw new UbicacionErroneaException();

        if(piezasDelMapa.containsKey(unaPosicion))
            throw new UbicacionOcupadaException();
    }

    public void moverUnidadArriba(Unidad unaUnidad) {
        Posicion posicionAnterior = new Posicion(15,15);
        for (Posicion posActual : piezasDelMapa.keySet()) {
            if (piezasDelMapa.get(posActual) == unaUnidad) {
                posicionAnterior = posActual;
            }
        }
        Posicion posicionNueva = new Posicion(posicionAnterior.getFila() - 1 , posicionAnterior.getColumna());
        this.validarPosicion(posicionNueva); // Esto puede lanzar excepciones si ya está ocupada la celda o no es válida
        //this.(unaUnidad, posicionNueva);
    }

    public int getTamanio() {
        return (dimension_filas * dimension_columnas);
    }

    public int getFilas() { return dimension_filas; }

    public int getColumnas() { return dimension_columnas; }

    public Pieza recuperarPieza(Posicion posicion) {
        // Si la pieza no está en el mapa, se devuelve null.
        Pieza pieza = null;
        for (Posicion posActual : piezasDelMapa.keySet()) {
            if ((posActual.getFila() == posicion.getFila()) && (posActual.getColumna() == posicion.getColumna())) {
                pieza = piezasDelMapa.get(posActual);
            }
        }
        return pieza;
    }

    public void moverUnidadAbajo(Unidad unaUnidad) {
        Posicion posicionAnterior = new Posicion(14,22);
        for (Posicion posActual : piezasDelMapa.keySet()) {
            if (piezasDelMapa.get(posActual) == unaUnidad) {
                posicionAnterior = posActual;
            }
        }
        Posicion posicionNueva = new Posicion(posicionAnterior.getFila() + 1 , posicionAnterior.getColumna());
        this.validarPosicion(posicionNueva); // Esto puede lanzar excepciones si ya está ocupada la celda o no es válida
        this.colocarUnidad(unaUnidad, posicionNueva);
    }

    public void colocarPiezaNoAtacante(Pieza unPieza, Posicion unPosicion) {

    }

    public void colocarPiezaAtacante(Atacante unAtacante, Posicion posicion) {

        for (int i = posicion.getFila() ; i <= (unAtacante.obtenerTamanio() / 4) ; i++) {
            for (int j = posicion.getColumna() ; j <= (unAtacante.obtenerTamanio() / 4) ; j++) {
                Posicion posActual = new Posicion(i, j);
                this.validarPosicion(posActual);
                piezasDelMapa.put(posActual, (Pieza) unAtacante); /* casteo porque no me deja agregar al hash*/
            }
        }
    }

    public void moverAldeano(Posicion posicion, Direccion direccion) {
        Posicion nuevaPosicion = direccion.obtenerNuevaPosicion(posicion);
        this.validarPosicion(nuevaPosicion);
        Pieza aldeano = piezasDelMapa.get(posicion);
        piezasDelMapa.remove(posicion);
        piezasDelMapa.put(nuevaPosicion, aldeano);
    }

    public void ubicarUnidadAlrededorDeEdificio(Unidad unidad, Edificio edificio) {


    }

    public boolean estaDisponible(Posicion posicion) {
        return !piezasDelMapa.containsKey(posicion);
    }

    public void borrarUnidad(Unidad unidad, Posicion unaPosicion) {
        if (piezasDelMapa.containsKey(unaPosicion)) {
            piezasDelMapa.remove(unaPosicion, unidad);
        }
        else {
            throw new UnidadInexistenteException();
        }
    }
}
