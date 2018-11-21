package fiuba.algo3.tp2;

public class Espadachin extends Unidad {

    Espadachin() {

        this.vida = 100;
        this.costo = 50;
    }

    @Override
    public void atacar(Edificio edificio) {
        int danio = 15;
        edificio.recibirDanio(danio);

    }
}
