package fiuba.algo3.tp2.modelo;

import static fiuba.algo3.tp2.modelo.Constantes.*;
import fiuba.algo3.tp2.modelo.Exception.*;
import fiuba.algo3.tp2.modelo.UnidadFactory.*;

public class PlazaCentral extends Edificio {

    public PlazaCentral(){
        this.costo = 100;
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

    @Override
    public Unidad crearUnidad(UnidadType unidadType){

        if(unidadType == UnidadType.UNIDAD_ALDEANO)
            return UnidadesFactory.crearUnidad(unidadType);
        else
            throw new InvalidUnidadTypeException();

    }
}
