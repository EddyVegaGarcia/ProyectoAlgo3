package fiuba.algo3.tp2;

import fiuba.algo3.tp2.modelo.Campo.Mapa;
import fiuba.algo3.tp2.modelo.Juego.Juego;
import fiuba.algo3.tp2.modelo.Juego.Jugador;
import fiuba.algo3.tp2.modelo.Juego.Turno;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class TurnoTest {
    @Test
    public void testTerminarTurnoCambiarElTurnoAlOtroJugador(){
        Juego juego =  new Juego("victor", "Juan");
        Jugador jugador1 = juego.jugador1();
        Jugador jugador2 = juego.jugador2();
        Turno turno =  new Turno(jugador1, jugador2);

        if(turno.jugadorDeTurno() == jugador1){
            turno.terminarTurno(juego);
            assertEquals(jugador2, turno.jugadorDeTurno());
        }else{
            turno.terminarTurno(juego);
            assertEquals(jugador1, turno.jugadorDeTurno());
        }
    }

    @Test
    public void testJugadorEnEsperaDevuelveElJugadorQueNoEstaDeTurno(){
        Jugador jugador1 = new Jugador("Victor", new Mapa());
        Jugador jugador2 = new Jugador("Juan", new Mapa());
        Turno turno =  new Turno(jugador1, jugador2);

        assertTrue(turno.jugadorDeTurno() != turno.jugadorEnEspera());
    }


}
