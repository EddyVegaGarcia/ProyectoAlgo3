package fiuba.algo3.tp2;

import fiuba.algo3.tp2.modelo.*;
import org.junit.Test;

import static fiuba.algo3.tp2.modelo.Constantes.*;
import static org.junit.Assert.assertEquals;

public class ArqueroTest {


    @Test
    public void testArquerochinRecibirDanioDeEspadachin() {

        Unidad arquero = new Arquero();

        arquero.recibirDanio(ATAQUE_ESPADACHIN_A_UNIDAD);

        int vidaEsperada = 50;
        assertEquals(vidaEsperada, arquero.obtenerVida());

    }

    @Test
    public void testArquerochinRecibirDanioDeOtroArquero() {

        Unidad arquero = new Arquero();

        arquero.recibirDanio(ATAQUE_ARQUERO_A_UNIDAD);

        int vidaEsperada = 60;
        assertEquals(vidaEsperada, arquero.obtenerVida());

    }

    @Test
    public void testArqueroRecibirDanioDeCastillo() {

        Unidad arquero = new Arquero();

        arquero.recibirDanio(ATAQUE_CASTILLO);

        int vidaEsperada = 55;
        assertEquals(vidaEsperada, arquero.obtenerVida());

    }

    @Test
    public void testArqueroRecibirDanioDeEspadachinOtroArqueroYCastillo() {

        Unidad arquero = new Arquero();

        arquero.recibirDanio(ATAQUE_ESPADACHIN_A_UNIDAD);
        arquero.recibirDanio(ATAQUE_ARQUERO_A_UNIDAD);
        arquero.recibirDanio(ATAQUE_CASTILLO);

        int vidaEsperada = 15;
        assertEquals(vidaEsperada, arquero.obtenerVida());

    }

}
