package fiuba.algo3.tp2.modelo.Piezas.Edificios;

import static fiuba.algo3.tp2.modelo.Campo.Constantes.*;

import fiuba.algo3.tp2.modelo.Estados.*;
import fiuba.algo3.tp2.modelo.Exception.*;
import fiuba.algo3.tp2.modelo.Piezas.*;
import fiuba.algo3.tp2.modelo.UnidadFactory.*;
import static fiuba.algo3.tp2.modelo.UnidadFactory.PiezaType.*;

public class Cuartel extends Edificio {


    public Cuartel() {
        this.costo = COSTO_CUARTEL;
        this.tamanio = TAMANIO_CUARTEL;
        this.estado = new EnConstruccion();
        this.vida = VIDA_MAXIMA_CUARTEL;
    }

    @Override
    public Unidad crearUnidad(UnidadType unidadType) {

        if ((unidadType == UnidadType.UNIDAD_ESPADACHIN) || (unidadType == UnidadType.UNIDAD_ARQUERO)) {

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
        return EDIFICIO_CUARTEL;
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

    @Override
    public String obtenerNombre() {
        return "Cuartel";
    }
}
