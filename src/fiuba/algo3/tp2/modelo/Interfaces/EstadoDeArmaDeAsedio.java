package fiuba.algo3.tp2.modelo.Interfaces;

import fiuba.algo3.tp2.modelo.Piezas.Unidades.ArmaDeAsedio;

public interface EstadoDeArmaDeAsedio {

    EstadoDeArmaDeAsedio montar(ArmaDeAsedio unArmaDeAsedio);

    EstadoDeArmaDeAsedio desmontar(ArmaDeAsedio unArmaDeAsedio);

    Boolean estaMontado();

    Boolean validacionMovimiento();

}
