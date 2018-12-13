package fiuba.algo3.tp2.modelo.Estados;

import fiuba.algo3.tp2.modelo.Exception.EdificioConstruidoException;
import fiuba.algo3.tp2.modelo.Interfaces.EstadoDeAldeano;
import fiuba.algo3.tp2.modelo.Piezas.*;

public class EnReposo implements EstadoDeAldeano {

    @Override
    public boolean estaTrabajando() {
        return false;
    }

    @Override
    public EstadoDeAldeano construir(Edificio edificio, int turnosConstruccion) {
        if(edificio.obtenerEstado().estaProcesoDeConstruccion()) {

            return new EstaTrabajando();

        }
        throw new EdificioConstruidoException();
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

