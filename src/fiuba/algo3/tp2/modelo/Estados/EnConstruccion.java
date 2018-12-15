package fiuba.algo3.tp2.modelo.Estados;

import fiuba.algo3.tp2.modelo.Interfaces.EstadoDeEdificio;

public class EnConstruccion implements EstadoDeEdificio {

    @Override
    public EstadoDeEdificio iniciarConstruccion() {
        return this;
    }

    @Override
    public EstadoDeEdificio finalizarConstruccion() { return new Construido(); }

    @Override
    public boolean estaConstruido() {
        return false;
    }

    @Override
    public boolean estaEnConstruccion() {
        return true;
    }
}
