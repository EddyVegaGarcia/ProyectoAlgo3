package fiuba.algo3.tp2.modelo.Interfaces;

import fiuba.algo3.tp2.modelo.Piezas.*;
import fiuba.algo3.tp2.modelo.Piezas.Unidades.Aldeano;

public interface EstadoDeAldeano {

    void ganarOro(Aldeano aldeano);

    /*public EstadoDeAldeano trabajando(){
        return new EstaTrabajando();
    }*/

    boolean estaTrabajando();

    EstadoDeAldeano construir(Edificio edificio, int turnosConstruccion);

    void reparar(EstadoDeAldeano unEstado);
}


