package fiuba.algo3.tp2.controlador;

public class NoHabilitadoParaJugar extends EstadoDeJugador {

    public abstract EstadoDeJugador cambiarEstado() {
        return new HabilitadoParaJugar();
    }
}
