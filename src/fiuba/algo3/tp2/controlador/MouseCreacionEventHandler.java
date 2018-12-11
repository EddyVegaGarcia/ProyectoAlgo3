package fiuba.algo3.tp2.controlador;

import fiuba.algo3.tp2.modelo.Campo.Mapa;
import fiuba.algo3.tp2.modelo.Campo.Posicion;
import fiuba.algo3.tp2.modelo.Exception.*;
import fiuba.algo3.tp2.modelo.Juego.Juego;
import fiuba.algo3.tp2.modelo.Juego.Jugador;
import fiuba.algo3.tp2.modelo.Piezas.Edificio;
import fiuba.algo3.tp2.modelo.Piezas.Pieza;
import fiuba.algo3.tp2.modelo.Piezas.Unidad;
import fiuba.algo3.tp2.modelo.UnidadFactory.UnidadType;
import javafx.event.EventHandler;
import javafx.scene.canvas.Canvas;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;

import java.util.ArrayList;

import static fiuba.algo3.tp2.modelo.Campo.Constantes.COLUMNA_DEFAULT_MAPA;
import static fiuba.algo3.tp2.modelo.Campo.Constantes.FILA_DEFAULT_MAPA;

public class MouseCreacionEventHandler implements EventHandler<MouseEvent> {

    private Label etiquetaAlertas;
    private Canvas canvas;
    private Juego juego;
    private UnidadType unidadType;
    private Pieza edificio;
    private Mapa mapa;
    private JuegoView juegoView;
    private double height;
    private double widht;

    public MouseCreacionEventHandler(JuegoView juegoView, Juego juego, Canvas canvas, Pieza edificioCreador, UnidadType unidadType, Label etiquetaAlertas) {

        this.widht = canvas.getWidth();
        this.height = canvas.getHeight();
        this.juegoView = juegoView;
        this.mapa = juego.mapa();
        this.edificio = edificioCreador;
        this.unidadType = unidadType;
        this.juego = juego;
        this.canvas = canvas;
        this.etiquetaAlertas = etiquetaAlertas;
    }

    @Override
    public void handle(MouseEvent event) {
        double columna = event.getX()*COLUMNA_DEFAULT_MAPA/widht;
        double fila = event.getY()*FILA_DEFAULT_MAPA/height;

        Unidad unaUnidad = null;

        try {
            unaUnidad = ((Edificio) edificio).crearUnidad(unidadType);
        }
        catch (AccionUnicaRealizadaException e){

            etiquetaAlertas.setText("Cada pieza solo puede realizar una unica accion");
            canvas.setOnMousePressed(new MouseEventHandler(juegoView, juego, canvas));
        }

        Posicion posicion = new Posicion((int)fila, (int)columna);

        try {
            this.validarDistanciaDeCreacion(posicion);
        }
        catch (PosicionDeCreacionInvalidaException e){

            etiquetaAlertas.setText("Colocacion de pieza fuera de rango 1 del edificio");
            canvas.setOnMousePressed(new MouseEventHandler(juegoView, juego, canvas));
        }


        ArrayList<Posicion> list = new ArrayList<>();
        list.add(posicion);

        mapa.colocarPieza(unaUnidad, posicion);
        Jugador jugador = juego.jugadorDeTurno();

        jugador.agregaPieza(unaUnidad);
        unaUnidad.agregarPosicion(list);

        juegoView.actualizar();
        canvas.setOnMousePressed(new MouseEventHandler(juegoView, juego, canvas));
    }

    private void validarDistanciaDeCreacion(Posicion posicion) {

        Posicion unaPosicion = edificio.obtenerPosicion();


        if( !posicion.validacionPosicionValida(unaPosicion, edificio.obtenerTamanio())) {

            throw new PosicionDeCreacionInvalidaException();
        }
    }
}
