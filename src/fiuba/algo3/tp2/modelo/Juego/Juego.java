package fiuba.algo3.tp2.modelo.Juego;

import fiuba.algo3.tp2.modelo.Campo.*;
import fiuba.algo3.tp2.modelo.Exception.PosicionDeCreacionInvalidaException;
import fiuba.algo3.tp2.modelo.Interfaces.Diseñador;
import fiuba.algo3.tp2.modelo.Piezas.Edificio;
import fiuba.algo3.tp2.modelo.Piezas.Pieza;
import fiuba.algo3.tp2.modelo.Piezas.Unidad;
import fiuba.algo3.tp2.modelo.UnidadFactory.PiezaType;
import java.util.ArrayList;

import static fiuba.algo3.tp2.modelo.Campo.Constantes.*;

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
        //turno.jugadorDeTurno().recolectarOro();
    }


/*
    private void verificarGanador() {
        if (jugador1.castilloDestruido()) {
            this.ganador = jugador2;
        }
        else if (jugador2.castilloDestruido()) {
            this.ganador = jugador1;
        }
    }
    */
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
        turno.terminarTurno();
    }

    public void crearUnidad(Diseñador piezaConstructora, double fila, double columna, PiezaType unidadType) {

        Posicion posicion = new Posicion((int)fila, (int)columna);
        validarDistanciaDeCreacion(posicion, (Edificio) piezaConstructora);
        mapa.validarPosicion(posicion);

        Unidad unaUnidad = (Unidad) piezaConstructora.crearPieza(unidadType, jugadorDeTurno());

        mapa.colocarPieza(unaUnidad, posicion);

        jugadorDeTurno().agregarPoblacion(unaUnidad);
        jugadorDeTurno().agregaPieza(unaUnidad);

    }

    public void crearEdificio(Diseñador piezaConstructora, double fila, double columna, PiezaType piezaType) {

        Posicion posicion = new Posicion((int)fila, (int)columna);

        ArrayList<Posicion> unaLista = mapa.generarLista(posicion, TAMANIO_CUARTEL);

        for(Posicion unaPosicion : unaLista){

            mapa.validarPosicion(unaPosicion);

        }

        Edificio unEdificio = (Edificio) piezaConstructora.crearPieza(piezaType, jugadorDeTurno());

        mapa.colocarPieza(unEdificio, posicion);

        jugadorDeTurno().agregaPieza(unEdificio);

    }

    private void validarDistanciaDeCreacion(Posicion posicion, Edificio edificio) {
        Posicion unaPosicion = edificio.obtenerPosicion();

        if( !unaPosicion.validacionPosicionValida(posicion, edificio.obtenerTamanio())) {

            throw new PosicionDeCreacionInvalidaException();
        }
    }
}