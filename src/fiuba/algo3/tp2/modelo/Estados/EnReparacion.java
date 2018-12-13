package fiuba.algo3.tp2.modelo.Estados;

import fiuba.algo3.tp2.modelo.Interfaces.EstadoVidaEdificio;

public class EnReparacion implements EstadoVidaEdificio {

    @Override
    public EstadoVidaEdificio reparar() {
        return this;
    }

    @Override
    public EstadoVidaEdificio finalizarReparacion() {
        return new Reparado();
    }

    @Override
    public Boolean estaReparado() {
        return false;
    }

    @Override
    public Boolean estaEnReparacion() {
        return true;
    }

}
