package fiuba.algo3.tp2.modelo;

public abstract class Unidad extends Pieza {

    @Override
    public void recibirDanio(int danio) {
        this.vida = vida - danio;
    }

}

