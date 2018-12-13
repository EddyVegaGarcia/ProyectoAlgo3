package fiuba.algo3.tp2.controlador;

import fiuba.algo3.tp2.modelo.Campo.Mapa;
import fiuba.algo3.tp2.modelo.Exception.MontarIncogruenciaException;
import fiuba.algo3.tp2.modelo.Interfaces.Montable;
import fiuba.algo3.tp2.modelo.Juego.Juego;
import fiuba.algo3.tp2.modelo.UnidadFactory.PiezaType;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.canvas.Canvas;
import javafx.scene.control.Label;

public class MontarEventHandler implements EventHandler<ActionEvent> {

    private Label etiquetaAlertas;
    private Mapa mapa;
    private JuegoView juegoView;
    private Juego juego;
    private Montable piezaMontable;
    private Canvas canvasCentral;
    private double height;
    private double widht;
    private PiezaType piezaType;

    public MontarEventHandler(JuegoView unJuegoView, Juego unJuego, Canvas unCanvasCentral, Montable unaPiezaMontable, PiezaType unaPiezaType, Label etiquetaConsola) {

        this.mapa = unJuego.mapa();
        this.piezaMontable = unaPiezaMontable;
        this.juegoView = unJuegoView;
        this.canvasCentral = unCanvasCentral;
        this.piezaType = unaPiezaType;
        this.juego = unJuego;
        this.etiquetaAlertas = etiquetaConsola;

        widht = unCanvasCentral.getWidth();
        height = unCanvasCentral.getHeight();

    }

    @Override
    public void handle(ActionEvent actionEvent) {

        try {
            piezaMontable.montar();
        }
        catch (MontarIncogruenciaException e){
            etiquetaAlertas.setText("La pieza montable ya está montada");
        }


        juegoView.actualizar();

    }
}
