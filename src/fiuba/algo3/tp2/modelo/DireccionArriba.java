package fiuba.algo3.tp2.modelo;

public class DireccionArriba extends Direccion {

    public Posicion obtenerNuevaPosicion(Posicion posAnterior) {
        int nuevaFila = posAnterior.getFila() - 1;
        return new Posicion(nuevaFila, posAnterior.getColumna());
    }
}
