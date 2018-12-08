package fiuba.algo3.tp2.modelo.Juego;

public class Turno {

    private Jugador jugador1, jugador2;

    public Jugador jugadorEnJuego;

    public Turno(Jugador jugador1, Jugador jugador2){

        this.jugador1 = jugador1;
        this.jugador2 = jugador2;

        this.jugadorEnJuego = jugador1;

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


        jugador1.jugar();
        jugador2.jugar();

        Jugador ultimoJugador = jugador2;

        jugadorEnJuego = ultimoJugador;

        return jugadorEnJuego;

    }

    public void termiarTurno(){
        if( jugadorEnJuego == jugador1 )
            jugadorEnJuego = jugador2;
        else
            jugadorEnJuego = jugador1;
    }

}
