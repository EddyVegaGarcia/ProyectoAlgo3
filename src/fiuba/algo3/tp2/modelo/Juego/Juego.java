package fiuba.algo3.tp2.modelo.Juego;

import fiuba.algo3.tp2.modelo.Campo.*;
import fiuba.algo3.tp2.modelo.Exception.*;
import fiuba.algo3.tp2.modelo.Interfaces.Atacante;
import fiuba.algo3.tp2.modelo.Interfaces.Constructor;
import fiuba.algo3.tp2.modelo.Interfaces.Diseñador;
import fiuba.algo3.tp2.modelo.Piezas.Edificio;
import fiuba.algo3.tp2.modelo.Piezas.Edificios.Castillo;
import fiuba.algo3.tp2.modelo.Piezas.Pieza;
import fiuba.algo3.tp2.modelo.Piezas.Unidad;
import fiuba.algo3.tp2.modelo.UnidadFactory.PiezaType;
import javafx.geometry.Pos;

import java.util.ArrayList;

import static fiuba.algo3.tp2.modelo.Constantes.*;

public class Juego{

    private Jugador jugador1, jugador2;
    private Jugador ganador;
    private Mapa mapa;
    private Turno turno;

    private void colocarPiezasPorDefault(){

        jugador1.ubicarAldeanosPorDefault(POSICION_DEFAULT_ALDEANO1_1,
                POSICION_DEFAULT_ALDEANO1_2,
                POSICION_DEFAULT_ALDEANO1_3);

        jugador2.ubicarAldeanosPorDefault(POSICION_DEFAULT_ALDEANO2_1,
                POSICION_DEFAULT_ALDEANO2_2,
                POSICION_DEFAULT_ALDEANO2_3);

        jugador1.ubicarEdificiosPorDefault(POSICION_DEFAULT_CASTILLO1, POSICION_DEFAULT_PLAZA1);
        jugador2.ubicarEdificiosPorDefault(POSICION_DEFAULT_CASTILLO2, POSICION_DEFAULT_PLAZA2);

    }

    public Juego(String nombre1, String nombre2) {

        this.mapa = new Mapa();
        this.jugador1 = new Jugador(nombre1, mapa);
        this.jugador2 = new Jugador(nombre2, mapa);
        this.turno = new Turno(jugador1, jugador2);
        this.ganador = null;

        this.colocarPiezasPorDefault();
    }

    public Mapa mapa() {
    return mapa;
}

    public Jugador jugador1() {
        return jugador1;
    }

    public Jugador jugador2() {
        return jugador2;
    }

    public Jugador jugadorDeTurno() {

        return turno.jugadorDeTurno();

    }

    public void terminarTurno() {

        turno.terminarTurno(this);

    }

    public void colocarUnidad(Diseñador piezaConstructora, double fila, double columna, PiezaType unidadType) {

        Posicion posicion = new Posicion((int)fila, (int)columna);
        jugadorDeTurno().validarPoblacionMaxima();
        this.validarDistanciaDeCreacion(posicion, (Edificio) piezaConstructora);
        mapa.validarPosicion(posicion);

        Unidad unaUnidad = (Unidad) piezaConstructora.colocarPieza(unidadType, jugadorDeTurno());

        mapa.colocarPieza(unaUnidad, posicion);

        jugadorDeTurno().agregarPoblacion(unaUnidad);
        jugadorDeTurno().agregaPieza(unaUnidad);

    }

    public void colocarEdificio(Diseñador piezaConstructora, double fila, double columna, PiezaType piezaType) {

        Posicion posicion = new Posicion((int)fila, (int)columna);

        ArrayList<Posicion> unaLista = mapa.generarLista(posicion, TAMANIO_CUARTEL);

        for(Posicion unaPosicion : unaLista){

            mapa.validarPosicion(unaPosicion);

        }

        Edificio unEdificio = (Edificio) piezaConstructora.colocarPieza(piezaType, jugadorDeTurno());

        mapa.colocarPieza(unEdificio, posicion);

        jugadorDeTurno().agregaPieza(unEdificio);

    }

    private void validarDistanciaDeCreacion(Posicion posicion, Edificio edificio) {

        Posicion unaPosicion = edificio.obtenerPosicion();

        if( !unaPosicion.estaContenidaEnRango1(posicion, edificio.obtenerTamanio())) {

            throw new PosicionDeCreacionInvalidaException();
        }
    }

    public void construirEdificio(Constructor piezaConstructora, double fila, double columna, PiezaType piezaType) {

        Posicion posicion = new Posicion((int)fila, (int)columna);

        Edificio unEdificio = (Edificio) mapa.recuperarPieza(posicion);

        this.validarDistanciaDeCreacion(((Pieza)piezaConstructora).obtenerPosicion(), unEdificio);

        piezaConstructora.construir(unEdificio);

    }

    public void atacar(Posicion unaPosicion, Atacante unaPiezaAtacante) {

        Pieza unaPieza = mapa.recuperarPieza(unaPosicion);

        if (unaPieza == null)
            throw new PosicionAtacadaSinResultadosException();
        else
            if(!jugadorDeTurno().sosDuenioDe(unaPieza)){
                unaPiezaAtacante.atacarPieza(unaPieza);
            }
            else
                throw new PiezaAtacadaPertenecienteException();

    }

    public void reparar(Posicion unaPosicion, Constructor unaPiezaReparadora) {

        Pieza unaPieza = mapa.recuperarPieza(unaPosicion);

        if(unaPieza == null)
            throw new PosicionReparadaSinResultadosException();
        else
        if(jugadorDeTurno().sosDuenioDe(unaPieza))
            unaPiezaReparadora.repararPieza(unaPieza);
        else
            throw new PiezaReaparadaPertenecienteAlEnemigoException();

    }

    public void actualizarPiezas() {

        jugador1.actualizarPiezas();
        jugador2.actualizarPiezas();

    }

    public boolean finalizado() {
        if(turno.jugadorEnEspera().vida() <= 0){
            ganador = jugadorDeTurno();
            return true;
        }
        return false;
    }

    public Jugador ganador() {
        return ganador;
    }

}