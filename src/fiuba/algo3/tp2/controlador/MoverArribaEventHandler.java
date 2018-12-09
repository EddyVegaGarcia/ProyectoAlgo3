package fiuba.algo3.tp2.controlador;

import fiuba.algo3.tp2.modelo.Campo.Mapa;
import fiuba.algo3.tp2.modelo.Campo.Posicion;
import fiuba.algo3.tp2.modelo.Direcciones.DireccionArriba;
import fiuba.algo3.tp2.modelo.Direcciones.DireccionIzquierda;
import fiuba.algo3.tp2.modelo.Exception.UbicacionErroneaException;
import fiuba.algo3.tp2.modelo.Exception.UbicacionOcupadaException;
import fiuba.algo3.tp2.modelo.Juego.Juego;
import fiuba.algo3.tp2.modelo.Piezas.Pieza;
import fiuba.algo3.tp2.modelo.Piezas.Unidad;
import fiuba.algo3.tp2.modelo.Piezas.Unidades.Aldeano;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;

public class MoverArribaEventHandler implements EventHandler<ActionEvent> {
    private JuegoView juegoView;
    private Unidad pieza;
    private Mapa mapa;

    public MoverArribaEventHandler(JuegoView juegoView, Juego juego, Unidad unidad) {
        mapa = juego.mapa();
        this.pieza = unidad;
        this.juegoView = juegoView;
    }

    @Override
    public void handle(ActionEvent event) {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Alerta");

        try {
            mapa.moverUnidad(pieza.obtenerPosicion(), new DireccionArriba());
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
