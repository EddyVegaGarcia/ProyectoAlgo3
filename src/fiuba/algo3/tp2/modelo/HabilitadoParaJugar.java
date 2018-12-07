package fiuba.algo3.tp2.modelo;

public class HabilitadoParaJugar extends EstadoDeJugador {

    @Override
    public EstadoDeJugador cambiarEstado() {
        return new NoHabilitadoParaJugar();
    }

    @Override
    public void jugar(Jugador jugador) {


    }
}
