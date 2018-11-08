package fiuba.algo3.tp2.modelo;

import static fiuba.algo3.tp2.modelo.Constantes.*;

public class EstaTrabajando extends EstadoDeAldeano {


    @Override
    public void ganarOro(Aldeano aldeano){
    }

    @Override
    public EstadoDeAldeano cambiar() { return new EnReposo(); }

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
}
