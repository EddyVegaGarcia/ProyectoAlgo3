package fiuba.algo3.tp2.modelo.Interfaces;

public interface EstadoDeEdificio {

    EstadoDeEdificio iniciarConstruccion();

    EstadoDeEdificio finalizarConstruccion();

    boolean estaConstruido();

    boolean estaEnConstruccion();

}
