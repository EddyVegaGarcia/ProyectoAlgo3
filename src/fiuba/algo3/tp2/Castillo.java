package fiuba.algo3.tp2;

public class Castillo extends Edificio{

    Castillo(){
        this.vida = 1000;
        this.tamanio = 8;
        this.estado = new Reparado();
    }

    @Override
    public void recibirDanio(int danio) {
        this.vida = vida - danio;
    }

    @Override
    public void reparar() {
        if(vida == 1000){
            throw new RuntimeException();
        }
        this.vida = vida + 15;
    }


    public boolean estaReparado(){
        return (vida == 1000);
    }

    @Override
    public void darleVida(){

    }

    @Override
    public boolean estaConstruido(){
        return (vida == 1000);
    }

    public Unidad crearArmaAsedio() {
        ArmaAsedio arma = new ArmaAsedio("3,2");
        return arma;
    }
}