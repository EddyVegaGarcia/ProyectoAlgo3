package fiuba.algo3.tp2;

import fiuba.algo3.tp2.modelo.*;

import java.util.ArrayList;
import java.util.List;

public class Juego {

    private static List<Jugador> jugadores = new ArrayList<>();
    private static boolean finalizado = false;
    private Mapa mapa;
    private static Jugador perdedor = null;

    public Juego() {

        mapa = new Mapa();

        jugadores.add(new Jugador("xxxs", this));
        jugadores.add(new Jugador("lsl", this));
    }

    public static Jugador perdedor() {
        return perdedor;
    }

    public static Jugador ganador() {
        if(perdedor == jugadores.get(1)) return jugadores.get(2);
        return jugadores.get(1);
    }

    public Jugador jugador(int numeroDeJugador) {
            return jugadores.get(numeroDeJugador-1);
    }

    public boolean estaFinalizado() {
        return finalizado;
    }

    public void perdi(Jugador jugador) {
        finalizado = true;
        perdedor = jugador;
    }

    public void agregarJugador(Jugador unJugador) {
        jugadores.add(unJugador);
    }

    public int cantidadDeJugadores() {
        return jugadores.size();
    }
}
