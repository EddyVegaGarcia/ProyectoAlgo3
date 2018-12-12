package fiuba.algo3.tp2.modelo.Interfaces;

import fiuba.algo3.tp2.modelo.Piezas.*;

public interface Constructor extends Diseñador{

    void construir(Edificio unEdificio);

    //void reparar(Edificio unEdificio);

    boolean estaTrabajando();


}
