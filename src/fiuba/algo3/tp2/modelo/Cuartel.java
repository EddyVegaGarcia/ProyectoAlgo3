package fiuba.algo3.tp2.modelo;

import static fiuba.algo3.tp2.modelo.Constantes.*;
import fiuba.algo3.tp2.modelo.Exception.*;
import fiuba.algo3.tp2.modelo.UnidadFactory.*;

import java.util.ArrayList;

public class Cuartel extends Edificio {


    public Cuartel() {
        this.costo = 50;
        this.tamanio = TAMANIO_CUARTEL;
        this.estado = new EnConstruccion();
        this.vida = VIDA_MAXIMA_CUARTEL;
    }

    @Override
    public Unidad crearUnidad(UnidadType unidadType) {

        if ((unidadType == UnidadType.UNIDAD_ESPADACHIN) || (unidadType == UnidadType.UNIDAD_ARQUERO))
            return UnidadesFactory.crearUnidad(unidadType);
        else
            throw new InvalidUnidadTypeException();

    }

    @Override
    public void darVidaPorReparacion() {
        this.vida = vida + VIDA_REPARACION;
    }


    @Override
    public void recibirDanio(int unDanio) {
        this.vida = vida - unDanio;
    }
}
