package fiuba.algo3.tp2.modelo;

public class DireccionIzquierda extends Direccion {

    public Posicion obtenerNuevaPosicion(Posicion posAnterior) {
        int nuevaColumna = posAnterior.getColumna() - 1;
        return new Posicion(posAnterior.getFila(), nuevaColumna);
    }
}
