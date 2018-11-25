package fiuba.algo3.tp2.modelo;

public class Arquero extends Unidad implements Atacante {
    int distanciaDeAtaque;
    RangoDeAtaque rango;

    public Arquero(){
        this.vida = 75;
        this.costo = 75;
        this.distanciaDeAtaque = 3;
    }

    public void atacarUnidad(Unidad unaUnidad) {
        int danio = 15;
        unaUnidad.recibirDanio(danio);
    }

    public void atacarEdificio(Edificio unEdificio) {
        int danio = 10;
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
