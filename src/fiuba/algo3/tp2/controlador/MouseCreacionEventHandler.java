package fiuba.algo3.tp2.controlador;

import fiuba.algo3.tp2.modelo.Exception.*;
import fiuba.algo3.tp2.modelo.Interfaces.Diseñador;
import fiuba.algo3.tp2.modelo.Juego.Juego;
import fiuba.algo3.tp2.modelo.Piezas.Pieza;
import fiuba.algo3.tp2.modelo.UnidadFactory.PiezaType;
import javafx.event.EventHandler;
import javafx.scene.canvas.Canvas;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;

import static fiuba.algo3.tp2.modelo.Constantes.COLUMNA_DEFAULT_MAPA;
import static fiuba.algo3.tp2.modelo.Constantes.FILA_DEFAULT_MAPA;
import static fiuba.algo3.tp2.modelo.UnidadFactory.PiezaType.UNIDAD_ALDEANO;

public class MouseCreacionEventHandler implements EventHandler<MouseEvent> {

    private Label etiquetaAlertas;
    private Canvas canvas;
    private Juego juego;
    private PiezaType piezaType;
    private Diseñador piezaConstructora;
    private JuegoView juegoView;
    private double height;
    private double widht;

    public MouseCreacionEventHandler(JuegoView juegoView, Juego juego, Canvas canvas, Diseñador edificioCreador, PiezaType piezaType, Label etiquetaAlertas) {

        this.widht = canvas.getWidth();
        this.height = canvas.getHeight();
        this.juegoView = juegoView;
        this.piezaConstructora = edificioCreador;
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
            if(((Pieza)piezaConstructora).obtenerType().equals(UNIDAD_ALDEANO))
                juego.colocarEdificio( piezaConstructora, fila, columna, piezaType);
            else
                juego.colocarUnidad( piezaConstructora, fila, columna, piezaType);

        }
        catch (AccionUnicaRealizadaException e){

            etiquetaAlertas.setText("Cada piezaConstructora solo puede crear una sola pieza");
        }
        catch (PosicionDeCreacionInvalidaException e){

            etiquetaAlertas.setText("Ubicacion invalida para crear.");
        }
        catch (OroInsuficienteException e){
            etiquetaAlertas.setText("No tienes suficiente oro.");
        }
        catch (UbicacionOcupadaException e){
            etiquetaAlertas.setText("La ubicacion donde se quiere crear esta ocupada.");
        }
        catch (EdificioInexistenteException e){
            etiquetaAlertas.setText("El edificio no se encuentra en construccion");
        }
        catch (SobrepoblacionException e){
            etiquetaAlertas.setText("Población máxima alcanzada.");
        }

        juegoView.actualizar();
        canvas.setOnMousePressed(new MouseEventHandler(juegoView, juego, canvas));

    }
}
