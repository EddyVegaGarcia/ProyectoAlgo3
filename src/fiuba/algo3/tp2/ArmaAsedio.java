package fiuba.algo3.tp2;

public class ArmaAsedio extends Unidad {

    ArmaAsedio(String pos){
        this.vida = 150;
        this.costo = 200;
        this.posicion = new Posicion(pos);

    }


    public int vida() {
        return 150;
    }

    @Override
    public void atacar(Edificio edificio) {

    }
}
