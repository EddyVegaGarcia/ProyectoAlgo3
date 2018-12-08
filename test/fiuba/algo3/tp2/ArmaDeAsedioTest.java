package fiuba.algo3.tp2;

import fiuba.algo3.tp2.modelo.Exception.PiezaDestruidaException;
import fiuba.algo3.tp2.modelo.Interfaces.Montable;
import fiuba.algo3.tp2.modelo.Piezas.Unidad;
import fiuba.algo3.tp2.modelo.Piezas.Unidades.Aldeano;
import fiuba.algo3.tp2.modelo.Piezas.Unidades.ArmaDeAsedio;
import org.junit.Test;

import static fiuba.algo3.tp2.modelo.Campo.Constantes.*;
import static org.junit.Assert.assertEquals;

public class ArmaDeAsedioTest {

    @Test
    public void testArmaDeAsedioRecibirDanioDeEspadachin() {

        Unidad armaDeAsedio = new ArmaDeAsedio();

        armaDeAsedio.recibirDanio(ATAQUE_ESPADACHIN_A_UNIDAD);

        int vidaEsperada = 125;
        assertEquals(vidaEsperada, armaDeAsedio.obtenerVida());

    }

    @Test
    public void testAldeanoRecibirDanioDeArquero() {

        Unidad armaDeAsedio = new ArmaDeAsedio();

        armaDeAsedio.recibirDanio(ATAQUE_ARQUERO_A_UNIDAD);

        int vidaEsperada = 135;
        assertEquals(vidaEsperada, armaDeAsedio.obtenerVida());

    }

    @Test
    public void testAldeanoRecibirDanioDeCastillo() {

        Unidad armaDeAsedio = new ArmaDeAsedio();

        armaDeAsedio.recibirDanio(ATAQUE_CASTILLO);

        int vidaEsperada = 130;
        assertEquals(vidaEsperada, armaDeAsedio.obtenerVida());

    }

    @Test (expected = PiezaDestruidaException.class)
    public void testAldeanoRecibeDanioDeEspadachinDosVecesYMuere() {

        Unidad armaDeAsedio = new ArmaDeAsedio();

        armaDeAsedio.recibirDanio(ATAQUE_ESPADACHIN_A_UNIDAD);
        armaDeAsedio.recibirDanio(ATAQUE_ESPADACHIN_A_UNIDAD);
        armaDeAsedio.recibirDanio(ATAQUE_ESPADACHIN_A_UNIDAD);
        armaDeAsedio.recibirDanio(ATAQUE_ESPADACHIN_A_UNIDAD);
        armaDeAsedio.recibirDanio(ATAQUE_ESPADACHIN_A_UNIDAD);
        armaDeAsedio.recibirDanio(ATAQUE_ESPADACHIN_A_UNIDAD);

    }

    @Test
    public void testMontarArmaDeAsedioConContadorIniciado() {

        Montable armaDeAsedio = new ArmaDeAsedio();

        armaDeAsedio.montar();

        int tiempoEsperado = 1;
        assertEquals(tiempoEsperado, ((ArmaDeAsedio) armaDeAsedio).obtenerTiempoEsperado());

    }

    @Test
    public void testDesmontarArmaDeAsedioReiniciandoElContador() {

        Montable armaDeAsedio = new ArmaDeAsedio();

        armaDeAsedio.montar();
        armaDeAsedio.desmontar();

        int tiempoEsperado = 0;
        assertEquals(tiempoEsperado, ((ArmaDeAsedio) armaDeAsedio).obtenerTiempoEsperado());

    }
}
