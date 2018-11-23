package fiuba.algo3.tp2.modelo;

public class ArmaDeAsedio extends Unidad {

    public ArmaDeAsedio(){
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
