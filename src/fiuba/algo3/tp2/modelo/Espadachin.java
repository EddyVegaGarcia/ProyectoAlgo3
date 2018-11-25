package fiuba.algo3.tp2.modelo;

public class Espadachin extends Unidad implements Atacante {
    int distanciaDeAtaque;
    RangoDeAtaque rango;

    public Espadachin() {

        this.vida = 100;
        this.costo = 50;
        this.distanciaDeAtaque = 1;
    }

    public void atacarUnidad(Unidad unaUnidad) {
        int danio = 25;
        unaUnidad.recibirDanio(danio);
    }

    public void atacarEdificio(Edificio unEdificio) {
        int danio = 15;
        unEdificio.recibirDanio(danio);
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
