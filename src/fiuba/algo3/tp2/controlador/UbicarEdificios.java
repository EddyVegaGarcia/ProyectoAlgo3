package fiuba.algo3.tp2.controlador;

import fiuba.algo3.tp2.modelo.Juego.*;
import fiuba.algo3.tp2.vista.CastilloView;
import javafx.scene.canvas.Canvas;

import static fiuba.algo3.tp2.modelo.Campo.Constantes.*;


public class UbicarEdificios {
    private final Jugador jugador1;
    private final Canvas canvasCentral;
    private final double widht;
    private final double height;

    public UbicarEdificios(Juego juego, Canvas canvasCentral) {
        jugador1 = juego.jugador1();

        this.canvasCentral = canvasCentral;

        widht = canvasCentral.getWidth();
        height = canvasCentral.getHeight();

        ubicarCastilloDeJugador(jugador1);
    }

    private void ubicarCastilloDeJugador(Jugador jugador1) {
        double posicionX = (18*widht/COLUMNA_DEFAULT_MAPA);
        double posicionY = (31*height/FILA_DEFAULT_MAPA);
        CastilloView castillo = new CastilloView(canvasCentral, posicionX, posicionY);
    }
}
