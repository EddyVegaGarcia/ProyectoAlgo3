package fiuba.algo3.tp2.modelo.Estados;

import fiuba.algo3.tp2.modelo.Interfaces.EstadoDeEdificio;

public class EnConstruccion implements EstadoDeEdificio {

    @Override
    public void finalizarConstruccion(EstadoDeEdificio unEstado) {
        unEstado = new Construido();
    }

    @Override
    public boolean estaProcesoDeConstruccion() {
        return true;
    }

}
