package fiuba.algo3.tp2.modelo.Estados;

import fiuba.algo3.tp2.modelo.Juego.*;

public class NoHabilitadoParaJugar extends EstadoDeJugador {

    @Override
    public EstadoDeJugador empezarTurno(Jugador jugador) {
        return new HabilitadoParaJugar();
    }

    @Override
    public EstadoDeJugador finalizarTurno(Jugador jugador) {
        return this;
    }
}
