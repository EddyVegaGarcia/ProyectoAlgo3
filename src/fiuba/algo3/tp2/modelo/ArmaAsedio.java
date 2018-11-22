package fiuba.algo3.tp2.modelo;

public class ArmaAsedio extends Unidad {

    public ArmaAsedio(){
        this.vida = 150;
        this.costo = 200;

    }


    public int vida() {
        return 150;
    }

    @Override
    public void atacar(Edificio edificio) {

    }
}
