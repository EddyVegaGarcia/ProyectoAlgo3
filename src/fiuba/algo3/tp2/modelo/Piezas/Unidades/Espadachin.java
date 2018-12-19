package fiuba.algo3.tp2.modelo.Piezas.Unidades;

import fiuba.algo3.tp2.modelo.Exception.OroInsuficienteException;
import fiuba.algo3.tp2.modelo.Interfaces.Atacante;
import fiuba.algo3.tp2.modelo.Interfaces.Creable;
import fiuba.algo3.tp2.modelo.Piezas.*;
import fiuba.algo3.tp2.modelo.UnidadFactory.PiezaType;

import static fiuba.algo3.tp2.modelo.Constantes.*;
import static fiuba.algo3.tp2.modelo.UnidadFactory.PiezaType.*;


public class Espadachin extends Unidad implements Atacante, Creable {

    int distanciaDeAtaque;

    public Espadachin() {

        this.tamanio = TAMANIO_UNIDAD;
        this.vida = VIDA_MAXIMA_ESPADACHIN;
        this.costo = COSTO_ESPADACHIN;
        this.distanciaDeAtaque = DISTANCIA_ATAQUE_ESPADACHIN;
    }

    @Override
    public int obtenerDistanciaAtaque() {
        return distanciaDeAtaque;
    }

    @Override
    public PiezaType obtenerType() {
        return UNIDAD_ESPADACHIN;
    }

    @Override
    public double getTamanio() {
        return tamanio;
    }


    @Override
    public void atacarPieza(Pieza unaPieza) {

        this.validarAcciones();
        this.validarRangoDeAtaque(unaPieza.obtenerPosiciones(), this.obtenerDistanciaAtaque());
        unaPieza.recibirDanio(ATAQUE_ESPADACHIN_A_EDIFICIO);
        this.accionRealizada();
    }

    @Override
    public void validarOroSuficiente(int oro) {
        if( oro < COSTO_ESPADACHIN )
            throw new OroInsuficienteException();
    }

    @Override
    public int costo() {
        return costo;
    }

}
