package fiuba.algo3.tp2.modelo.Piezas.Edificios;

import static fiuba.algo3.tp2.modelo.Campo.Constantes.*;

import fiuba.algo3.tp2.modelo.Estados.*;
import fiuba.algo3.tp2.modelo.Exception.*;
import fiuba.algo3.tp2.modelo.Juego.Jugador;
import fiuba.algo3.tp2.modelo.Piezas.*;
import fiuba.algo3.tp2.modelo.UnidadFactory.*;
import static fiuba.algo3.tp2.modelo.UnidadFactory.PiezaType.*;

public class Cuartel extends Edificio {


    public Cuartel() {
        this.costo = COSTO_CUARTEL;
        this.tamanio = TAMANIO_CUARTEL;
        this.estado = new EnConstruccion();
        this.vida = VIDA_MAXIMA_CUARTEL;
    }

    @Override
    public Unidad crearUnidad(PiezaType piezaType, Jugador oro) {

        if ((piezaType == PiezaType.UNIDAD_ESPADACHIN) || (piezaType == PiezaType.UNIDAD_ARQUERO)) {

            this.validarAcciones();
            this.accionesRealizadas++;
            return PiezaFactory.crearUnidad(piezaType);
        }
        else
            throw new InvalidUnidadTypeException();

    }

    @Override
    public void darVidaPorReparacion() {
        this.vida = vida + VIDA_REPARACION;
    }

    @Override
    public PiezaType obtenerType() {
        return EDIFICIO_CUARTEL;
    }

    @Override
    public double getTamanio() {
        return tamanio;
    }

    @Override
    public String obtenerNombre() {
        return "Cuartel";
    }

    @Override
    public int oroRecolectado() {
        return 0;
    }

}
