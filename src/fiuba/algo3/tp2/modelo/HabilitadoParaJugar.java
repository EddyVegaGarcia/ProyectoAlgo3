package fiuba.algo3.tp2.modelo;

public class HabilitadoParaJugar extends EstadoDeJugador {

    @Override
    public EstadoDeJugador empezarTurno(Jugador jugador) {

        return this;
    }

    @Override
    public EstadoDeJugador finalizarTurno(Jugador jugador) {

        return new NoHabilitadoParaJugar();
    }
}
