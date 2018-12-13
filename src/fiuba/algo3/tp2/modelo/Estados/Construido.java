package fiuba.algo3.tp2.modelo.Estados;

import fiuba.algo3.tp2.modelo.Interfaces.EstadoDeEdificio;

public class Construido implements EstadoDeEdificio {

    @Override
    public void finalizarConstruccion(EstadoDeEdificio unEstado) {
        unEstado = this;
    }

    @Override
    public boolean estaProcesoDeConstruccion() {
        return false;
    }
}
