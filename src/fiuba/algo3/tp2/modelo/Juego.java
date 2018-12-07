package fiuba.algo3.tp2.modelo;

import static fiuba.algo3.tp2.modelo.Constantes.*;

public class Juego{

    private Jugador jugador1, jugador2;
    private Jugador ganador;
    private Mapa mapa;
    private Turno turno;

    public Juego(String nombre1, String nombre2) {

        this.mapa = new Mapa();
        this.jugador1 = new Jugador(nombre1, mapa);
        this.jugador2 = new Jugador(nombre2, mapa);
        this.turno = new Turno(jugador1, jugador2);
        this.ganador = null;

        //jugador1.ubicarCastilloPorDefault();
        //jugador1.ubicarAldeanosPorDefault(POSICION_DEFAULT_ALDEANO1_1,
         //       POSICION_DEFAULT_ALDEANO1_2, POSICION_DEFAULT_ALDEANO1_3);


        jugador1.ubicarEdificiosPorDefault(new Posicion(31,17),
                                           new Posicion(20,25));

        jugador2.ubicarEdificiosPorDefault(new Posicion(1,17),
                                           new Posicion(15,25));
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
}