package fiuba.algo3.tp2.controlador;

import fiuba.algo3.tp2.modelo.Campo.Mapa;
import fiuba.algo3.tp2.modelo.Campo.Posicion;
import fiuba.algo3.tp2.modelo.Exception.AccionUnicaRealizadaException;
import fiuba.algo3.tp2.modelo.Exception.*;
import fiuba.algo3.tp2.modelo.Interfaces.Constructor;
import fiuba.algo3.tp2.modelo.Juego.Juego;
import javafx.event.EventHandler;
import javafx.scene.canvas.Canvas;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;

import static fiuba.algo3.tp2.modelo.Campo.Constantes.COLUMNA_DEFAULT_MAPA;
import static fiuba.algo3.tp2.modelo.Campo.Constantes.FILA_DEFAULT_MAPA;

public class MouseReparacionEventHandler implements EventHandler<MouseEvent> {

    private Label etiquetaAlertas;
    private Canvas canvas;
    private Juego juego;
    private Constructor piezaReparadora;
    private JuegoView juegoView;
    private double height;
    private double widht;
    private Mapa mapa;

    public MouseReparacionEventHandler(JuegoView juegoView, Juego juego, Canvas canvasCentral, Constructor unaPiezaReparadora, Label etiquetaAlertas) {

        this.widht = canvasCentral.getWidth();
        this.height = canvasCentral.getHeight();
        this.juegoView = juegoView;
        this.piezaReparadora = unaPiezaReparadora;
        this.juego = juego;
        this.mapa = juego.mapa();
        this.canvas = canvasCentral;
        this.etiquetaAlertas = etiquetaAlertas;

    }

    @Override
    public void handle(MouseEvent event) {


        double columna = event.getX()*COLUMNA_DEFAULT_MAPA/widht;
        double fila = event.getY()*FILA_DEFAULT_MAPA/height;

        Posicion posicion = new Posicion((int)fila,(int)columna);


        try {
            juego.reparar(posicion, piezaReparadora);
        }
        catch (AccionUnicaRealizadaException e){

            etiquetaAlertas.setText("Cada piezaAtacante solo puede crear una sola pieza.");
        }
        catch (PosicionReparadaSinResultadosException e){
            etiquetaAlertas.setText("Ubicacion reparada sin resultados.");
        }
        catch (PiezaReaparadaPertenecienteAlEnemigoException e){
            etiquetaAlertas.setText("La pieza atacada pertence al jugador enemigo.");
        }
        catch (PiezaNoReparableNoConstruibleException e){
            etiquetaAlertas.setText("La pieza reparadora no puede reparar a unidades.");
        }
        catch (ReparacionAunSinProcesoException e){
            etiquetaAlertas.setText("No se hizo el proceso de reparacion al edificio.");
        }
        catch(EdificioYaReparadoException e){
            etiquetaAlertas.setText("No se puede reparar ya que cuenta con la vida maxima");
        }



    }
}
