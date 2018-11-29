package fiuba.algo3.tp2.modelo;

//import java.lang.reflect.Array;

import java.util.HashMap;
import fiuba.algo3.tp2.modelo.Exception.*;


public class Mapa {

    HashMap<Posicion, Pieza> piezasDelMapa;
    int dimension_filas;
    int dimension_columnas;

    public Mapa(int fila , int columna){

        this.piezasDelMapa = new HashMap<>();
        this.dimension_filas = fila;
        this.dimension_columnas = columna;

    }

    /*  METODOS PUBLICOS*/

    public void colocarEdificio(Edificio edificio, Posicion posicion) {
        for (int i = posicion.getFila() ; i <= (edificio.obtenerTamanio() / 4) ; i++) {
            for (int j = posicion.getColumna() ; j <= (edificio.obtenerTamanio() / 4) ; j++) {
                Posicion posActual = new Posicion(i, j);
                this.validarPosicion(posActual);
                piezasDelMapa.put(posActual, edificio);
            }
        }
    }

    public void colocarUnidad(Unidad unidad, Posicion posicion) {
        this.validarPosicion(posicion);
        piezasDelMapa.put(posicion, unidad);
    }


    /*   METODOS PRIVADOS  */
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
        this.(unaUnidad, posicionNueva);
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
        for (Posicion posActual : coleccionUnidades.keySet()) {
            if (coleccionUnidades.get(posActual) == unaUnidad) {
                posicionAnterior = posActual;
            }
        }
        Posicion posicionNueva = new Posicion(posicionAnterior.getFila() + 1 , posicionAnterior.getColumna());
        this.validarPosicion(posicionNueva); // Esto puede lanzar excepciones si ya está ocupada la celda o no es válida
        this.colocarUnidad(unaUnidad, posicionNueva);
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
