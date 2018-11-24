package fiuba.algo3.tp2.modelo;

import static fiuba.algo3.tp2.modelo.Constantes.*;

public class Castillo extends Edificio{

    public Castillo(){
        this.vida = VIDA_MAXIMA_CASTILLO;
        this.tamanio = 8;
        this.estado = new Construido();
    }

    @Override
    public void construir() {
        /* NO SE PUEDEN CONSTRUIR CASTILLOS*/
    }

    @Override
    protected int vidaMaxima() {
        return VIDA_MAXIMA_CASTILLO;
    }

    @Override
    public void reparar() {
        if(vida == 1000){
            throw new RuntimeException();
        }
        this.vida = vida + 15;
    }

    public Unidad crearArmaDeAsedio() {
        return (new ArmaDeAsedio());
    }

    @Override
    protected void darleVida() {

    }
}
