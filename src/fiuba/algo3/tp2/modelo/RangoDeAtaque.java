package fiuba.algo3.tp2.modelo;

import fiuba.algo3.tp2.modelo.Campo.*;
import fiuba.algo3.tp2.modelo.Interfaces.Atacante;

import java.util.ArrayList;
import java.util.List;

public class RangoDeAtaque {

    public List<Posicion> posicionesDeAtaque;
    private Posicion posicionPrincipalDeCastillo;

    public RangoDeAtaque(Posicion posicion) {

        this.posicionPrincipalDeCastillo = posicion;
        this.posicionesDeAtaque = new ArrayList<>();

    }

    public List<Posicion> obtenerRangoDeAtaque(Atacante unAtacante, Posicion posicionEdificio) {

        int filaSuperior = posicionEdificio.getFila();
        int columnaIzquierda = posicionEdificio.getColumna();
        int filaInferior = filaSuperior + (unAtacante.obtenerTamanio() / 4);
        int columnaDerecha = columnaIzquierda + (unAtacante.obtenerTamanio() / 4);
        int distanciaAtaque = unAtacante.obtenerDistanciaAtaque();

        for (int i = columnaIzquierda - distanciaAtaque; i <= columnaDerecha + distanciaAtaque; i++) {
            for (int j = filaSuperior - distanciaAtaque; j <= filaInferior + distanciaAtaque; j++) {
                posicionesDeAtaque.add(new Posicion(i, j));
            }
        }
        return posicionesDeAtaque;
    }


    public void filtrarPosicion(Posicion posicion) {
        posicionesDeAtaque.remove(posicion);
    }
}