package fiuba.algo3.tp2.modelo.Estados;

import fiuba.algo3.tp2.modelo.Interfaces.EstadoDeAldeano;
import fiuba.algo3.tp2.modelo.Piezas.*;
import fiuba.algo3.tp2.modelo.Piezas.Unidades.*;

import static fiuba.algo3.tp2.modelo.Campo.Constantes.*;

public class EstaTrabajando implements EstadoDeAldeano {

    @Override
    public void ganarOro(Aldeano aldeano){
    }

    @Override
    public boolean estaTrabajando() {
        return true;
    }

    @Override
    public EstadoDeAldeano construir(Edificio edificio, int turnosConstruccion) {
        if(turnosConstruccion == TURNOS_CONSTRUCCION_MAXIMO){
            edificio.finalizarConstruccion();
            return new EnReposo();
        }
        return this;
    }

    @Override
    public void reparar(EstadoDeAldeano unEstado) {

    }
}
