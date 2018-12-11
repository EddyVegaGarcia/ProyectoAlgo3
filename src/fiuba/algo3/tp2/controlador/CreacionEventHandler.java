package fiuba.algo3.tp2.controlador;

import fiuba.algo3.tp2.modelo.Campo.Mapa;
import fiuba.algo3.tp2.modelo.Campo.Posicion;
import fiuba.algo3.tp2.modelo.Exception.PosicionDeCreacionInvalidaException;
import fiuba.algo3.tp2.modelo.Juego.Juego;

import fiuba.algo3.tp2.modelo.Piezas.Pieza;
import fiuba.algo3.tp2.modelo.UnidadFactory.UnidadType;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.canvas.Canvas;
import javafx.scene.control.Label;


public class CreacionEventHandler implements EventHandler<ActionEvent> {

    private Label etiquetaAlertas;
    private Mapa mapa;
    private JuegoView juegoView;
    private Juego juego;
    private Pieza edificioCreador;
    private Canvas canvasCentral;
    private UbicarPiezas ubicarPiezas;
    private double height;
    private double widht;
    private UnidadType unidadType;
    private Posicion nuevaPosicionCreada;

    public CreacionEventHandler(JuegoView unJuegoView, Juego unJuego, Canvas unCanvasCentral,
                                Pieza unaPiezaCreadora, UnidadType unaUnidadType, Label etiquetaConsola) {

        this.mapa = unJuego.mapa();
        this.edificioCreador = unaPiezaCreadora;
        this.juegoView = unJuegoView;
        this.canvasCentral = unCanvasCentral;
        this.unidadType = unaUnidadType;
        this.juego = unJuego;
        this.etiquetaAlertas = etiquetaConsola;

        widht = unCanvasCentral.getWidth();
        height = unCanvasCentral.getHeight();

    }

    @Override
    public void handle(ActionEvent event) {

        canvasCentral.setOnMousePressed(new MouseCreacionEventHandler(juegoView, juego, canvasCentral,
                    edificioCreador, unidadType, etiquetaAlertas));


    }

/*
    @Override
    public void handle(MouseEvent event) {

        double x = event.getX()*COLUMNA_DEFAULT_MAPA/widht;
        double y = event.getY()*FILA_DEFAULT_MAPA/height;

        nuevaPosicionCreada = new Posicion((int)y,(int)x);

        Pieza pieza = mapa.recuperarPieza(nuevaPosicionCreada);

        if( pieza == null ){
            this.validarDistanciaDeCreacion(nuevaPosicionCreada);
        }

    }
*/
}
