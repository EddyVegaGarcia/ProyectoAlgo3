package fiuba.algo3.tp2.controlador;

import fiuba.algo3.tp2.modelo.Campo.Mapa;
import fiuba.algo3.tp2.modelo.Juego.Juego;
import javafx.event.EventHandler;
import javafx.scene.canvas.Canvas;
import javafx.scene.input.MouseEvent;

public class MouseCreacionEventHandler implements EventHandler<MouseEvent> {

    private Mapa mapa;
    private JuegoView juegoView;
    private double height;
    private double widht;

    public MouseCreacionEventHandler(JuegoView juegoView, Juego juego, Canvas canvas) {

        this.widht = canvas.getWidth();
        this.height = canvas.getHeight();
        this.juegoView = juegoView;
        this.mapa = juego.mapa();

    }

    @Override
    public void handle(MouseEvent event) {

    }
}
