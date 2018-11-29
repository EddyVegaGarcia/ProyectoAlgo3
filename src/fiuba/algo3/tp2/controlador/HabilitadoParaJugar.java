package fiuba.algo3.tp2.controlador;

public class HabilitadoParaJugar extends EstadoDeJugador {

    public abstract EstadoDeJugador cambiarEstado() {
        return new NoHabilitadoParaJugar();
    }
}
