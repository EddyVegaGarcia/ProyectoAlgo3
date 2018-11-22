package fiuba.algo3.tp2.modelo;

import java.util.HashMap;
import java.util.Map;

import static fiuba.algo3.tp2.modelo.Constantes.*;

public class Mapa {

    Map<Posicion, Unidad> coleccionUnidades,coleccionEdificios;
    Posicion posicionMaxima;

    public Mapa(){

        this.coleccionUnidades = new HashMap<>();
        this.coleccionEdificios = new HashMap<>()
        this.posicionMaxima = new Posicion(FILA_DEFAULT_MAPA, COLUMNA_DEFAULT_MAPA);

    }

    public void colocarUnidad(Unidad unaUnidad, Posicion unaPosicion) {

        posicionMaxima.contiene(unaPosicion.getFila(), unaPosicion.getColumna());
        if(coleccionUnidades.containsKey(unaPosicion))
            throw new UbicacionOcupadaException();
        coleccionUnidades.put(unaPosicion, unaUnidad);
    }

    public int getTamanio() {
        return FILA_DEFAULT_MAPA * COLUMNA_DEFAULT_MAPA;
    }

    public Unidad recuperarUnidad(Posicion posicion) {
        return coleccionUnidades.get(posicion);
    }

    public void moverUnidadA(Unidad unaUnidad, Posicion posicionAnterior, Posicion posicionNueva) {
        coleccionUnidades.remove(posicionAnterior, unaUnidad);
        coleccionUnidades.put(posicionNueva, unaUnidad);
    }
}
