package fiuba.algo3.tp2.modelo.Estados;

import fiuba.algo3.tp2.modelo.Interfaces.Construible;
import fiuba.algo3.tp2.modelo.Interfaces.EstadoDeAldeano;
import fiuba.algo3.tp2.modelo.Interfaces.Reparable;
import fiuba.algo3.tp2.modelo.Piezas.*;
import fiuba.algo3.tp2.modelo.Piezas.Unidades.*;
import fiuba.algo3.tp2.modelo.UnidadFactory.PiezaType;

import static fiuba.algo3.tp2.modelo.Campo.Constantes.*;

public class EstaTrabajando implements EstadoDeAldeano {

    @Override
    public boolean estaTrabajando() {
        return true;
    }

    @Override
    public EstadoDeAldeano construir(Edificio edificio, int turnosConstruccion) {
        if(turnosConstruccion == TURNOS_CONSTRUCCION_MAXIMO){
            ((Construible)edificio).finalizarConstruccion();
            return new EnReposo();
        }
        return this;
    }

    @Override
    public EstadoDeAldeano reparar(Edificio unEdificio, PiezaType unaPiezaType) {

        int vidaMaxima = 0;

        if(unaPiezaType == PiezaType.EDIFICIO_CASTILLO)
            vidaMaxima = VIDA_MAXIMA_CASTILLO;
        if(unaPiezaType == PiezaType.EDIFICIO_CUARTEL)
            vidaMaxima = VIDA_MAXIMA_CUARTEL;
        if(unaPiezaType == PiezaType.EDIFICIO_PLAZACENTRAL)
            vidaMaxima = VIDA_MAXIMA_PLAZACENTRAL;

        if(unEdificio.obtenerVida() == vidaMaxima){
            unEdificio.finalizarReparacion();
            return new EnReposo();
        }

        return this;

    }

    @Override
    public int oroRecolectado() {
        return 0;
    }
}
