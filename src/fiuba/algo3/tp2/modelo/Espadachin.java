package fiuba.algo3.tp2.modelo;

public class Espadachin extends Unidad implements Atacante {

    public Espadachin() {

        this.vida = 100;
        this.costo = 50;
    }

    public void atacarUnidad(Unidad unaUnidad) {
        int danio = 25;
        unaUnidad.recibirDanio(danio);
    }

    public void atacarEdificio(Edificio unEdificio) {
        int danio = 15;
        unEdificio.recibirDanio(danio);
    }
}
