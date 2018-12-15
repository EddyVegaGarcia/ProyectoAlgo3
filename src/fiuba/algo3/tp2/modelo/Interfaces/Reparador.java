package fiuba.algo3.tp2.modelo.Interfaces;

import fiuba.algo3.tp2.modelo.Piezas.Edificio;
import fiuba.algo3.tp2.modelo.UnidadFactory.PiezaType;

public interface Reparador extends EstadoDeAldeano {

    boolean estaReparando();

    EstadoDeAldeano reparar(Edificio edificio, PiezaType unaPiezaType);

}
