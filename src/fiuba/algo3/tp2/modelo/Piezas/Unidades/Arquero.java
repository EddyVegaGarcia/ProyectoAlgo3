package fiuba.algo3.tp2.modelo.Piezas.Unidades;

import fiuba.algo3.tp2.modelo.*;

import fiuba.algo3.tp2.modelo.Interfaces.Atacante;
import fiuba.algo3.tp2.modelo.Piezas.*;

import static fiuba.algo3.tp2.modelo.Campo.Constantes.*;

public class Arquero extends Unidad implements Atacante {
    int distanciaDeAtaque;
    RangoDeAtaque rango;

    public Arquero(){

        this.tamanio = TAMANIO_UNIDAD;
        this.vida = VIDA_MAXIMA_ARQUERO;
        this.costo = COSTO_ARQUERO;
        this.distanciaDeAtaque = DISTANCIA_ATAQUE_ARQUERO;
    }

    public void atacarUnidad(Unidad unaUnidad) {

        unaUnidad.recibirDanio(ATAQUE_ARQUERO_A_UNIDAD);
    }

    public void atacarEdificio(Edificio unEdificio) {

        unEdificio.recibirDanio(ATAQUE_ARQUERO_A_EDIFICIO);
    }

    @Override
    public int obtenerDistanciaAtaque() {
        return distanciaDeAtaque;
    }

    @Override
    public void guardarRangoDeAtaque(RangoDeAtaque rango) {
        this.rango = rango;
    }

}
