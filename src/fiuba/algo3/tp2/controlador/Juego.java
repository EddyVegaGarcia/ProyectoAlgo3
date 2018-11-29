package fiuba.algo3.tp2.controlador;

import fiuba.algo3.tp2.modelo.*;
import fiuba.algo3.tp2.modelo.Exception.OroInsuficienteException;

import static fiuba.algo3.tp2.modelo.Constantes.*;

public class Juego{

    private Jugador jugador1, jugador2;
    private Jugador ganador;
    private Mapa mapa;
    private Turno turno;

    public Juego(String nombre1, String nombre2) {

        this.mapa = new Mapa(FILA_DEFAULT_MAPA, COLUMNA_DEFAULT_MAPA);
        this.jugador1 = new Jugador(nombre1, mapa);
        this.jugador2 = new Jugador(nombre2, mapa);
        this.turno = new Turno(jugador1, jugador2);
        this.ganador = null;

        jugador1.asignarEstadoHabilitado();
    }

    public boolean estaFinalizado() {
        return ganador != null;
    }

    public void jugar(){
        while (!this.estaFinalizado()){


        }
    }

    

}