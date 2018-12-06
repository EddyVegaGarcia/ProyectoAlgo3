package fiuba.algo3.tp2.controlador;

import fiuba.algo3.tp2.vista.CastilloView;
import javafx.scene.canvas.Canvas;

public class UbicarEdificios {
    private final Jugador jugador1;
    private final Canvas canvasCentral;

    public UbicarEdificios(Juego juego, Canvas canvasCentral) {
        jugador1 = juego.jugador1();

        this.canvasCentral = canvasCentral;

        ubicarCastilloDeJugador(jugador1);
    }

    private void ubicarCastilloDeJugador(Jugador jugador1) {
        int posicionX = 17;
        int posicionY = 0;
        CastilloView castillo = new CastilloView(canvasCentral, posicionX, posicionY);
    }
}
