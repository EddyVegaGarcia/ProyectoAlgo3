package fiuba.algo3.tp2.modelo.Estados;

import fiuba.algo3.tp2.modelo.Exception.EdificioConstruidoException;
import fiuba.algo3.tp2.modelo.Exception.EdificioEnConstruccionException;
import fiuba.algo3.tp2.modelo.Interfaces.Construible;
import fiuba.algo3.tp2.modelo.Interfaces.EstadoDeAldeano;
import fiuba.algo3.tp2.modelo.Piezas.*;

public class EnReposo implements EstadoDeAldeano {

    @Override
    public boolean estaTrabajando() {
        return false;
    }

    @Override
    public EstadoDeAldeano construir(Edificio edificio, int turnosConstruccion) {

        if(!edificio.obtenerEstado().estaConstruido() && !edificio.obtenerEstado().estaEnConstruccion()) {
            ((Construible)edificio).iniciarConstruccion();
            return new EstaTrabajando();

        }
        else if(edificio.obtenerEstado().estaConstruido())
            throw new EdificioConstruidoException();
        else if(edificio.obtenerEstado().estaEnConstruccion())
            throw new EdificioEnConstruccionException();

        return new EnReposo();
    }

    @Override
    public void reparar(EstadoDeAldeano unEstado) {
        unEstado = new EstaTrabajando();
    }

    @Override
    public int oroRecolectado() {
        return 20;
    }

}

