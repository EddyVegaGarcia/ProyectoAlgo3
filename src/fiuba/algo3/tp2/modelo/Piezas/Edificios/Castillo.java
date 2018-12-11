package fiuba.algo3.tp2.modelo.Piezas.Edificios;

import fiuba.algo3.tp2.controlador.MouseEventHandler;
import fiuba.algo3.tp2.modelo.*;
import fiuba.algo3.tp2.modelo.Estados.*;
import fiuba.algo3.tp2.modelo.Piezas.Pieza;
import fiuba.algo3.tp2.modelo.Interfaces.*;
import fiuba.algo3.tp2.modelo.Exception.*;
import fiuba.algo3.tp2.modelo.Piezas.*;
import fiuba.algo3.tp2.modelo.UnidadFactory.*;

import java.util.ArrayList;

import static fiuba.algo3.tp2.modelo.Campo.Constantes.*;

public class Castillo extends Edificio implements Atacante {

    public RangoDeAtaque rangoDeAtaque;

    public Castillo() {
        this.vida = VIDA_MAXIMA_CASTILLO;
        this.tamanio = TAMANIO_CASTILLO;
        this.estado = new Construido();
    }

    @Override
    public int obtenerDistanciaAtaque() { return DISTANCIA_ATAQUE_CASTILLO; }

    @Override
    public void guardarRangoDeAtaque(RangoDeAtaque rango) {
        this.rangoDeAtaque = rango;
    }

    public void atacarUnidad(Unidad unidad) {
        unidad.recibirDanio(ATAQUE_CASTILLO);
    }

    public void atacar(ArrayList<Pieza> unasPiezas) {


      /*  List<Posicion> posicionesDeEnemigos = rangoDeAtaque.obtenerRangoDeAtaque(this, POSICION_DEFAULT_CASTILLO1);

        for (Posicion posActual : posicionesDeEnemigos) {


        }
        */
    }

    @Override
    public Unidad crearUnidad(UnidadType unidadType) {

        if (unidadType == UnidadType.UNIDAD_ARMADEASEDIO)
            return UnidadesFactory.crearUnidad(unidadType);
        else
            throw new InvalidUnidadTypeException();

    }

    @Override
    public void recibirDanio(int unDanio) {
        this.vida = vida - unDanio;
    }

    @Override
    public boolean sosPlazaCentral() {
        return false;
    }

    @Override
    public boolean sosAldeano() {
        return false;
    }


    @Override
    public boolean sosArmaAsedio() {
        return false;
    }

    @Override
    public String nombre() {
        return "Castillo";
    }

    @Override
    public boolean podesMoverte() {
        return false;
    }

    @Override
    public boolean podesAtacar() {
        return true;
    }

    @Override
    public boolean podesConstruirArmaDeAsedio() {
        return true;
    }

    @Override
    public boolean podesDesmontarArmaAsedio() {
        return false;
    }

    @Override
    public boolean podesCrearUnAldeano() {
        return false;
    }

    @Override
    public boolean podesReparar() {
        return false;
    }

    @Override
    public double getTamanio() {
        return tamanio;
    }

    @Override
    public int oroRecolectado() {
        return 0;
    }


    @Override
    public void atacarEdificio(Edificio unEdificio) {

    }

    @Override
    public void darVidaPorReparacion() {
        this.vida = vida + VIDA_REPARACION;
    }
}
