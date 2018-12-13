package fiuba.algo3.tp2.modelo.Estados;

import fiuba.algo3.tp2.modelo.Exception.ReparacionAunSinProcesoException;
import fiuba.algo3.tp2.modelo.Interfaces.EstadoVidaEdificio;

public class Daniado implements EstadoVidaEdificio {

    @Override
    public EstadoVidaEdificio finalizarReparacion() {
        throw new ReparacionAunSinProcesoException();
    }

    @Override
    public EstadoVidaEdificio reparar() {
        return new EnReparacion();
    }

    @Override
    public Boolean estaReparado() {
        return false;
    }

    @Override
    public Boolean estaEnReparacion() {
        return false;
    }
}
