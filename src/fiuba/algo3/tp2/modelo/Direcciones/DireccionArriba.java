package fiuba.algo3.tp2.modelo.Direcciones;

import fiuba.algo3.tp2.modelo.Campo.*;
import fiuba.algo3.tp2.modelo.Interfaces.Direccion;

public class DireccionArriba implements Direccion {

    public Posicion obtenerNuevaPosicion(Posicion posAnterior) {
        int nuevaFila = posAnterior.getFila() - 1;
        return new Posicion(nuevaFila, posAnterior.getColumna());
    }
}
