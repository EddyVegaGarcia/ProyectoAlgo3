package fiuba.algo3.tp2.modelo;

import javafx.geometry.Pos;

import java.util.HashMap;
import java.util.Map;

import static fiuba.algo3.tp2.modelo.Constantes.*;

public class Mapa {

    Map<Posicion, Unidad> coleccionUnidad;
    Posicion posicionMaxima;

    public Mapa(){

        coleccionUnidad = new HashMap<>();
        posicionMaxima = new Posicion(LIMIT_HORIZONTAL, LIMIT_VERTICAL);

    }

    public void colocarUnidad(Unidad unaUnidad, Posicion unaPosicion) {

        posicionMaxima.contiene(unaPosicion.getFila(), unaPosicion.getColumna());
        if(coleccionUnidad.containsKey(unaPosicion))
            throw new UbicacionOcupadaException();
        coleccionUnidad.put(unaPosicion, unaUnidad);
    }

    public int getTamanio() {
        return LIMIT_HORIZONTAL * LIMIT_VERTICAL;
    }

    public Unidad recuperarUnidad(Posicion posicion) {
        return coleccionUnidad.get(posicion);
    }

    public void moverUnidadA(Unidad unaUnidad, Posicion posicionAnterior, Posicion posicionNueva) {
        coleccionUnidad.remove(posicionAnterior, unaUnidad);
        coleccionUnidad.put(posicionNueva, unaUnidad);
    }
}
