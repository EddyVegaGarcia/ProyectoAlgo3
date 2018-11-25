package fiuba.algo3.tp2.modelo;

import javafx.geometry.Pos;

import java.util.ArrayList;
import java.util.List;

import static fiuba.algo3.tp2.modelo.Constantes.*;

public class Castillo extends Edificio implements Atacante {

    public int distanciaDeAtaque;
    public RangoDeAtaque rangoDeAtaque;

    public Castillo() {
        this.vida = VIDA_MAXIMA_CASTILLO;
        this.tamanio = 16;
        this.estado = new Construido();

        this.distanciaDeAtaque = 3;
        this.rangoDeAtaque = null;
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

    @Override
    public int obtenerDistanciaAtaque() { return distanciaDeAtaque; }

    public Unidad crearArmaDeAsedio() {
        return (new ArmaDeAsedio());
    }

    @Override
    protected void darleVida() {

    }

    public void guardarRangoDeAtaque(RangoDeAtaque rango) {
        this.rangoDeAtaque = rango;
    }

    public void atacarUnidad(Unidad unidad) {}

    public void atacar(Mapa mapa) {
        List<Posicion> posicionesDeEnemigos = new ArrayList<>();

        posicionesDeEnemigos = this.obtenerPosicionesDeEnemigos(mapa);




    }
}
