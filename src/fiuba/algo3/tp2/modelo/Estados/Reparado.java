package fiuba.algo3.tp2.modelo.Estados;

import fiuba.algo3.tp2.modelo.Exception.EdificioYaReparadoException;
import fiuba.algo3.tp2.modelo.Interfaces.EstadoVidaEdificio;

public class Reparado implements EstadoVidaEdificio {

    @Override
    public EstadoVidaEdificio reparar() {
        throw new EdificioYaReparadoException();
    }

    @Override
    public EstadoVidaEdificio finalizarReparacion() {
        return this;
    }

    @Override
    public Boolean estaReparado() {
        return true;
    }

    @Override
    public Boolean estaEnReparacion() {
        return false;
    }
}
