package fiuba.algo3.tp2.controlador;

import fiuba.algo3.tp2.modelo.Campo.Mapa;
import fiuba.algo3.tp2.modelo.Campo.Posicion;
import fiuba.algo3.tp2.modelo.Exception.*;
import fiuba.algo3.tp2.modelo.Juego.Juego;
import fiuba.algo3.tp2.modelo.Juego.Jugador;
import fiuba.algo3.tp2.modelo.Piezas.Edificio;
import fiuba.algo3.tp2.modelo.Piezas.Pieza;
import fiuba.algo3.tp2.modelo.Piezas.Unidad;
import fiuba.algo3.tp2.modelo.UnidadFactory.PiezaType;
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
    private PiezaType piezaType;
    private Pieza edificio;
    private Mapa mapa;
    private JuegoView juegoView;
    private double height;
    private double widht;

    public MouseCreacionEventHandler(JuegoView juegoView, Juego juego, Canvas canvas, Pieza edificioCreador, PiezaType piezaType, Label etiquetaAlertas) {

        this.widht = canvas.getWidth();
        this.height = canvas.getHeight();
        this.juegoView = juegoView;
        this.mapa = juego.mapa();
        this.edificio = edificioCreador;
        this.piezaType = piezaType;
        this.juego = juego;
        this.canvas = canvas;
        this.etiquetaAlertas = etiquetaAlertas;
    }

    @Override
    public void handle(MouseEvent event) {
        double columna = event.getX()*COLUMNA_DEFAULT_MAPA/widht;
        double fila = event.getY()*FILA_DEFAULT_MAPA/height;

        try {
            juego.crearUnidad((Edificio)edificio, fila, columna, piezaType);
            //juegoView.actualizar();
        }
        catch (AccionUnicaRealizadaException e){

            etiquetaAlertas.setText("Cada edificio solo puede crear una sola pieza");
            //canvas.setOnMousePressed(new MouseEventHandler(juegoView, juego, canvas));
        }
        catch (PosicionDeCreacionInvalidaException e){

            etiquetaAlertas.setText("Ubicacion invalida para crear.");
            //canvas.setOnMousePressed(new MouseEventHandler(juegoView, juego, canvas));
        }
        catch (OroInsuficienteException e){
            etiquetaAlertas.setText("No tienes suficiente oro.");
          //  canvas.setOnMousePressed(new MouseEventHandler(juegoView, juego, canvas));
        }
        catch (UbicacionOcupadaException e){
            etiquetaAlertas.setText("La ubicacion donde se quiere crear, esta ocupada.");
          //  canvas.setOnMousePressed(new MouseEventHandler(juegoView, juego, canvas));
        }
        juegoView.actualizar();
        canvas.setOnMousePressed(new MouseEventHandler(juegoView, juego, canvas));

    }
}
