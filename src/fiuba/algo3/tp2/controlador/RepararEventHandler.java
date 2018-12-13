package fiuba.algo3.tp2.controlador;

import fiuba.algo3.tp2.modelo.Campo.Mapa;
import fiuba.algo3.tp2.modelo.Interfaces.Atacante;
import fiuba.algo3.tp2.modelo.Interfaces.Constructor;
import fiuba.algo3.tp2.modelo.Juego.Juego;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.canvas.Canvas;
import javafx.scene.control.Label;

public class RepararEventHandler implements EventHandler<ActionEvent> {

    private Label etiquetaAlertas;
    private Mapa mapa;
    private JuegoView juegoView;
    private Juego juego;
    private Constructor piezaReparadora;
    private Canvas canvasCentral;
    private double height;
    private double widht;

    public RepararEventHandler(JuegoView unJuegoView, Juego unJuego, Canvas unCanvasCentral, Constructor unaPiezaReparadora, Label etiquetaConsola) {

        this.mapa = unJuego.mapa();
        this.piezaReparadora = unaPiezaReparadora;
        this.juegoView = unJuegoView;
        this.canvasCentral = unCanvasCentral;
        this.juego = unJuego;
        this.etiquetaAlertas = etiquetaConsola;

        widht = unCanvasCentral.getWidth();
        height = unCanvasCentral.getHeight();

    }

    @Override
    public void handle(ActionEvent actionEvent) {

        canvasCentral.setOnMousePressed(new MouseReparacionEventHandler(juegoView, juego, canvasCentral,
                piezaReparadora, etiquetaAlertas));

    }
}
