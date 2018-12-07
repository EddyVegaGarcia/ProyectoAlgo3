package fiuba.algo3.tp2.modelo;

public abstract class EstadoDeJugador {

    public abstract EstadoDeJugador empezarTurno(Jugador jugador);

    public abstract EstadoDeJugador finalizarTurno(Jugador jugador);

}
