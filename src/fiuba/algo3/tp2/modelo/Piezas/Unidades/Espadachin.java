package fiuba.algo3.tp2.modelo.Piezas.Unidades;

import fiuba.algo3.tp2.controlador.MauseEventHandler;
import fiuba.algo3.tp2.modelo.*;

import fiuba.algo3.tp2.modelo.Interfaces.Atacante;
import fiuba.algo3.tp2.modelo.Piezas.*;

import static fiuba.algo3.tp2.modelo.Campo.Constantes.*;

public class Espadachin extends Unidad implements Atacante {

    int distanciaDeAtaque;
    RangoDeAtaque rango;

    public Espadachin() {

        this.tamanio = TAMANIO_UNIDAD;
        this.vida = VIDA_MAXIMA_ESPADACHIN;
        this.costo = COSTO_ESPADACHIN;
        this.distanciaDeAtaque = DISTANCIA_ATAQUE_ESPADACHIN;
    }

    public void atacarUnidad(Unidad unaUnidad) {

        unaUnidad.recibirDanio(ATAQUE_ESPADACHIN_A_UNIDAD);
    }

    public void atacarEdificio(Edificio unEdificio) {

        unEdificio.recibirDanio(ATAQUE_ESPADACHIN_A_EDIFICIO);
    }

    @Override
    public int obtenerDistanciaAtaque() {
        return distanciaDeAtaque;
    }

    @Override
    public void guardarRangoDeAtaque(RangoDeAtaque rango) {
        this.rango = rango;
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
    public void queTipoSos(MauseEventHandler mauseEventHandler) {
        mauseEventHandler.espadachin();
    }
}
