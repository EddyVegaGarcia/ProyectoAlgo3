package fiuba.algo3.tp2;

import fiuba.algo3.tp2.modelo.*;
import org.junit.Assert;
import org.junit.Test;
import static fiuba.algo3.tp2.modelo.Constantes.*;

public class JugadorTest {


    @Test
    public void testJugadorInicializacion(){
        Jugador jugador = new Jugador("victor", new Mapa(FILA_DEFAULT_MAPA, COLUMNA_DEFAULT_MAPA));
        /* UBICO POR DEFAULT A SU CASTILLO, PLAZA Y SUS ALDEANOS*/
        jugador.ubicarAldeanos(POSICION_DEFAULT_ALDEANO1_1,POSICION_DEFAULT_ALDEANO2_1,POSICION_DEFAULT_ALDEANO3_1);
        jugador.ubicarEdificios(POSICION_DEFAULT_CASTILLO1,POSICION_DEFAULT_PLAZA1);

        Assert.assertEquals("victor", jugador.obtenerNombre());
        Assert.assertEquals(100, jugador.obtenerOro());
        Assert.assertEquals(3, jugador.cantidadDePoblacion());
        Assert.assertFalse(jugador.castilloDestruido());
    }

    @Test
    public void testJugadorCompraAldeanoYEdificioValido() {
        Jugador jugador = new Jugador("victor", new Mapa(FILA_DEFAULT_MAPA, COLUMNA_DEFAULT_MAPA));
        jugador.ubicarAldeanos(POSICION_DEFAULT_ALDEANO1_1,POSICION_DEFAULT_ALDEANO2_1,POSICION_DEFAULT_ALDEANO3_1);
        jugador.ubicarEdificios(POSICION_DEFAULT_CASTILLO1,POSICION_DEFAULT_PLAZA1);

        jugador.comprarAldeano(new Posicion(26,5));
        jugador.construirCuartel(new Posicion(27,5));

        Assert.assertEquals(25, jugador.obtenerOro());
    }

    @Test(expected = NoHaySuficienteOroException.class)
    public void testJugadorCompraAldeanoYEdificioLanzaError() {
        Jugador jugador = new Jugador("victor", new Mapa(FILA_DEFAULT_MAPA, COLUMNA_DEFAULT_MAPA));
        jugador.ubicarAldeanos(POSICION_DEFAULT_ALDEANO1_1,POSICION_DEFAULT_ALDEANO2_1,POSICION_DEFAULT_ALDEANO3_1);
        jugador.ubicarEdificios(POSICION_DEFAULT_CASTILLO1,POSICION_DEFAULT_PLAZA1);

        jugador.comprarAldeano(new Posicion(26,5));
        jugador.construirPlazaCentral(new Posicion(27,5));

    }

    

}