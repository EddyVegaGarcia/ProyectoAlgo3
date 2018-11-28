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
        jugador.ubicarAldeanosPorDefault(POSICION_DEFAULT_ALDEANO1_1,POSICION_DEFAULT_ALDEANO2_1,POSICION_DEFAULT_ALDEANO3_1);
        jugador.ubicarEdificiosPorDefault(POSICION_DEFAULT_CASTILLO1,POSICION_DEFAULT_PLAZA1);

        Assert.assertEquals("victor", jugador.obtenerNombre());
        Assert.assertEquals(100, jugador.obtenerOro());
        Assert.assertEquals(3, jugador.cantidadDePoblacion());
        Assert.assertFalse(jugador.castilloDestruido());
    }
/*
    @Test
    public void testJugadorCompraAldeanoDeCuartel() {
        Jugador jugador = new Jugador("victor", new Mapa(FILA_DEFAULT_MAPA, COLUMNA_DEFAULT_MAPA));
        jugador.ubicarAldeanosPorDefault(POSICION_DEFAULT_ALDEANO1_1,POSICION_DEFAULT_ALDEANO2_1,POSICION_DEFAULT_ALDEANO3_1);
        jugador.ubicarEdificiosPorDefault(POSICION_DEFAULT_CASTILLO1,POSICION_DEFAULT_PLAZA1);

        jugador.comprarAldeano(POSICION_DEFAULT_PLAZA1);

        Assert.assertEquals(4, jugador.cantidadDePoblacion());
    }

    @Test(expected = OroInsuficienteException.class)
    public void testJugadorCompraAldeanoYEdificioLanzaError() {
        Jugador jugador = new Jugador("victor", new Mapa(FILA_DEFAULT_MAPA, COLUMNA_DEFAULT_MAPA));
        jugador.ubicarAldeanosPorDefault(POSICION_DEFAULT_ALDEANO1_1,POSICION_DEFAULT_ALDEANO2_1,POSICION_DEFAULT_ALDEANO3_1);
        jugador.ubicarEdificiosPorDefault(POSICION_DEFAULT_CASTILLO1,POSICION_DEFAULT_PLAZA1);

        jugador.comprarAldeano(POSICION_DEFAULT_PLAZA1);
        jugador.comprarPlazaCentral(POSICION_DEFAULT_PLAZA2);

    }
*/

}