package fiuba.algo3.tp2.modelo;

import fiuba.algo3.tp2.modelo.Exception.*;

public abstract class Unidad extends Pieza {

    @Override
    public void recibirDanio(int danio) {
        if ((vida - danio) <= 0) {
            throw new PiezaDestruidaException();
        }

        this.vida = vida - danio;
    }

}

