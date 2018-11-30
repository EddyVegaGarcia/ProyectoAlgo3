package fiuba.algo3.tp2.modelo;

import static fiuba.algo3.tp2.modelo.Constantes.*;

public class ArmaDeAsedio extends Unidad implements Atacante {
    int distanciaDeAtaque;
    RangoDeAtaque rango;

    public ArmaDeAsedio(){
        this.vida = 150;
        this.costo = 200;
        this.distanciaDeAtaque = 5;
    }

    public void atacarUnidad(Unidad unaUnidad) {

    }

    public void atacarEdificio(Edificio unEdificio) {

        unEdificio.recibirDanio(ATAQUE_ARMADEASEDIO);

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
