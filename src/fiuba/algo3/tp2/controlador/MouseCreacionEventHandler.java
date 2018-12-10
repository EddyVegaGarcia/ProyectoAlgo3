package fiuba.algo3.tp2.controlador;

import fiuba.algo3.tp2.modelo.Campo.Mapa;
import fiuba.algo3.tp2.modelo.Campo.Posicion;
import fiuba.algo3.tp2.modelo.Juego.Juego;
import fiuba.algo3.tp2.modelo.Juego.Jugador;
import fiuba.algo3.tp2.modelo.Piezas.Edificio;
import fiuba.algo3.tp2.modelo.Piezas.Unidad;
import fiuba.algo3.tp2.modelo.UnidadFactory.UnidadType;
import javafx.event.EventHandler;
import javafx.scene.canvas.Canvas;
import javafx.scene.input.MouseEvent;

import java.lang.reflect.Array;
import java.util.ArrayList;

import static fiuba.algo3.tp2.modelo.Campo.Constantes.COLUMNA_DEFAULT_MAPA;
import static fiuba.algo3.tp2.modelo.Campo.Constantes.FILA_DEFAULT_MAPA;

public class MouseCreacionEventHandler implements EventHandler<MouseEvent> {

    private Juego juego;
    private UnidadType unidadType;
    private Edificio edificio;
    private Mapa mapa;
    private JuegoView juegoView;
    private double height;
    private double widht;

    public MouseCreacionEventHandler(JuegoView juegoView, Juego juego, Canvas canvas, Edificio edificioCreador, UnidadType unidadType) {

        this.widht = canvas.getWidth();
        this.height = canvas.getHeight();
        this.juegoView = juegoView;
        this.mapa = juego.mapa();
        this.edificio = edificioCreador;
        this.unidadType = unidadType;
        this.juego = juego;
    }

    @Override
    public void handle(MouseEvent event) {
        double columna = event.getX()*COLUMNA_DEFAULT_MAPA/widht;
        double fila = event.getY()*FILA_DEFAULT_MAPA/height;

        Unidad unaUnidad = edificio.crearUnidad(unidadType);
        Posicion posicion = new Posicion((int)fila, (int)columna);
        ArrayList<Posicion> list = new ArrayList<Posicion>();
        list.add(posicion);
        mapa.colocarPieza(unaUnidad, posicion);
        Jugador jugador = juego.jugador1();
        Jugador jugador2 = juego.jugador2();
        //jugador.agregaPieza(unaUnidad);
        jugador2.agregaPieza(unaUnidad);
        unaUnidad.agregarPosicion(list);

        juegoView.actualizar();
    }
}
