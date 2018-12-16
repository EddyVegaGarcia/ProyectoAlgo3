package fiuba.algo3.tp2.modelo.Estados;

import fiuba.algo3.tp2.modelo.Exception.EstaReparandoException;
import fiuba.algo3.tp2.modelo.Interfaces.Colocador;
import fiuba.algo3.tp2.modelo.Interfaces.EstadoDeAldeano;
import fiuba.algo3.tp2.modelo.Interfaces.Reparador;
import fiuba.algo3.tp2.modelo.Piezas.Edificio;
import fiuba.algo3.tp2.modelo.UnidadFactory.PiezaType;

import static fiuba.algo3.tp2.modelo.Constantes.*;

public class EstaReparando implements EstadoDeAldeano, Reparador, Colocador {

    @Override
    public boolean estaReparando() {
        return true;
    }

    @Override
    public boolean estaTrabajando() {
        return false;
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
    public EstadoDeAldeano construir(Edificio edificio, int turnosConstruccion) {
        throw new EstaReparandoException();
    }

    @Override
    public int oroRecolectado() {
        return 0;
    }

}
