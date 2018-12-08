package fiuba.algo3.tp2.modelo.Piezas;

import fiuba.algo3.tp2.modelo.Campo.*;
import fiuba.algo3.tp2.modelo.Exception.*;

public abstract class Unidad extends Pieza {

    @Override
    public void recibirDanio(int unDanio) {

        if (vida - unDanio <= 0) {
            vida = 0;
            throw new PiezaDestruidaException();
        }

        this.vida = vida - unDanio;

    }

    public void cambiarPosicion(Posicion nuevaPosicion){

        posiciones.remove(0);
        posiciones.add(nuevaPosicion);

    }

}

