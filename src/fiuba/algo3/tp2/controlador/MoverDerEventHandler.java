package fiuba.algo3.tp2.controlador;

import fiuba.algo3.tp2.modelo.Campo.Mapa;
import fiuba.algo3.tp2.modelo.Campo.Posicion;
import fiuba.algo3.tp2.modelo.Direcciones.DireccionDerecha;
import fiuba.algo3.tp2.modelo.Direcciones.DireccionIzquierda;
import fiuba.algo3.tp2.modelo.Exception.UbicacionErroneaException;
import fiuba.algo3.tp2.modelo.Exception.UbicacionOcupadaException;
import fiuba.algo3.tp2.modelo.Juego.Juego;
import fiuba.algo3.tp2.modelo.Piezas.Unidad;
import fiuba.algo3.tp2.modelo.Piezas.Unidades.Aldeano;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Alert;

public class MoverDerEventHandler implements EventHandler<ActionEvent> {

    private JuegoView juegoView;
    private Unidad pieza;
    private Mapa mapa;

    public MoverDerEventHandler(JuegoView juegoView, Juego juego, Unidad unidad) {
        mapa = juego.mapa();
        this.pieza = unidad;
        this.juegoView = juegoView;
    }

    @Override
    public void handle(ActionEvent event) {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Alerta");

        try {
            mapa.moverUnidad(pieza.obtenerPosicion(), new DireccionDerecha());
        }
        catch (UbicacionOcupadaException e){
            alert.setHeaderText("Ubicacion Ocupada");
            alert.show();
        }
        catch (UbicacionErroneaException e){
            alert.setHeaderText("Ubicacion Fuera del Mapa");
            alert.show();
        }
        juegoView.actualizar();
    }
}
