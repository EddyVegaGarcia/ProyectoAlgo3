package fiuba.algo3.tp2.modelo.UnidadFactory;

import fiuba.algo3.tp2.modelo.Exception.*;
import fiuba.algo3.tp2.modelo.Piezas.*;
import fiuba.algo3.tp2.modelo.Piezas.Unidades.*;

public class PiezaFactory {

    public static Unidad crearUnidad(PiezaType type) throws InvalidUnidadTypeException {
        if (type.equals(PiezaType.UNIDAD_ALDEANO))
            return new Aldeano();
        else if (type.equals(PiezaType.UNIDAD_ESPADACHIN))
            return new Espadachin();
        else if (type.equals(PiezaType.UNIDAD_ARMADEASEDIO))
            return new ArmaDeAsedio();
        else if (type.equals(PiezaType.UNIDAD_ARQUERO))
            return new Arquero();

        throw new InvalidUnidadTypeException();
    }

}
