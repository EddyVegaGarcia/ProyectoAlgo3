package fiuba.algo3.tp2.modelo.UnidadFactory;

import fiuba.algo3.tp2.modelo.Exception.*;
import fiuba.algo3.tp2.modelo.Piezas.*;
import fiuba.algo3.tp2.modelo.Piezas.Edificios.Cuartel;
import fiuba.algo3.tp2.modelo.Piezas.Edificios.PlazaCentral;
import fiuba.algo3.tp2.modelo.Piezas.Unidades.*;

public class PiezaFactory {

    public static Pieza crearPieza(PiezaType type) throws InvalidUnidadTypeException {
        if (type.equals(PiezaType.UNIDAD_ALDEANO))
            return new Aldeano();
        else if (type.equals(PiezaType.UNIDAD_ESPADACHIN))
            return new Espadachin();
        else if (type.equals(PiezaType.UNIDAD_ARMADEASEDIO))
            return new ArmaDeAsedio();
        else if (type.equals(PiezaType.UNIDAD_ARQUERO))
            return new Arquero();
        else if(type.equals(PiezaType.EDIFICIO_CUARTEL))
            return new Cuartel();
        else if(type.equals(PiezaType.EDIFICIO_PLAZACENTRAL))
            return new PlazaCentral();

        throw new InvalidUnidadTypeException();
    }

}
