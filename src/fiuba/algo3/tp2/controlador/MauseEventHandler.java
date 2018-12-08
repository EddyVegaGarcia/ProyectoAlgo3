package fiuba.algo3.tp2.controlador;

import fiuba.algo3.tp2.modelo.Juego.Juego;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.scene.canvas.Canvas;
import javafx.scene.input.MouseEvent;

import static fiuba.algo3.tp2.modelo.Campo.Constantes.COLUMNA_DEFAULT_MAPA;
import static fiuba.algo3.tp2.modelo.Campo.Constantes.FILA_DEFAULT_MAPA;

public class MauseEventHandler implements EventHandler<MouseEvent> {

    private JuegoView juegoView;
    private double height;
    private double widht;

    public MauseEventHandler(JuegoView juegoView, Juego juego, Canvas canvas) {
        widht = canvas.getWidth();
        height = canvas.getHeight();

        this.juegoView = juegoView;
    }

    @Override
    public void handle(MouseEvent event) {

        //paso de las coordenadas de la vista a las coordenadas del modelo
        double x = event.getX()*COLUMNA_DEFAULT_MAPA/widht;
        double y = event.getY()*FILA_DEFAULT_MAPA/height;

        if( (x <= 21 && x >= 17) && (y >= 1 && y <= 5) ){
            juegoView.vaciarOpcionesDePieza();
            juegoView.activarBotoneraDeCastillo();
        }

        else{
            juegoView.vaciarOpcionesDePieza();
        }

    }
}
