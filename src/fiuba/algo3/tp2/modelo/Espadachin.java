package fiuba.algo3.tp2.modelo;

public class Espadachin extends Unidad {

    public Espadachin() {

        this.vida = 100;
        this.costo = 50;
    }

    @Override
    public void atacar(Edificio edificio) {
        int danio = 15;
        edificio.recibirDanio(danio);

    }
}
