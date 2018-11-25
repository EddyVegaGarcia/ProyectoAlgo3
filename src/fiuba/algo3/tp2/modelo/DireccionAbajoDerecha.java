package fiuba.algo3.tp2.modelo;

public class DireccionAbajoDerecha extends Direccion {

    public Posicion obtenerNuevaPosicion(Posicion posAnterior) {
        int nuevaFila = posAnterior.getFila() + 1;
        int nuevaColumna = posAnterior.getColumna() + 1;
        return new Posicion(nuevaFila, nuevaColumna);
    }
}
