package fiuba.algo3.tp2.modelo;

public class ArmaDeAsedio extends Unidad implements Atacante {

    public ArmaDeAsedio(){
        this.vida = 150;
        this.costo = 200;

    }

    public void atacarUnidad(Unidad unaUnidad) {

    }

    public void atacarEdificio(Edificio unEdificio) {
        int danio = 75;
        unEdificio.recibirDanio(danio);
    }
}
