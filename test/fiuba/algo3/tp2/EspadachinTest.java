package fiuba.algo3.tp2;

import fiuba.algo3.tp2.modelo.Piezas.*;
import fiuba.algo3.tp2.modelo.Piezas.Unidades.Espadachin;
import org.junit.Test;

import static fiuba.algo3.tp2.modelo.Constantes.*;
import static org.junit.Assert.assertEquals;

public class EspadachinTest {


    @Test
    public void testEspadachinRecibirDanioDeOtroEspadachin() {

        Unidad espadachin = new Espadachin();

        espadachin.recibirDanio(ATAQUE_ESPADACHIN_A_UNIDAD);

        int vidaEsperada = 75;
        assertEquals(vidaEsperada, espadachin.obtenerVida());

    }

    @Test
    public void testEspadachinRecibirDanioDeArquero() {

        Unidad espadachin = new Espadachin();

        espadachin.recibirDanio(ATAQUE_ARQUERO_A_UNIDAD);

        int vidaEsperada = 85;
        assertEquals(vidaEsperada, espadachin.obtenerVida());

    }

    @Test
    public void testEspadachinRecibirDanioDeCastillo() {

        Unidad espadachin = new Espadachin();

        espadachin.recibirDanio(ATAQUE_CASTILLO);

        int vidaEsperada = 80;
        assertEquals(vidaEsperada, espadachin.obtenerVida());

    }

    @Test
    public void testEspadachinRecibirDanioDeOtroEspadachinArqueroYCastillo() {

        Unidad espadachin = new Espadachin();

        espadachin.recibirDanio(ATAQUE_ESPADACHIN_A_UNIDAD);
        espadachin.recibirDanio(ATAQUE_ARQUERO_A_UNIDAD);
        espadachin.recibirDanio(ATAQUE_CASTILLO);

        int vidaEsperada = 40;
        assertEquals(vidaEsperada, espadachin.obtenerVida());

    }

}
