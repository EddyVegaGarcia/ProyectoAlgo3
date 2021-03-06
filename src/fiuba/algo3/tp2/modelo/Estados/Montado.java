package fiuba.algo3.tp2.modelo.Estados;

import fiuba.algo3.tp2.modelo.Interfaces.EstadoDeArmaDeAsedio;
import fiuba.algo3.tp2.modelo.Piezas.Pieza;
import fiuba.algo3.tp2.modelo.Piezas.Unidades.ArmaDeAsedio;

public class Montado implements EstadoDeArmaDeAsedio {

    @Override
    public EstadoDeArmaDeAsedio montar(ArmaDeAsedio unArmaDeAsedio) {

        return this;

    }

    @Override
    public EstadoDeArmaDeAsedio desmontar(ArmaDeAsedio unArmaDeAsedio) {

        unArmaDeAsedio.desactivarMontura();
        return new Desmontado();

    }

    @Override
    public Boolean estaMontado() {
        return true;
    }

    @Override
    public Boolean validacionMovimiento() {
        return false;
    }
}
