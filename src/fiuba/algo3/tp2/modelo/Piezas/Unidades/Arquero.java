package fiuba.algo3.tp2.modelo.Piezas.Unidades;

import fiuba.algo3.tp2.modelo.Exception.OroInsuficienteException;
import fiuba.algo3.tp2.modelo.Exception.PiezaNoReparableNoConstruibleException;
import fiuba.algo3.tp2.modelo.Interfaces.Atacante;
import fiuba.algo3.tp2.modelo.Interfaces.Creable;
import fiuba.algo3.tp2.modelo.Piezas.*;
import fiuba.algo3.tp2.modelo.UnidadFactory.PiezaType;

import static fiuba.algo3.tp2.modelo.Constantes.*;
import static fiuba.algo3.tp2.modelo.UnidadFactory.PiezaType.*;

public class Arquero extends Unidad implements Atacante, Creable {

    int distanciaDeAtaque;

    public Arquero(){

        this.tamanio = TAMANIO_UNIDAD;
        this.vida = VIDA_MAXIMA_ARQUERO;
        this.costo = COSTO_ARQUERO;
        this.distanciaDeAtaque = DISTANCIA_ATAQUE_ARQUERO;
    }

    public void atacarUnidad(Unidad unaUnidad) {

        this.validarAcciones();
        this.validarRangoDeAtaque(unaUnidad.obtenerPosicion(), this.obtenerDistanciaAtaque());
        unaUnidad.recibirDanio(ATAQUE_ARQUERO_A_UNIDAD);
        this.accionRealizada();

    }

    public void atacarEdificio(Edificio unEdificio) {

        this.validarAcciones();
        this.validarRangoDeAtaqueAEdificio(unEdificio.obtenerPosiciones(), this.obtenerDistanciaAtaque());
        unEdificio.recibirDanio(ATAQUE_ARQUERO_A_EDIFICIO);
        this.accionRealizada();

    }

    @Override
    public int obtenerDistanciaAtaque() {
        return distanciaDeAtaque;
    }

    @Override
    public PiezaType obtenerType() {
        return UNIDAD_ARQUERO;
    }

    @Override
    public double getTamanio() {
        return tamanio;
    }

    @Override
    public void atacarPieza(Pieza unaPieza) {
        if(unaPieza.obtenerTamanio() == 1)
            this.atacarUnidad((Unidad)unaPieza);
        else
            this.atacarEdificio((Edificio) unaPieza);
    }

    @Override
    public void validarOroSuficiente(int oro) {
        if( oro < COSTO_ARQUERO )
            throw new OroInsuficienteException();
    }

    @Override
    public int costo() {
        return costo;
    }

}
