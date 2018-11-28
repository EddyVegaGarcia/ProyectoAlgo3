package fiuba.algo3.tp2.controlador;


import fiuba.algo3.tp2.modelo.*;
import fiuba.algo3.tp2.modelo.Exception.OroInsuficienteException;

public class Turno {

    private Jugador jugador1, jugador2;

    public Turno(Jugador jugador1, Jugador jugador2){
        this.jugador1 = jugador1;
        this.jugador2 = jugador2;
    }


    private void cobrar(int costo, Jugador jugador) {
        int oro = jugador.obtenerOro();
        if (oro < costo) {
            throw new OroInsuficienteException();
        }
        jugador.cobrarOro(costo);
    }

}
