package fiuba.algo3.tp2.modelo.Piezas;

import fiuba.algo3.tp2.modelo.Campo.*;
import fiuba.algo3.tp2.modelo.Exception.*;

public abstract class Unidad extends Pieza {

    public void cambiarPosicion(Posicion nuevaPosicion){

        this.validarAcciones();

        posiciones.remove(0);
        posiciones.add(nuevaPosicion);

        this.accionRealizada();

    }


}

