package fiuba.algo3.tp2.modelo;

public class NoHabilitadoParaJugar extends EstadoDeJugador {

    @Override
    public EstadoDeJugador cambiarEstado() {
        return new HabilitadoParaJugar();
    }

    @Override
    public void jugar(Jugador jugador) {}

}
