package fiuba.algo3.tp2.modelo.Estados;

import fiuba.algo3.tp2.modelo.Exception.EstaTrabajandoException;
import fiuba.algo3.tp2.modelo.Interfaces.Colocador;
import fiuba.algo3.tp2.modelo.Interfaces.Construible;
import fiuba.algo3.tp2.modelo.Interfaces.EstadoDeAldeano;
import fiuba.algo3.tp2.modelo.Interfaces.Reparador;
import fiuba.algo3.tp2.modelo.Piezas.*;
import fiuba.algo3.tp2.modelo.Piezas.Unidades.Aldeano;
import fiuba.algo3.tp2.modelo.UnidadFactory.PiezaType;

import static fiuba.algo3.tp2.modelo.Constantes.*;

public class EstaTrabajando implements EstadoDeAldeano, Colocador, Reparador {

    @Override
    public boolean estaTrabajando() {
        return true;
    }

    @Override
    public boolean estaReparando() {
        return false;
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
    public EstadoDeAldeano reparar(Edificio edificio, PiezaType unaPiezaType) {
        throw new EstaTrabajandoException();
    }

    @Override
    public int oroRecolectado() {
        return 0;
    }

    @Override
    public void seguirRalizandoAccion(Aldeano aldeano) {

        aldeano.seguirTrabajando();

    }
}
