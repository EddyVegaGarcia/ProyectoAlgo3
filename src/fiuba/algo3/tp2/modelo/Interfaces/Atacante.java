package fiuba.algo3.tp2.modelo.Interfaces;

import fiuba.algo3.tp2.modelo.Piezas.*;

public interface Atacante {

    int obtenerDistanciaAtaque();

    void atacarPieza(Pieza unaPieza);

    void atacarUnidad(Pieza unaPieza);

    void atacarEdificio(Pieza unaPieza);
}
