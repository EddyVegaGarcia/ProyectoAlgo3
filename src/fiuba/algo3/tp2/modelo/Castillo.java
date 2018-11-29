package fiuba.algo3.tp2.modelo;

import fiuba.algo3.tp2.modelo.Exception.*;
import fiuba.algo3.tp2.modelo.UnidadFactory.*;

import java.util.ArrayList;
import java.util.List;

import static fiuba.algo3.tp2.modelo.Constantes.*;

public class Castillo extends Edificio implements Atacante {

    public int distanciaDeAtaque;
    public RangoDeAtaque rangoDeAtaque;

    public Castillo(ArrayList posiciones) {
        this.vida = VIDA_MAXIMA_CASTILLO;
        this.tamanio = TAMANIO_CASTILLO;
        this.estado = new Construido();
        this.posiciones = posiciones;
        this.vida = VIDA_MAXIMA_CASTILLO;
    }

    @Override
    public void construir() {
        /* NO SE PUEDEN CONSTRUIR CASTILLOS*/
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
    public void guardarRangoDeAtaque(RangoDeAtaque rango) {
        this.rangoDeAtaque = rango;
    }

    public void atacarUnidad(Unidad unidad) {
        unidad.recibirDanio(ATAQUE_CASTILLO);
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
