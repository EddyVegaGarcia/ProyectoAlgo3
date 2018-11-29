package fiuba.algo3.tp2.modelo;

import static fiuba.algo3.tp2.modelo.Constantes.*;
import fiuba.algo3.tp2.modelo.Exception.*;
import fiuba.algo3.tp2.modelo.UnidadFactory.*;

import java.util.ArrayList;

public class PlazaCentral extends Edificio {

    public PlazaCentral(ArrayList posiciones){
        this.costo = 100;
        this.estado = new EnConstruccion();
        this.tamanio = TAMANIO_PLAZA;
        this.posiciones = posiciones;
        this.vida = VIDA_MAXIMA_PLAZACENTRAL;

    }


    @Override
    public Unidad crearUnidad(UnidadType unidadType){

        if(unidadType == UnidadType.UNIDAD_ALDEANO)
            return UnidadesFactory.crearUnidad(unidadType);
        else
            throw new InvalidUnidadTypeException();

    }
}
