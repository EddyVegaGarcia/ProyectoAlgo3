package fiuba.algo3.tp2.modelo.Juego;

import java.util.Random;

public class Turno {

    private Jugador jugador1, jugador2;

    public Jugador jugadorEnJuego;

    public Turno(Jugador jugador1, Jugador jugador2){

        this.jugador1 = jugador1;
        this.jugador2 = jugador2;

        this.iniciarJugadorRandom();

    }

    private void iniciarJugadorRandom() {

        Random generadorRandom = new Random();

        int numeroAleatorio = generadorRandom.nextInt();

        if(numeroAleatorio % 2 == 0)
            jugadorEnJuego = jugador2;
        else
            jugadorEnJuego = jugador1;

    }

    public Jugador jugadorDeTurno(){

        return jugadorEnJuego;

    }

/*
    private void cobrar(int costo, Jugador jugador) {
        int oro = jugador.obtenerOro();
        if (oro < costo) {
            throw new OroInsuficienteException();
        }
        jugador.cobrarOro(costo);
    }
*/
    public Jugador jugar() {

        /*jugador1.jugar();
        jugador2.jugar();*/

        Jugador ultimoJugador = jugador2;

        jugadorEnJuego = ultimoJugador;

        return jugadorEnJuego;

    }

    public void terminarTurno(){

        jugadorEnJuego.recolectarOro();
        jugadorEnJuego.refrescarPiezas();
        if( jugadorEnJuego == jugador1 )
            jugadorEnJuego = jugador2;
        else
            jugadorEnJuego = jugador1;

    }

}
