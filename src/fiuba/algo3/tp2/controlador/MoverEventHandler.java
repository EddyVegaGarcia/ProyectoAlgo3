package fiuba.algo3.tp2.controlador;

import fiuba.algo3.tp2.modelo.Campo.Mapa;
import fiuba.algo3.tp2.modelo.Exception.AccionUnicaRealizadaException;
import fiuba.algo3.tp2.modelo.Exception.UbicacionErroneaException;
import fiuba.algo3.tp2.modelo.Exception.UbicacionOcupadaException;
import fiuba.algo3.tp2.modelo.Interfaces.Direccion;
import fiuba.algo3.tp2.modelo.Juego.Juego;
import fiuba.algo3.tp2.modelo.Piezas.Unidad;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Alert;

public class MoverEventHandler implements EventHandler<ActionEvent> {

    private JuegoView juegoView;
    private Unidad pieza;
    private Mapa mapa;
    private Direccion direccion;

    public MoverEventHandler(JuegoView unJuegoView, Juego unJuego, Unidad unaUnidad, Direccion unaDireccion) {
        this.mapa = unJuego.mapa();
        this.pieza = unaUnidad;
        this.juegoView = unJuegoView;
        this.direccion = unaDireccion;
    }

    @Override
    public void handle(ActionEvent event) {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Alerta");

        try {
            mapa.moverUnidad(pieza.obtenerPosicion(), direccion);
        }
        catch (UbicacionOcupadaException e){
            alert.setHeaderText("Ubicacion Ocupada");
            alert.show();
        }
        catch (UbicacionErroneaException e){
            alert.setHeaderText("Ubicacion Fuera del Mapa");
            alert.show();
        }
        catch (AccionUnicaRealizadaException e){
            alert.setHeaderText("Unica accion jugada permitida ya realizada");
            alert.show();
        }

        juegoView.actualizar();
    }
}
