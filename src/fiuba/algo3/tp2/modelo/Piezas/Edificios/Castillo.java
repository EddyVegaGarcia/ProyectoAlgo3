package fiuba.algo3.tp2.modelo.Piezas.Edificios;

import fiuba.algo3.tp2.modelo.*;
import fiuba.algo3.tp2.modelo.Estados.*;
import fiuba.algo3.tp2.modelo.Juego.Jugador;
import fiuba.algo3.tp2.modelo.Piezas.Pieza;
import fiuba.algo3.tp2.modelo.Interfaces.*;
import fiuba.algo3.tp2.modelo.Exception.*;
import fiuba.algo3.tp2.modelo.Piezas.*;
import fiuba.algo3.tp2.modelo.UnidadFactory.*;

import java.util.ArrayList;

import static fiuba.algo3.tp2.modelo.Campo.Constantes.*;
import static fiuba.algo3.tp2.modelo.UnidadFactory.PiezaType.*;

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
    public Unidad crearUnidad(PiezaType piezaType, Jugador jugador) {

        if( jugador.oro < COSTO_ARMADEASEDIO ) throw new OroInsuficienteException();

        if (piezaType == PiezaType.UNIDAD_ARMADEASEDIO) {

            this.validarAcciones();
            this.accionesRealizadas++;

            jugador.pagar(COSTO_ARMADEASEDIO);
            return PiezaFactory.crearUnidad(piezaType);

        }
        else
            throw new InvalidUnidadTypeException();

    }

    @Override
    public PiezaType obtenerType() {
        return EDIFICIO_CASTILLO;
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

    @Override
    public String obtenerNombre() {
        return "Castillo";
    }
}
