package fiuba.algo3.tp2.controlador;

public class NoHabilitadoParaJugar extends EstadoDeJugador {

    @Override
    public EstadoDeJugador cambiarEstado() {
        return new HabilitadoParaJugar();
    }

    @Override
    public void jugar(Jugador jugador) {}

}
