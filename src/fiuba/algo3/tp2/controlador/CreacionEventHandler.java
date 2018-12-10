package fiuba.algo3.tp2.controlador;

import fiuba.algo3.tp2.modelo.Campo.Mapa;
import fiuba.algo3.tp2.modelo.Campo.Posicion;
import fiuba.algo3.tp2.modelo.Exception.PosicionDeCreacionInvalidaException;
import fiuba.algo3.tp2.modelo.Juego.Juego;
import fiuba.algo3.tp2.modelo.Piezas.Edificio;
import fiuba.algo3.tp2.modelo.Piezas.Edificios.*;

import fiuba.algo3.tp2.modelo.Piezas.Pieza;
import fiuba.algo3.tp2.modelo.Piezas.Unidad;
import fiuba.algo3.tp2.modelo.UnidadFactory.UnidadType;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.canvas.Canvas;
import javafx.scene.input.MouseEvent;

import static fiuba.algo3.tp2.modelo.Campo.Constantes.COLUMNA_DEFAULT_MAPA;
import static fiuba.algo3.tp2.modelo.Campo.Constantes.FILA_DEFAULT_MAPA;
import static fiuba.algo3.tp2.modelo.UnidadFactory.UnidadType.*;


public class CreacionEventHandler implements EventHandler<ActionEvent> {

    private Mapa mapa;
    private JuegoView juegoView;
    private Juego juego;
    private Edificio edificioCreador;
    private Canvas canvasCentral;
    private UbicarPiezas ubicarPiezas;
    private double height;
    private double widht;
    private UnidadType unidadType;
    private Posicion nuevaPosicionCreada;

    public CreacionEventHandler(JuegoView unJuegoView, Juego unJuego, Canvas unCanvasCentral, Castillo unCastillo, UnidadType unaUnidadType) {

        this.mapa = unJuego.mapa();
        this.edificioCreador = unCastillo;
        this.juegoView = unJuegoView;
        this.canvasCentral = unCanvasCentral;
        this.ubicarPiezas = new UbicarPiezas(unCanvasCentral);
        this.unidadType = unaUnidadType;
        this.juego = unJuego;

        widht = unCanvasCentral.getWidth();
        height = unCanvasCentral.getHeight();

    }

    @Override
    public void handle(ActionEvent actionEvent) {

        canvasCentral.setOnMousePressed(new MouseCreacionEventHandler(juegoView, juego, canvasCentral, );
        Unidad unaUnidad = edificioCreador.crearUnidad(unidadType);
        this.generarPosicionClikeada();
        unaUnidad.cambiarPosicion(nuevaPosicionCreada);
        this.ubicarPiezas.UbicarArmasDeAsedios(unaUnidad);

    }

    private void generarPosicionClikeada() {

        ActionEvent accion = new ActionEvent();

        this.handle(accion);

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
    private void validarDistanciaDeCreacion(Posicion unaPosicion) {

        Posicion actual = edificioCreador.obtenerPosicion();

        if( !( (!actual.estaContenidaEn(unaPosicion, edificioCreador.obtenerTamanio()) )
            && ( ((unaPosicion.getFila() - actual.getFila()) == -1) || ((unaPosicion.getFila() - actual.getFila())  == 4))
            && ( ((unaPosicion.getColumna() - actual.getColumna()) == -1) || ((unaPosicion.getColumna() - actual.getColumna()) == 4)) ))
            throw new PosicionDeCreacionInvalidaException();
    }
}
