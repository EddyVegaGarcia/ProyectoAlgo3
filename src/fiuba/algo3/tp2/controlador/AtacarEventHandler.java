package fiuba.algo3.tp2.controlador;

import fiuba.algo3.tp2.modelo.Campo.Mapa;
import fiuba.algo3.tp2.modelo.Interfaces.Atacante;
import fiuba.algo3.tp2.modelo.Interfaces.Diseñador;
import fiuba.algo3.tp2.modelo.Juego.Juego;
import fiuba.algo3.tp2.modelo.UnidadFactory.PiezaType;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.canvas.Canvas;
import javafx.scene.control.Label;

public class AtacarEventHandler implements EventHandler<ActionEvent>{

    private Label etiquetaAlertas;
    private Mapa mapa;
    private JuegoView juegoView;
    private Juego juego;
    private Atacante piezaAtacante;
    private Canvas canvasCentral;
    private double height;
    private double widht;


    public AtacarEventHandler(JuegoView unJuegoView, Juego unJuego, Canvas unCanvasCentral, Atacante unaPiezaAtacante, Label etiquetaConsola) {

        this.mapa = unJuego.mapa();
        this.piezaAtacante = unaPiezaAtacante;
        this.juegoView = unJuegoView;
        this.canvasCentral = unCanvasCentral;
        this.juego = unJuego;
        this.etiquetaAlertas = etiquetaConsola;

        widht = unCanvasCentral.getWidth();
        height = unCanvasCentral.getHeight();

    }

    @Override
    public void handle(ActionEvent actionEvent) {

        canvasCentral.setOnMousePressed(new MouseAtaqueEventHandler(juegoView, juego, canvasCentral,
                piezaAtacante, etiquetaAlertas));

    }
}
