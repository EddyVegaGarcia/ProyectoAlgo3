package fiuba.algo3.tp2.modelo;

import static fiuba.algo3.tp2.modelo.Constantes.*;
import fiuba.algo3.tp2.modelo.Exception.*;
import fiuba.algo3.tp2.modelo.UnidadFactory.*;

public class Cuartel extends Edificio {


    public Cuartel() {
        this.costo = 50;
        this.tamanio = 4;
        this.estado = new EnConstruccion();
        this.turnosConstruccion = 0;
    }

    @Override
    protected int vidaMaxima() {
        return VIDA_MAXIMA_CUARTEL;
    }

    @Override
    protected void darleVida(){
        this.vida = VIDA_MAXIMA_CUARTEL;
    }

    @Override
    public Unidad crearUnidad(UnidadType unidadType) {

        if ((unidadType == UnidadType.UNIDAD_ESPADACHIN) || (unidadType == UnidadType.UNIDAD_ARQUERO))
            return UnidadesFactory.crearUnidad(unidadType);
        else
            throw new InvalidUnidadTypeException();

    }
}
