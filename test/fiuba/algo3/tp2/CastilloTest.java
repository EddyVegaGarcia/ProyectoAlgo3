package fiuba.algo3.tp2;


import fiuba.algo3.tp2.modelo.*;
import org.junit.Test;
import static fiuba.algo3.tp2.modelo.Constantes.*;
import static org.junit.Assert.assertEquals;

public class CastilloTest {
    @Test
    public void testCastilloCreaArmaDeAsedio(){

        Edificio castillo = new Castillo();

        Unidad armaDeAsedio = castillo.crearUnidad(UnidadType.UNIDAD_ARMADEASEDIO);

        int vidaEsperada = 150;
        assertEquals(vidaEsperada, armaDeAsedio.obtenerVida());

    }

    @Test (expected = InvalidUnidadTypeException.class)
    public void testCrearUnidadIncorrectaDeEspadachinEnCastillo() {

        Edificio castillo = new Castillo();

        Unidad armaDeAsedio = castillo.crearUnidad(UnidadType.UNIDAD_ESPADACHIN);

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
