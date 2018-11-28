package fiuba.algo3.tp2.modelo;

import fiuba.algo3.tp2.modelo.Exception.*;
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
        this.rangoDeAtaque = new RangoDeAtaque(POSICION_DEFAULT_CASTILLO1);
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

    @Override
    protected void darleVida() {

    }

    public void guardarRangoDeAtaque(RangoDeAtaque rango) {
        this.rangoDeAtaque = rango;
    }

    public void atacarUnidad(Unidad unidad) {
        int danio = 20;
        unidad.recibirDanio(danio);
    }

    @Override
    public void atacarEdificio(Edificio unEdificio) {

    }

    public void atacar() {
        List<Posicion> posicionesDeEnemigos = rangoDeAtaque.obtenerRangoDeAtaque(this, POSICION_DEFAULT_CASTILLO1);

        for (Posicion posActual : posicionesDeEnemigos) {


        }

    }

    @Override
    public Unidad crearUnidad(UnidadType unidadType) {
        if (unidadType == UnidadType.UNIDAD_ARMADEASEDIO)
            return UnidadesFactory.crearUnidad(unidadType);
        else
            throw new InvalidUnidadTypeException();
    }
}
