package fiuba.algo3.tp2.controlador;

import fiuba.algo3.tp2.modelo.Exception.AccionUnicaRealizadaException;
import fiuba.algo3.tp2.modelo.Exception.EdificioConstruidoException;
import fiuba.algo3.tp2.modelo.Exception.EdificioEnConstruccionException;
import fiuba.algo3.tp2.modelo.Exception.PosicionDeCreacionInvalidaException;
import fiuba.algo3.tp2.modelo.Interfaces.Constructor;
import fiuba.algo3.tp2.modelo.Juego.Juego;
import fiuba.algo3.tp2.modelo.Piezas.Pieza;
import fiuba.algo3.tp2.modelo.UnidadFactory.PiezaType;
import javafx.event.EventHandler;
import javafx.scene.canvas.Canvas;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;

import static fiuba.algo3.tp2.modelo.Campo.Constantes.COLUMNA_DEFAULT_MAPA;
import static fiuba.algo3.tp2.modelo.Campo.Constantes.FILA_DEFAULT_MAPA;
import static fiuba.algo3.tp2.modelo.UnidadFactory.PiezaType.UNIDAD_ALDEANO;

public class MouseTrabajoEventHandler implements EventHandler<MouseEvent> {

    private Label etiquetaAlertas;
    private Canvas canvas;
    private Juego juego;
    private PiezaType piezaType;
    private Constructor piezaConstructora;
    private JuegoView juegoView;
    private double height;
    private double widht;

    public MouseTrabajoEventHandler(JuegoView juegoView, Juego juego, Canvas canvasCentral, Constructor piezaConstructora, PiezaType piezaType, Label etiquetaAlertas) {

        this.widht = canvasCentral.getWidth();
        this.height = canvasCentral.getHeight();
        this.juegoView = juegoView;
        this.piezaConstructora = piezaConstructora;
        this.piezaType = piezaType;
        this.juego = juego;
        this.canvas = canvasCentral;
        this.etiquetaAlertas = etiquetaAlertas;

    }

    @Override
    public void handle(MouseEvent event) {

        double columna = event.getX()*COLUMNA_DEFAULT_MAPA/widht;
        double fila = event.getY()*FILA_DEFAULT_MAPA/height;

        try {

            juego.construirEdificio( piezaConstructora, fila, columna, piezaType);

        }
        catch (EdificioConstruidoException e){
            etiquetaAlertas.setText("Edificio ya inagurado para trabajar");
        }
        catch(PosicionDeCreacionInvalidaException e){
            etiquetaAlertas.setText("No se ecuentra lo suficiente cerca para contruir/reparar el edificio");
        }
        catch (AccionUnicaRealizadaException e){
            etiquetaAlertas.setText("Cada piezaConstructora solo puede realizar una sola accion");
        }
        catch(EdificioEnConstruccionException e){
            etiquetaAlertas.setText("Edificio ya esta en proceso de construccion con otro constructor");
        }

        juegoView.actualizar();
        canvas.setOnMousePressed(new MouseEventHandler(juegoView, juego, canvas));

    }
}
