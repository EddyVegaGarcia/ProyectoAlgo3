package fiuba.algo3.tp2.modelo.Piezas.Edificios;

import static fiuba.algo3.tp2.modelo.Campo.Constantes.*;

import fiuba.algo3.tp2.controlador.MouseEventHandler;
import fiuba.algo3.tp2.modelo.Estados.*;
import fiuba.algo3.tp2.modelo.Exception.*;
import fiuba.algo3.tp2.modelo.Piezas.*;
import fiuba.algo3.tp2.modelo.UnidadFactory.*;

public class PlazaCentral extends Edificio {

    public PlazaCentral(){

        this.costo = COSTO_PLAZACENTRAL;
        this.estado = new EnConstruccion();
        this.tamanio = TAMANIO_PLAZA;
        this.vida = VIDA_MAXIMA_PLAZACENTRAL;

    }

    @Override
    public Unidad crearUnidad(UnidadType unidadType){

        if(unidadType == UnidadType.UNIDAD_ALDEANO)
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

    @Override
    public boolean sosPlazaCentral() {
        return true;
    }

    @Override
    public boolean sosAldeano() {
        return false;
    }


    @Override
    public boolean sosArmaAsedio() {
        return false;
    }

    @Override
    public String nombre() {
        return "Plaza Central";
    }

    @Override
    public boolean podesMoverte() {
        return false;
    }

    @Override
    public boolean podesAtacar() {
        return false;
    }

    @Override
    public boolean podesConstruirArmaDeAsedio() {
        return false;
    }

    @Override
    public boolean podesDesmontarArmaAsedio() {
        return false;
    }

    @Override
    public boolean podesCrearUnAldeano() {
        return true;
    }

    @Override
    public boolean podesReparar() {
        return false;
    }

    @Override
    public double getTamanio() {
        return tamanio;
    }
}
