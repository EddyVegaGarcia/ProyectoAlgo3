package fiuba.algo3.tp2.controlador;

import fiuba.algo3.tp2.modelo.Exception.*;
import fiuba.algo3.tp2.modelo.Interfaces.Constructor;
import fiuba.algo3.tp2.modelo.Juego.Juego;
import fiuba.algo3.tp2.modelo.UnidadFactory.PiezaType;
import javafx.event.EventHandler;
import javafx.scene.canvas.Canvas;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;

import static fiuba.algo3.tp2.modelo.Constantes.COLUMNA_DEFAULT_MAPA;
import static fiuba.algo3.tp2.modelo.Constantes.FILA_DEFAULT_MAPA;

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

            juego.construirEdificio( piezaConstructora, fila, columna);

        }
        catch (EdificioYaConstruidoException e){
            etiquetaAlertas.setText("Edificio ya inagurado para trabajar.");
        }
        catch(PosicionDeCreacionInvalidaException e){
            etiquetaAlertas.setText("No se ecuentra lo suficiente cerca para contruir el edificio.");
        }
        catch (AccionUnicaRealizadaException e){
            etiquetaAlertas.setText("La piezaConstructora se encuentra trabajando.");
        }
        catch(EdificioEnConstruccionException e){
            etiquetaAlertas.setText("Edificio ya esta en proceso de construccion con otro constructor.");
        }
        catch (PiezaNoReparableNoConstruibleException e){
            etiquetaAlertas.setText("La pieza no es construible.");
        }
        catch(EstaTrabajandoException e){
            etiquetaAlertas.setText("La pieza está realizando un trabajo no puede reparar.");
        }

        juegoView.actualizar();
        canvas.setOnMousePressed(new MouseEventHandler(juegoView, juego, canvas));

    }
}
