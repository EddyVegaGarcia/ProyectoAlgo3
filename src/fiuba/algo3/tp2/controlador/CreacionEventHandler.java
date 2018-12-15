package fiuba.algo3.tp2.controlador;

import fiuba.algo3.tp2.modelo.Campo.Mapa;
import fiuba.algo3.tp2.modelo.Interfaces.Diseñador;
import fiuba.algo3.tp2.modelo.Juego.Juego;

import fiuba.algo3.tp2.modelo.UnidadFactory.PiezaType;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.canvas.Canvas;
import javafx.scene.control.Label;


public class CreacionEventHandler implements EventHandler<ActionEvent> {

    private Label etiquetaAlertas;
    private Mapa mapa;
    private JuegoView juegoView;
    private Juego juego;
    private Diseñador piezaConstructora;
    private Canvas canvasCentral;
    private double height;
    private double widht;
    private PiezaType piezaType;

    public CreacionEventHandler(JuegoView unJuegoView, Juego unJuego, Canvas unCanvasCentral,
                                Diseñador unaPiezaCreadora, PiezaType unaPiezaType, Label etiquetaConsola) {

        this.mapa = unJuego.mapa();
        this.piezaConstructora = unaPiezaCreadora;
        this.juegoView = unJuegoView;
        this.canvasCentral = unCanvasCentral;
        this.piezaType = unaPiezaType;
        this.juego = unJuego;
        this.etiquetaAlertas = etiquetaConsola;

        widht = unCanvasCentral.getWidth();
        height = unCanvasCentral.getHeight();

    }

    @Override
    public void handle(ActionEvent event) {

        canvasCentral.setOnMousePressed(new MouseCreacionEventHandler(juegoView, juego, canvasCentral,
                piezaConstructora, piezaType, etiquetaAlertas));


    }
}
