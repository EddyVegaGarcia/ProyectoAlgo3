package fiuba.algo3.tp2;

import fiuba.algo3.tp2.modelo.Campo.Mapa;
import fiuba.algo3.tp2.modelo.Juego.Jugador;
import fiuba.algo3.tp2.modelo.Piezas.*;
import fiuba.algo3.tp2.modelo.Piezas.Edificios.*;
import fiuba.algo3.tp2.modelo.Exception.*;
import fiuba.algo3.tp2.modelo.UnidadFactory.*;
import org.junit.Test;
import static fiuba.algo3.tp2.modelo.Constantes.*;
import static org.junit.Assert.assertEquals;

public class CastilloTest {

    @Test
    public void testCastilloCreaArmaDeAsedio(){
        Jugador jugador = new Jugador("loo", new Mapa());

        Edificio castillo = new Castillo();

        Unidad armaDeAsedio = ((Castillo) castillo).colocarPieza(PiezaType.UNIDAD_ARMADEASEDIO, jugador);

        int vidaEsperada = 150;
        assertEquals(vidaEsperada, armaDeAsedio.obtenerVida());

    }

    @Test (expected = InvalidUnidadTypeException.class)
    public void testCrearUnidadIncorrectaDeEspadachinEnCastillo() {

        Jugador jugador = new Jugador("loo", new Mapa());
        Edificio castillo = new Castillo();

        Unidad armaDeAsedio = ((Castillo) castillo).colocarPieza(PiezaType.UNIDAD_ESPADACHIN, jugador);
    }

    @Test
    public void testCastilloRecibeDanioDeEspadachin() {

        Edificio castillo = new Castillo();

        castillo.recibirDanio(ATAQUE_ESPADACHIN_A_EDIFICIO);

        int vidaEsperada = 985;
        assertEquals(vidaEsperada, castillo.obtenerVida());

    }

    @Test
    public void testCastilloRecibeDanioDeArquero() {

        Edificio castillo = new Castillo();

        castillo.recibirDanio(ATAQUE_ARQUERO_A_EDIFICIO);

        int vidaEsperada = 990;
        assertEquals(vidaEsperada, castillo.obtenerVida());

    }

    @Test
    public void testCastilloRecibeDanioDeArmaDeAsedio() {

        Edificio castillo = new Castillo();

        castillo.recibirDanio(ATAQUE_ARMADEASEDIO);

        int vidaEsperada = 925;
        assertEquals(vidaEsperada, castillo.obtenerVida());

    }

    @Test
    public void testCastilloRecibeDanioDeEspadachinArqueroYArmaDeAsedio() {

        Edificio castillo = new Castillo();

        castillo.recibirDanio(ATAQUE_ESPADACHIN_A_EDIFICIO);
        castillo.recibirDanio(ATAQUE_ARQUERO_A_EDIFICIO);
        castillo.recibirDanio(ATAQUE_ARMADEASEDIO);

        int vidaEsperada = 900;
        assertEquals(vidaEsperada, castillo.obtenerVida());

    }

}
