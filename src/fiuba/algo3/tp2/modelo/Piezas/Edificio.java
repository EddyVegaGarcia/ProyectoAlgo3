package fiuba.algo3.tp2.modelo.Piezas;

import fiuba.algo3.tp2.modelo.Campo.*;
import fiuba.algo3.tp2.modelo.Estados.*;
import fiuba.algo3.tp2.modelo.UnidadFactory.*;


public abstract class Edificio extends Pieza {

    public EstadoDeEdificio estado;

    public void iniciarConstruccion(){
        this.estado = new EnConstruccion();
    }

    public void finalizarConstruccion(){
        this.estado = new Construido();
    }

    public abstract Unidad crearUnidad(UnidadType unidadType);

    public boolean estaConstruido(){
        return estado.estaConstruido();
    }

    public abstract void darVidaPorReparacion();

    @Override
    public void cambiarPosicion(Posicion nuevaPosicion) {

    }

}