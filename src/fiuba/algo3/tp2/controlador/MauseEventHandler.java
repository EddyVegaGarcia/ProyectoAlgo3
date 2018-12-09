package fiuba.algo3.tp2.controlador;

import fiuba.algo3.tp2.modelo.Campo.Mapa;
import fiuba.algo3.tp2.modelo.Campo.Posicion;
import fiuba.algo3.tp2.modelo.Juego.Juego;
import fiuba.algo3.tp2.modelo.Piezas.Pieza;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.scene.canvas.Canvas;
import javafx.scene.input.MouseEvent;

import static fiuba.algo3.tp2.modelo.Campo.Constantes.COLUMNA_DEFAULT_MAPA;
import static fiuba.algo3.tp2.modelo.Campo.Constantes.FILA_DEFAULT_MAPA;

public class MauseEventHandler implements EventHandler<MouseEvent> {

    private Mapa mapa;
    private JuegoView juegoView;
    private double height;
    private double widht;

    public MauseEventHandler(JuegoView juegoView, Juego juego, Canvas canvas) {
        widht = canvas.getWidth();
        height = canvas.getHeight();

        this.juegoView = juegoView;

        mapa = juego.mapa();
    }

    @Override
    public void handle(MouseEvent event) {

        //paso de las coordenadas de la vista a las coordenadas del modelo
        double x = event.getX()*COLUMNA_DEFAULT_MAPA/widht;
        double y = event.getY()*FILA_DEFAULT_MAPA/height;

        Pieza pieza = mapa.recuperarPieza(new Posicion((int)y,(int)x));

        if( pieza != null ){
            pieza.queTipoSos(this);
        }
    }

    public void castillo(){
        juegoView.vaciarOpcionesDePieza();
        juegoView.activarBotoneraDeCastillo();
    }

    public void arquero() {
        juegoView.vaciarOpcionesDePieza();
        juegoView.activarBotoneraDeArquero();
    }

    public void armaAsedio() {
        juegoView.vaciarOpcionesDePieza();
        juegoView.activarBotoneraDeArmaAsedio();
    }

    public void aldeano() {
        juegoView.vaciarOpcionesDePieza();
        juegoView.activarBotoneraAldeano();
    }

    public void espadachin() {
    }

    public void cuartel() {
    }

    public void plaza() {
        juegoView.vaciarOpcionesDePieza();
        juegoView.activarBotoneraPlaza();
    }
}
