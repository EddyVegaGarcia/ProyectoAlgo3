package fiuba.algo3.tp2.modelo.Estados;

import fiuba.algo3.tp2.modelo.Interfaces.EstadoDeArmaDeAsedio;
import fiuba.algo3.tp2.modelo.Piezas.Unidades.ArmaDeAsedio;

public class Desmontado implements EstadoDeArmaDeAsedio {

    @Override
    public EstadoDeArmaDeAsedio montar(ArmaDeAsedio unArmaDeAsedio) {

        unArmaDeAsedio.activarMontura();
        return new Montado();
    }

    @Override
    public EstadoDeArmaDeAsedio desmontar(ArmaDeAsedio unArmaDeAsedio) {

        return this;

    }

    @Override
    public Boolean estaMontado() {
        return false;
    }

    @Override
    public Boolean validacionMovimiento() {
        return true;
    }
}
