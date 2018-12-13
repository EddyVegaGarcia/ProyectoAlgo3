package fiuba.algo3.tp2.modelo.Piezas.Unidades;

import fiuba.algo3.tp2.modelo.*;

import fiuba.algo3.tp2.modelo.Interfaces.Atacante;
import fiuba.algo3.tp2.modelo.Piezas.*;
import fiuba.algo3.tp2.modelo.UnidadFactory.PiezaType;

import static fiuba.algo3.tp2.modelo.Campo.Constantes.*;
import static fiuba.algo3.tp2.modelo.UnidadFactory.PiezaType.*;


public class Espadachin extends Unidad implements Atacante {

    int distanciaDeAtaque;

    public Espadachin() {

        this.tamanio = TAMANIO_UNIDAD;
        this.vida = VIDA_MAXIMA_ESPADACHIN;
        this.costo = COSTO_ESPADACHIN;
        this.distanciaDeAtaque = DISTANCIA_ATAQUE_ESPADACHIN;
    }

    public void atacarUnidad(Unidad unaUnidad) {

        this.validarAcciones();
        this.validarRangoDeAtaque(unaUnidad.obtenerPosicion(), this.obtenerDistanciaAtaque());
        unaUnidad.recibirDanio(ATAQUE_ESPADACHIN_A_UNIDAD);

    }

    public void atacarEdificio(Edificio unEdificio) {

        this.validarAcciones();
        this.validarRangoDeAtaque(unEdificio.obtenerPosicion(), this.obtenerDistanciaAtaque());
        unEdificio.recibirDanio(ATAQUE_ESPADACHIN_A_EDIFICIO);

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
    public String obtenerNombre() {
        return "Espadachin";
    }

    @Override
    public void atacarPieza(Pieza unaPieza) {
        if(unaPieza.obtenerTamanio() == 1)
            this.atacarUnidad((Unidad)unaPieza);
        else
            this.atacarEdificio((Edificio) unaPieza);
    }
}
