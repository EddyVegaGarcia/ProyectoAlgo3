package fiuba.algo3.tp2.modelo.Interfaces;

import fiuba.algo3.tp2.modelo.Piezas.Edificio;

public interface EstadoDeEdificio {

    EstadoDeEdificio iniciarConstruccion();

    EstadoDeEdificio finalizarConstruccion();

    boolean estaConstruido();

    boolean estaEnConstruccion();

}
