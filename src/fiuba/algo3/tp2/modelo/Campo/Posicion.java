package fiuba.algo3.tp2.modelo.Campo;

import static java.lang.Math.sqrt;

public class Posicion {

    private int posicionFila;
    private int posicionColumna;

    public Posicion(int unaPosicionFila, int unaPosicionColumna) {
        this.posicionFila = unaPosicionFila;
        this.posicionColumna = unaPosicionColumna;
    }

    public int getColumna() {
        return posicionColumna;
    }

    public int getFila() {
        return posicionFila;
    }

    public boolean estaContenidaEnDimensiones(Posicion unaPosicionLimite) {
        return ((posicionFila >= 0) && (posicionColumna >= 0)
                && (posicionFila < unaPosicionLimite.getFila()) && (posicionColumna < unaPosicionLimite.getColumna()));

    }

    public boolean compararPosicion(Posicion unaPosicion) {
        return ( posicionFila == unaPosicion.getFila()) && (posicionColumna == unaPosicion.getColumna());
    }

    public int obtenerTamanioLimite() {
        return posicionFila * posicionColumna;
    }

    public boolean estaContenidaEn(Posicion unaPosicion, int unTamanio) {
        return((posicionFila <= (unaPosicion.getFila()+unTamanio)) && (posicionColumna <= (unaPosicion.getColumna()+unTamanio))
                && (posicionFila >= unaPosicion.getFila()) && (posicionColumna >= unaPosicion.getColumna()));
    }

    public boolean validacionPosicionValida(Posicion unaPosicion, int tamanioDelEdificio){

        Posicion nuevaPosicion = new Posicion(posicionFila - 1 , posicionColumna - 1);

        return  unaPosicion.estaContenidaEn(nuevaPosicion, (int) (sqrt(tamanioDelEdificio) + 1));

    }
}

    /*
    public Posicion calcularPosicionDeUnRango(int tamanio, Mapa mapa) {
            int filaInferior = posicionFila + (tamanio/ 4);
            int columnaDerecha = posicionColumna + (tamanio / 4);

            for (int i = posicionColumna + tamanio; i <= columnaDerecha + tamanio; i++) {
                for (int j = posicionFila + tamanio; j <= filaInferior + tamanio; j++) {
                    Posicion posActual = new Posicion(i, j);
                    if (estaContenidaEnDimensiones(mapa.getFilas(),mapa.getColumnas()) && mapa.estaDisponible(posActual)) {
                        return posActual;
                    }
                }
            }
            return null;
    }*/