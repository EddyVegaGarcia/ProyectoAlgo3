package fiuba.algo3.tp2.modelo.Piezas.Unidades;

import fiuba.algo3.tp2.modelo.*;

import fiuba.algo3.tp2.modelo.Interfaces.Atacante;
import fiuba.algo3.tp2.modelo.Piezas.*;
import fiuba.algo3.tp2.modelo.UnidadFactory.PiezaType;

import static fiuba.algo3.tp2.modelo.Campo.Constantes.*;
import static fiuba.algo3.tp2.modelo.UnidadFactory.PiezaType.*;


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
    public int oroRecolectado() {
        return 0;
    }
}
