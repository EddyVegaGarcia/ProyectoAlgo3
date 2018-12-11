package fiuba.algo3.tp2.controlador;

import fiuba.algo3.tp2.modelo.Campo.Mapa;
import fiuba.algo3.tp2.modelo.Campo.Posicion;
import fiuba.algo3.tp2.modelo.Exception.PosicionDeCreacionInvalidaException;
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

        Unidad unaUnidad = ((Edificio)edificio).crearUnidad(unidadType);
        Posicion posicion = new Posicion((int)fila, (int)columna);

        try {
            this.validarDistanciaDeCreacion(posicion);
            ArrayList<Posicion> list = new ArrayList<>();
            list.add(posicion);

            mapa.colocarPieza(unaUnidad, posicion);
            Jugador jugador = juego.jugadorDeTurno();

            jugador.agregaPieza(unaUnidad);
            unaUnidad.agregarPosicion(list);

        }
        catch (PosicionDeCreacionInvalidaException e){

            etiquetaAlertas.setText("Colocacion de pieza fuera de rango 1 del edificio");
        }

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
