package fiuba.algo3.tp2.modelo;

import fiuba.algo3.tp2.modelo.Interfaces.Direccion;

public class DireccionAbajo implements Direccion {

    public Posicion obtenerNuevaPosicion(Posicion posAnterior) {
        int nuevaFila = posAnterior.getFila() + 1;
        return new Posicion(nuevaFila, posAnterior.getColumna());
    }
}
