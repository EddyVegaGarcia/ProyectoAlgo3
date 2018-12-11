package fiuba.algo3.tp2.controlador;

import fiuba.algo3.tp2.modelo.Campo.Mapa;
import fiuba.algo3.tp2.modelo.Campo.Posicion;
import fiuba.algo3.tp2.modelo.Juego.Juego;
import fiuba.algo3.tp2.modelo.Piezas.Edificios.Castillo;
import fiuba.algo3.tp2.modelo.Piezas.Edificios.PlazaCentral;
import fiuba.algo3.tp2.modelo.Piezas.Pieza;
import fiuba.algo3.tp2.modelo.Piezas.Unidades.Aldeano;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.scene.canvas.Canvas;
import javafx.scene.input.MouseEvent;

import static fiuba.algo3.tp2.modelo.Campo.Constantes.COLUMNA_DEFAULT_MAPA;
import static fiuba.algo3.tp2.modelo.Campo.Constantes.FILA_DEFAULT_MAPA;

public class MouseEventHandler implements EventHandler<MouseEvent> {

    private Mapa mapa;
    private JuegoView juegoView;
    private double height;
    private double widht;

    public MouseEventHandler(JuegoView juegoView, Juego juego, Canvas canvas) {

        this.widht = canvas.getWidth();
        this.height = canvas.getHeight();
        this.juegoView = juegoView;
        this.mapa = juego.mapa();

    }

    @Override
    public void handle(MouseEvent event) {

        //paso de las coordenadas de la vista a las coordenadas del modelo
        double x = event.getX()*COLUMNA_DEFAULT_MAPA/widht;
        double y = event.getY()*FILA_DEFAULT_MAPA/height;

        Pieza pieza = mapa.recuperarPieza(new Posicion((int)y,(int)x));

        if( pieza != null ){
            juegoView.crearBotoneraParaPieza(pieza);
        }
    }
}
