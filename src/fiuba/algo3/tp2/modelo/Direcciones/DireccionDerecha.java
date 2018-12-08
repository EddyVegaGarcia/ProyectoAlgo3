package fiuba.algo3.tp2.modelo.Direcciones;

import fiuba.algo3.tp2.modelo.Campo.*;
import fiuba.algo3.tp2.modelo.Interfaces.Direccion;

public class DireccionDerecha implements Direccion {

    public Posicion obtenerNuevaPosicion(Posicion posAnterior) {
        int nuevaColumna = posAnterior.getColumna() + 1;
        return new Posicion(posAnterior.getFila(), nuevaColumna);
    }
}
