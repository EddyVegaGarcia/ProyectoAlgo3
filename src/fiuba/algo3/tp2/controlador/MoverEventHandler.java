package fiuba.algo3.tp2.controlador;

import fiuba.algo3.tp2.modelo.Campo.Mapa;
import fiuba.algo3.tp2.modelo.Exception.AccionUnicaRealizadaException;
import fiuba.algo3.tp2.modelo.Exception.UbicacionErroneaException;
import fiuba.algo3.tp2.modelo.Exception.UbicacionOcupadaException;
import fiuba.algo3.tp2.modelo.Interfaces.Direccion;
import fiuba.algo3.tp2.modelo.Juego.Juego;
import fiuba.algo3.tp2.modelo.Piezas.Pieza;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Alert;
import javafx.scene.control.Label;

public class MoverEventHandler implements EventHandler<ActionEvent> {

    private Label etiquetaAvisos;
    private JuegoView juegoView;
    private Pieza pieza;
    private Mapa mapa;
    private Direccion direccion;

    public MoverEventHandler(JuegoView unJuegoView, Juego unJuego, Pieza unaUnidad, Direccion unaDireccion, Label etiquetaConsola) {
        this.mapa = unJuego.mapa();
        this.pieza = unaUnidad;
        this.juegoView = unJuegoView;
        this.direccion = unaDireccion;
        this.etiquetaAvisos = etiquetaConsola;
    }

    @Override
    public void handle(ActionEvent event) {
        try {
            mapa.moverUnidad(pieza.obtenerPosicion(), direccion);
        }
        catch (UbicacionOcupadaException e){
            etiquetaAvisos.setText("La ubicacion a la que se quiere mover esta ocupada por otra pieza");
        }
        catch (UbicacionErroneaException e){
            etiquetaAvisos.setText("La ubicacion esta fuera del mapa");
        }
        catch (AccionUnicaRealizadaException e){
            etiquetaAvisos.setText("Cada pieza solo puede realizar una unica accion");
        }

        juegoView.actualizar();
    }
}
