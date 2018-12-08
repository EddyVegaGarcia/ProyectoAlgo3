package fiuba.algo3.tp2.modelo.Juego;

import fiuba.algo3.tp2.modelo.Campo.*;

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

    }

/*
    public void jugar(){
        while (this.ganador == null) {
            //turno.jugar();
            this.verificarGanador();
        }

    }
    private void verificarGanador() {
        if (jugador1.castilloDestruido()) {
            this.ganador = jugador2;
        }
        else if (jugador2.castilloDestruido()) {
            this.ganador = jugador1;
        }
    }
    */

    public Jugador jugador1() {
        return jugador1;
    }

    public Jugador jugador2() {
        return jugador2;
    }

    public Jugador jugadorDeTuno() {
        return turno.jugadorDeTurno();

    }

    public void terminarTurno() {
        turno.termiarTurno();
    }
}