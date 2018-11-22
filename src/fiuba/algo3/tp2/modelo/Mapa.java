package fiuba.algo3.tp2.modelo;

import java.util.HashMap;
import java.util.Map;


public class Mapa {

    Map<Posicion, Unidad> coleccionUnidades,coleccionEdificios;
    Posicion posicionMaxima;
    int fila;
    int columna;

    public Mapa(int fila , int columna){

        this.coleccionUnidades = new HashMap<>();
        this.coleccionEdificios = new HashMap<>();
        this.posicionMaxima = new Posicion(fila, columna);

    }

    public void colocarUnidad(Unidad unaUnidad, Posicion unaPosicion) {

        posicionMaxima.contiene(unaPosicion.getFila(), unaPosicion.getColumna());
        if(coleccionUnidades.containsKey(unaPosicion))
            throw new UbicacionOcupadaException();
        coleccionUnidades.put(unaPosicion, unaUnidad);
    }

    public int getTamanio() {
        return (fila * columna);
    }

    public Unidad recuperarUnidad(Posicion posicion) {
        return coleccionUnidades.get(posicion);
    }

    public void moverUnidadA(Unidad unaUnidad, Posicion posicionAnterior, Posicion posicionNueva) {
        coleccionUnidades.remove(posicionAnterior, unaUnidad);
        coleccionUnidades.put(posicionNueva, unaUnidad);
    }
}
