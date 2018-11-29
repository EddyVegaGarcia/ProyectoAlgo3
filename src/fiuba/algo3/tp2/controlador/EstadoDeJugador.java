package fiuba.algo3.tp2.controlador;

public abstract class EstadoDeJugador {

    public abstract EstadoDeJugador cambiarEstado();

    public abstract void jugar(Jugador jugador);
}
