package fiuba.algo3.tp2.modelo;

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
        int danio = 75;
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
