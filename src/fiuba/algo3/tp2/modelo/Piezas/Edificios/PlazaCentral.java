package fiuba.algo3.tp2.modelo.Piezas.Edificios;

import static fiuba.algo3.tp2.modelo.Campo.Constantes.*;

import fiuba.algo3.tp2.modelo.Estados.*;
import fiuba.algo3.tp2.modelo.Exception.*;
import fiuba.algo3.tp2.modelo.Piezas.*;
import fiuba.algo3.tp2.modelo.UnidadFactory.*;
import static fiuba.algo3.tp2.modelo.UnidadFactory.PiezaType.*;

public class PlazaCentral extends Edificio {

    public PlazaCentral(){

        this.costo = COSTO_PLAZACENTRAL;
        this.estado = new EnConstruccion();
        this.tamanio = TAMANIO_PLAZA;
        this.vida = VIDA_MAXIMA_PLAZACENTRAL;

    }

    @Override
    public Unidad crearUnidad(UnidadType unidadType){

        if(unidadType == UnidadType.UNIDAD_ALDEANO ){
            this.validarAcciones();
            this.accionesRealizadas++;
            return UnidadesFactory.crearUnidad(unidadType);
        }
        else
            throw new InvalidUnidadTypeException();

    }

    @Override
    public void darVidaPorReparacion() {
        this.vida = vida + VIDA_REPARACION;
    }

    @Override
    public PiezaType obtenerType() {
        return EDIFICIO_PLAZACENTRAL;
    }

    @Override
    public double getTamanio() {
        return tamanio;
    }

    @Override
    public String obtenerNombre() {
        return "Plaza Central";
    }

    @Override
    public int oroRecolectado() {
        return 0;
    }
}
