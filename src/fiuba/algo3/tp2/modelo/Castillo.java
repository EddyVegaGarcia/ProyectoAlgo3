package fiuba.algo3.tp2.modelo;

public class Castillo extends Edificio{

    static final int VIDAMAXIMA = 1000;

    public Castillo(){
        this.vida = VIDAMAXIMA;
        this.tamanio = 8;
        this.estado = new Construido();
    }

    @Override
    public void construir() {
        /* NO SE PUEDEN CONSTRUIR CASTILLOS*/
    }

    @Override
    protected int vidaMaxima() {
        return VIDAMAXIMA;
    }

    @Override
    public void reparar() {
        if(vida == 1000){
            throw new RuntimeException();
        }
        this.vida = vida + 15;
    }

    public Unidad crearArmaAsedio() {
        ArmaDeAsedio arma = new ArmaDeAsedio();
        return arma;
    }
}
