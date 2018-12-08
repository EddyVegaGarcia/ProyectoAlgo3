package fiuba.algo3.tp2.controlador;

import fiuba.algo3.tp2.modelo.Campo.*;
import fiuba.algo3.tp2.modelo.Juego.*;
import fiuba.algo3.tp2.modelo.Piezas.Edificios.Castillo;
import javafx.scene.canvas.Canvas;

import static fiuba.algo3.tp2.modelo.Campo.Constantes.*;


public class UbicarCastillo {
    private Jugador jugador;
    private Canvas canvasCentral;
    private double widht;
    private double height;

    public UbicarCastillo(Jugador jugador, Canvas canvasCentral) {

        this.jugador = jugador;

        this.canvasCentral = canvasCentral;

        widht = canvasCentral.getWidth();
        height = canvasCentral.getHeight();

        ubicarCastilloDeJugador();
    }

    private void ubicarCastilloDeJugador() {
        Castillo castillo = jugador.obtenerCastillo();
        Posicion posicion = castillo.obtenerPosicion();

        double posicionX = (posicion.getColumna()*widht/COLUMNA_DEFAULT_MAPA);
        double posicionY = (posicion.getFila()*height/FILA_DEFAULT_MAPA);

        //CastilloView castilloView = new CastilloView(canvasCentral, posicionX, posicionY);
    }
}
