package fiuba.algo3.tp2.modelo.Interfaces;

import fiuba.algo3.tp2.modelo.Piezas.*;

public interface Constructor extends Diseñador{

    void construir(Pieza Pieza);

    void repararPieza(Pieza unaPieza);

    boolean estaTrabajando();

    int oroRecolectado();

    void seguirTrabajando();

    void seguirReparando();
}
