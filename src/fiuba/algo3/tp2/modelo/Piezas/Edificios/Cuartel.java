package fiuba.algo3.tp2.modelo.Piezas.Edificios;

import static fiuba.algo3.tp2.modelo.Campo.Constantes.*;

import fiuba.algo3.tp2.modelo.Estados.*;
import fiuba.algo3.tp2.modelo.Exception.*;
import fiuba.algo3.tp2.modelo.Interfaces.Creador;
import fiuba.algo3.tp2.modelo.Juego.Jugador;
import fiuba.algo3.tp2.modelo.Piezas.*;
import fiuba.algo3.tp2.modelo.UnidadFactory.*;
import static fiuba.algo3.tp2.modelo.UnidadFactory.PiezaType.*;

public class Cuartel extends Edificio implements Creador {


    public Cuartel() {
        this.costo = COSTO_CUARTEL;
        this.tamanio = TAMANIO_CUARTEL;
        this.estado = new EnConstruccion();
        this.vida = VIDA_MAXIMA_CUARTEL;
    }



    @Override
    public void validarOroSufiente(int cantidadOroActual) {

        if( cantidadOroActual < COSTO_ARMADEASEDIO )
            throw new OroInsuficienteException();

    }

    @Override
    public Unidad crearUnidad(PiezaType piezaType, Jugador unJugador) {

        this.validarOroSufiente(unJugador.oro);

        if ((piezaType == UNIDAD_ESPADACHIN) || (piezaType == UNIDAD_ARQUERO)) {

            this.validarAcciones();
            this.accionesRealizadas++;

            if(piezaType == UNIDAD_ESPADACHIN)
                unJugador.pagar(COSTO_ESPADACHIN);
            if(piezaType == UNIDAD_ARQUERO)
                unJugador.pagar(COSTO_ARQUERO);

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
