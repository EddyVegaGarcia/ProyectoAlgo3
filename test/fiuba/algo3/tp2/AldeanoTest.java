package fiuba.algo3.tp2;

import fiuba.algo3.tp2.modelo.Interfaces.*;
import fiuba.algo3.tp2.modelo.Piezas.*;
import fiuba.algo3.tp2.modelo.Piezas.Unidades.*;
import fiuba.algo3.tp2.modelo.Piezas.Edificios.*;
import org.junit.Test;

import fiuba.algo3.tp2.modelo.Exception.*;

import static fiuba.algo3.tp2.modelo.Campo.Constantes.*;
import static junit.framework.TestCase.assertTrue;
import static org.junit.Assert.assertEquals;

public class AldeanoTest {

    @Test
    public void testAldeanoConstruyeCuartelYCambiaDeEstadoAEstaTrabajando() {

        Constructor unAldeano = new Aldeano();
        Edificio unCuartel = new Cuartel();

        unAldeano.construir(unCuartel);

        assertTrue(unAldeano.estaTrabajando());

    }

    @Test(expected = ConstruccionCastilloException.class)
    public void testAldeanoNoPuedeConstruirCastilloYaQueNoEsUnEdificioConstruible() {

        Constructor unAldeano = new Aldeano();
        Edificio unCastillo = new Castillo();

        unAldeano.construir(unCastillo);

    }

    @Test
    public void testAldeanoRecibirDanioDeEspadachin() {

        Unidad aldeano = new Aldeano();

        aldeano.recibirDanio(ATAQUE_ESPADACHIN_A_UNIDAD);

        int vidaEsperada = 25;
        assertEquals(vidaEsperada, aldeano.obtenerVida());

    }

    @Test
    public void testAldeanoRecibirDanioDeArquero() {

        Unidad aldeano = new Aldeano();

        aldeano.recibirDanio(ATAQUE_ARQUERO_A_UNIDAD);

        int vidaEsperada = 35;
        assertEquals(vidaEsperada, aldeano.obtenerVida());

    }

    @Test
    public void testAldeanoRecibirDanioDeCastillo() {

        Unidad aldeano = new Aldeano();

        aldeano.recibirDanio(ATAQUE_CASTILLO);

        int vidaEsperada = 30;
        assertEquals(vidaEsperada, aldeano.obtenerVida());

    }

    @Test (expected = PiezaDestruidaException.class)
    public void testAldeanoRecibeDanioDeEspadachinDosVecesYMuere() {

        Unidad aldeano = new Aldeano();

        aldeano.recibirDanio(ATAQUE_ESPADACHIN_A_UNIDAD);
        aldeano.recibirDanio(ATAQUE_ESPADACHIN_A_UNIDAD);

    }
}