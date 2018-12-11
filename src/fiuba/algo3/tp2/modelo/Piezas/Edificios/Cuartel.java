package fiuba.algo3.tp2.modelo.Piezas.Edificios;

import static fiuba.algo3.tp2.modelo.Campo.Constantes.*;

import fiuba.algo3.tp2.controlador.MouseEventHandler;
import fiuba.algo3.tp2.modelo.Estados.*;
import fiuba.algo3.tp2.modelo.Exception.*;
import fiuba.algo3.tp2.modelo.Piezas.*;
import fiuba.algo3.tp2.modelo.UnidadFactory.*;

public class Cuartel extends Edificio {


    public Cuartel() {
        this.costo = COSTO_CUARTEL;
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

    @Override
    public boolean sosPlazaCentral() {
        return false;
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
        return "Cuartel";
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
        return false;
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
