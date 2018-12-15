package fiuba.algo3.tp2.controlador;

import fiuba.algo3.tp2.modelo.Campo.Mapa;
import fiuba.algo3.tp2.modelo.Campo.Posicion;
import fiuba.algo3.tp2.modelo.Exception.*;
import fiuba.algo3.tp2.modelo.Interfaces.Atacante;
import fiuba.algo3.tp2.modelo.Juego.Juego;
import javafx.event.EventHandler;
import javafx.scene.canvas.Canvas;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

import static fiuba.algo3.tp2.modelo.Constantes.COLUMNA_DEFAULT_MAPA;
import static fiuba.algo3.tp2.modelo.Constantes.FILA_DEFAULT_MAPA;

public class MouseAtaqueEventHandler implements EventHandler<MouseEvent> {

    private Stage stage;
    private Label etiquetaAlertas;
    private Canvas canvas;
    private Juego juego;
    private Atacante piezaAtacante;
    private JuegoView juegoView;
    private double height;
    private double widht;
    private Mapa mapa;

    public MouseAtaqueEventHandler(JuegoView juegoView, Juego juego, Canvas canvasCentral, Atacante piezaAtacante, Label etiquetaAlertas, Stage stage) {

        this.widht = canvasCentral.getWidth();
        this.height = canvasCentral.getHeight();
        this.juegoView = juegoView;
        this.piezaAtacante = piezaAtacante;
        this.juego = juego;
        this.mapa = juego.mapa();
        this.canvas = canvasCentral;
        this.etiquetaAlertas = etiquetaAlertas;
        this.stage = stage;

    }

    @Override
    public void handle(MouseEvent event) {

        double columna = event.getX()*COLUMNA_DEFAULT_MAPA/widht;
        double fila = event.getY()*FILA_DEFAULT_MAPA/height;

        Posicion posicion = new Posicion((int)fila,(int)columna);

        try {

            juego.atacar(posicion,piezaAtacante);

        }
        catch (AccionUnicaRealizadaException e){
            etiquetaAlertas.setText("Cada piezaAtacante solo puede crear una sola pieza.");
        }
        catch (PiezaDestruidaException e){
            juego.actualizarPiezas();
            mapa.actualizarPiezas();
            etiquetaAlertas.setText("Pieza victoriosamente destruida.");
        }
        catch (PosicionAtacadaSinResultadosException e){
            etiquetaAlertas.setText("Ubicacion atacada sin resultados.");
        }
        catch (PiezaAtacadaNoValidaException e){
            etiquetaAlertas.setText("La pieza atacada no es valida para el atacante.");
        }
        catch (ArmaDeAsedioDesmontadaSinAtaqueException e){
            etiquetaAlertas.setText("El atacante no puede finalizarReparacion por no estar montada.");
        }
        catch (PiezaAtacadaNoEstaEnRangoDeAtaqueExeception e){
            etiquetaAlertas.setText("La pieza atacada no está en el rango de ataque del atacante.");
        }
        catch (PiezaAtacadaPertenecienteException e){
            etiquetaAlertas.setText("La pieza atacada pertence al jugador.");
        }

        if(juego.finalizado()) {
            FinalizadoView finalizadoView = new FinalizadoView(stage, juego);
        }

        juegoView.actualizar();
        canvas.setOnMousePressed(new MouseEventHandler(juegoView, juego, canvas));

    }
}
