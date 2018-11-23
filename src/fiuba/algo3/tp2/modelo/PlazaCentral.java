package fiuba.algo3.tp2.modelo;

import static fiuba.algo3.tp2.modelo.Constantes.*;

public class PlazaCentral extends Edificio {



    public PlazaCentral(){
        this.costo = 100;
        this.vida = 0;
        this.estado = new EnConstruccion();
        this.tamanio = 4;
        this.turnosConstruccion = 0;
    }

    @Override
    protected void darleVida() {
        this.vida = VIDA_MAXIMA_PLAZACENTRAL;
    }
    @Override
    protected int vidaMaxima(){
        return VIDA_MAXIMA_PLAZACENTRAL;
    }

    public Aldeano crearAldeano() {
        return new Aldeano();
    }
}
