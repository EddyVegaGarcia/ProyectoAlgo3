package fiuba.algo3.tp2.modelo.Interfaces;

import fiuba.algo3.tp2.modelo.Piezas.*;
import fiuba.algo3.tp2.modelo.Piezas.Edificios.*;

public interface Constructor extends Diseñador{

    void construir(Pieza Pieza);

    void repararPieza(Pieza unaPieza);

    boolean estaTrabajando();

    boolean estaReparando();

    int oroRecolectado();

    void seguirTrabajando();

    void seguirReparando();

    void repararCuartel(Cuartel unCuartel);

    void repararCastillo(Castillo unCastillo);

    void repararPlazaCentral(PlazaCentral unaPlazaCentral);

}
