package fiuba.algo3.tp2.modelo.Estados;

import fiuba.algo3.tp2.modelo.Exception.EdificioYaConstruidoException;
import fiuba.algo3.tp2.modelo.Interfaces.EstadoDeEdificio;

public class Construido implements EstadoDeEdificio {

    @Override
    public EstadoDeEdificio iniciarConstruccion() {
        throw new EdificioYaConstruidoException();
    }

    @Override
    public EstadoDeEdificio finalizarConstruccion() {
        return this;
    }

    @Override
    public boolean estaConstruido() {
        return true;
    }

    @Override
    public boolean estaEnConstruccion() {
        return false;
    }
}
