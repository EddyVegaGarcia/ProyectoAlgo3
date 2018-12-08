package fiuba.algo3.tp2.modelo.Piezas.Unidades;

import fiuba.algo3.tp2.modelo.*;
import fiuba.algo3.tp2.modelo.Estados.*;
import fiuba.algo3.tp2.modelo.Interfaces.*;
import fiuba.algo3.tp2.modelo.Piezas.*;

import static fiuba.algo3.tp2.modelo.Campo.Constantes.*;

public class ArmaDeAsedio extends Unidad implements Atacante {

    int distanciaDeAtaque;
    RangoDeAtaque rango;
    EstadoDeArmaDeAsedio estado;

    public ArmaDeAsedio(){

        this.tamanio = TAMANIO_UNIDAD;
        this.vida = VIDA_MAXIMA_ARMADEASEDIO;
        this.costo = COSTO_ARMADEASEDIO;
        this.distanciaDeAtaque = DISTANCIA_ATAQUE_ARMADEASEDIO;
        this.estado = new Desmontado();

    }

    private void validarMontura(){



    }

    public void atacarUnidad(Unidad unaUnidad) {

    }

    public void atacarEdificio(Edificio unEdificio) {

        //this.validarMontura();
        unEdificio.recibirDanio(ATAQUE_ARMADEASEDIO);

    }

    @Override
    public int obtenerDistanciaAtaque() {
        return distanciaDeAtaque;
    }

    @Override
    public void guardarRangoDeAtaque(RangoDeAtaque rango) {
        this.rango = rango;

    }

    @Override
    public void recibirDanio(int unDanio) {
        this.vida = vida - unDanio;
    }
}
