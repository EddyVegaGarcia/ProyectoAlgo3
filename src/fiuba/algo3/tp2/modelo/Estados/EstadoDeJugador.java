package fiuba.algo3.tp2.modelo.Estados;

import fiuba.algo3.tp2.modelo.Juego.*;

public abstract class EstadoDeJugador {

    public abstract EstadoDeJugador empezarTurno(Jugador jugador);

    public abstract EstadoDeJugador finalizarTurno(Jugador jugador);

}
