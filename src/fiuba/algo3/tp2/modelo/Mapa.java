package fiuba.algo3.tp2.modelo;

import java.util.HashMap;
import java.util.Map;


public class Mapa {

    HashMap<Posicion, Unidad> coleccionUnidades;
    HashMap<Posicion, Edificio> coleccionEdificios;
    int dimension_filas;
    int dimension_columnas;

    public Mapa(int fila , int columna){

        this.coleccionUnidades = new HashMap<>();
        this.coleccionEdificios = new HashMap<>();
        this.dimension_filas = fila;
        this.dimension_columnas = columna;

    }

    public void colocarUnidad(Unidad unaUnidad, Posicion unaPosicion) {
        this.validarPosicion(unaPosicion);
        coleccionUnidades.put(unaPosicion, unaUnidad);
    }

    private void validarPosicion(Posicion unaPosicion) {
        if (!unaPosicion.estaContenidaEnDimensiones(dimension_filas, dimension_columnas))
            throw new UbicacionErroneaException();

        if(coleccionUnidades.containsKey(unaPosicion))
            throw new UbicacionOcupadaException();
    }

    public int getTamanio() {
        return (dimension_filas * dimension_columnas);
    }

    public Unidad recuperarUnidad(Posicion posicion) {
        Unidad unaUnidad = null;
        for (Posicion posActual : coleccionUnidades.keySet()) {
            if ((posActual.getFila() == posicion.getFila()) && (posActual.getColumna() == posicion.getColumna())) {
                unaUnidad = coleccionUnidades.get(posActual);
            }
        }
        return unaUnidad;
    }

    public void moverUnidadArriba(Unidad unaUnidad) {
        Posicion posicionAnterior = new Posicion(15,15);
        for (Posicion posActual : coleccionUnidades.keySet()) {
            if (coleccionUnidades.get(posActual) == unaUnidad) {
                posicionAnterior = posActual;
            }
        }
        Posicion posicionNueva = new Posicion(posicionAnterior.getFila() - 1 , posicionAnterior.getColumna());
        this.validarPosicion(posicionNueva); // Esto puede lanzar excepciones si ya está ocupada la celda o no es válida
        this.colocarUnidad(unaUnidad, posicionNueva);
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

    public void colocarEdificio(Edificio unEdificio, Posicion posicionPlaza) {
    }

    public void ColocarCastilo(Castillo castillo, Posicion posicionCastillo) {
    }
}
