package fiuba.algo3.tp2.modelo.Interfaces;


import fiuba.algo3.tp2.modelo.*;
import fiuba.algo3.tp2.modelo.Piezas.*;

public interface Atacante {

    void atacarUnidad(Unidad unaUnidad);

    void atacarEdificio(Edificio unEdificio);

    int obtenerDistanciaAtaque();

    void atacarPieza(Pieza unaPieza);
}
