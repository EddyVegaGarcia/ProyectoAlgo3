package fiuba.algo3.tp2.modelo.Estados;

import fiuba.algo3.tp2.modelo.Exception.EdificioAunEnProcesoException;
import fiuba.algo3.tp2.modelo.Interfaces.EstadoDeEdificio;


public class EnProceso implements EstadoDeEdificio {

    @Override
    public EstadoDeEdificio iniciarConstruccion() {
        return new EnConstruccion();
    }

    @Override
    public EstadoDeEdificio finalizarConstruccion() {
        throw new EdificioAunEnProcesoException();
    }

    @Override
    public boolean estaConstruido() {
        return false;
    }

    @Override
    public boolean estaEnConstruccion() {
        return false;
    }
}
