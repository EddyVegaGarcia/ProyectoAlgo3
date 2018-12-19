package fiuba.algo3.tp2.modelo.Estados;

import fiuba.algo3.tp2.modelo.Exception.EstaReparandoException;
import fiuba.algo3.tp2.modelo.Interfaces.Colocador;
import fiuba.algo3.tp2.modelo.Interfaces.EstadoDeAldeano;
import fiuba.algo3.tp2.modelo.Interfaces.Reparador;
import fiuba.algo3.tp2.modelo.Piezas.Edificio;
import fiuba.algo3.tp2.modelo.Piezas.Unidades.Aldeano;
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

        if( unEdificio.estasReparado() )
            return new EnReposo();

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

    @Override
    public void seguirRalizandoAccion(Aldeano aldeano) {

        aldeano.seguirReparando();

    }
}
