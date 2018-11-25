package fiuba.algo3.tp2.modelo;

public class Arquero extends Unidad implements Atacante {

    public Arquero(){
        this.vida = 75;
        this.costo = 75;

    }

    public void atacarUnidad(Unidad unaUnidad) {
        int danio = 15;
        unaUnidad.recibirDanio(danio);
    }

    public void atacarEdificio(Edificio unEdificio) {
        int danio = 10;
        unEdificio.recibirDanio(danio);
    }
}
