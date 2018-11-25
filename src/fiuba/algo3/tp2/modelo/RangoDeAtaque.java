package fiuba.algo3.tp2.modelo;

import javafx.geometry.Pos;

import java.util.ArrayList;
import java.util.List;

public class RangoDeAtaque {

    Mapa mapa;
    List<Posicion> posicionesDeAtaque;

    public RangoDeAtaque(Mapa mapa) {
        this.mapa = mapa;
        this.posicionesDeAtaque = new ArrayList<>();
    }

    public void calcularRangoDeAtaque(Atacante unAtacante, Posicion posicionEdificio) {
        int filaSuperior = posicionEdificio.getFila();
        int columnaIzquierda = posicionEdificio.getColumna();
        int filaInferior = filaSuperior + (unAtacante.obtenerTamanio() / 4);
        int columnaDerecha = columnaIzquierda + (unAtacante.obtenerTamanio() / 4);
        int distanciaAtaque = unAtacante.obtenerDistanciaAtaque();

        for (int i = columnaIzquierda - distanciaAtaque; i <= columnaDerecha + distanciaAtaque; i++) {
            for (int j = filaSuperior - distanciaAtaque; j <= filaInferior + distanciaAtaque; j++) {
                Posicion posActual = new Posicion(i, j);
                if (posActual.estaContenidaEnDimensiones(mapa.getFilas(), mapa.getColumnas())) {
                    posicionesDeAtaque.add(posActual);
                }
            }
        }
    }

    public void filtrarPosicion(Posicion posicion) {
        posicionesDeAtaque.remove(posicion);
    }
}