package fiuba.algo3.tp2.modelo.Interfaces;

import fiuba.algo3.tp2.modelo.Piezas.*;
import fiuba.algo3.tp2.modelo.Piezas.Unidades.Aldeano;
import fiuba.algo3.tp2.modelo.UnidadFactory.PiezaType;

public interface EstadoDeAldeano {

    boolean estaTrabajando();

    EstadoDeAldeano construir(Edificio edificio, int turnosConstruccion);

    EstadoDeAldeano reparar(Edificio edificio, PiezaType unaPiezaType);

    int oroRecolectado();
}


