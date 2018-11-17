package fiuba.algo3.tp2;

public class Arquero extends Unidad {

    public Arquero(String pos){
        this.vida = 75;
        this.costo = 75;
        this.posicion = new Posicion(pos);

    }

    public int vida() {
        return vida;
    }

    @Override
    public void atacar(Edificio edificio) {

    }
}
