package fiuba.algo3.tp2.modelo;

import static fiuba.algo3.tp2.modelo.Constantes.*;

public class Espadachin extends Unidad implements Atacante {
    int distanciaDeAtaque;
    RangoDeAtaque rango;

    public Espadachin() {

        this.vida = 100;
        this.costo = 50;
        this.distanciaDeAtaque = 1;
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
    public void recibirDanio(int unDanio) {
        this.vida = vida - unDanio;
    }
}
