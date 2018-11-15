package fiuba.algo3.tp2;

public class Espadachin extends Unidad {

    Espadachin(String pos) {

        this.vida = 100;
        this.costo = 50;
        this.posicion = new Posicion(pos);
    }

    @Override
    public void atacar(Edificio edificio) {
        int danio = 15;
        edificio.recibirDanio(danio);

    }
}
