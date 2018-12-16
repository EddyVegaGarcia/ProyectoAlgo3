package fiuba.algo3.tp2;

import fiuba.algo3.tp2.modelo.Campo.Mapa;
import fiuba.algo3.tp2.modelo.Campo.*;
import fiuba.algo3.tp2.modelo.Direcciones.*;
import fiuba.algo3.tp2.modelo.Exception.*;
import fiuba.algo3.tp2.modelo.Exception.PiezaDestruidaException;
import fiuba.algo3.tp2.modelo.Interfaces.Montable;
import fiuba.algo3.tp2.modelo.Piezas.*;
import fiuba.algo3.tp2.modelo.Piezas.Unidades.*;
import org.junit.Test;

import static fiuba.algo3.tp2.modelo.Constantes.*;
import static fiuba.algo3.tp2.modelo.UnidadFactory.PiezaType.UNIDAD_ARMADEASEDIO;
import static org.junit.Assert.assertEquals;

public class ArmaDeAsedioTest {

    //test de recibir danio
    @Test
    public void testArmaDeAsedioRecibirDanioDeEspadachin() {

        Unidad armaDeAsedio = new ArmaDeAsedio();

        armaDeAsedio.recibirDanio(ATAQUE_ESPADACHIN_A_UNIDAD);

        int vidaEsperada = 125;
        assertEquals(vidaEsperada, armaDeAsedio.obtenerVida());

    }

    @Test
    public void testArmaDeAsedioRecibirDanioDeArquero() {

        Unidad armaDeAsedio = new ArmaDeAsedio();

        armaDeAsedio.recibirDanio(ATAQUE_ARQUERO_A_UNIDAD);

        int vidaEsperada = 135;
        assertEquals(vidaEsperada, armaDeAsedio.obtenerVida());

    }

    @Test
    public void testArmaDeAsedioRecibirDanioDeCastillo() {

        Unidad armaDeAsedio = new ArmaDeAsedio();

        armaDeAsedio.recibirDanio(ATAQUE_CASTILLO);

        int vidaEsperada = 130;
        assertEquals(vidaEsperada, armaDeAsedio.obtenerVida());

    }

    @Test (expected = PiezaDestruidaException.class)
    public void testArmaDeAsedioRecibeDanioDeEspadachinDosVecesYMuere() {

        Unidad armaDeAsedio = new ArmaDeAsedio();

        armaDeAsedio.recibirDanio(ATAQUE_ESPADACHIN_A_UNIDAD);
        armaDeAsedio.recibirDanio(ATAQUE_ESPADACHIN_A_UNIDAD);
        armaDeAsedio.recibirDanio(ATAQUE_ESPADACHIN_A_UNIDAD);
        armaDeAsedio.recibirDanio(ATAQUE_ESPADACHIN_A_UNIDAD);
        armaDeAsedio.recibirDanio(ATAQUE_ESPADACHIN_A_UNIDAD);
        armaDeAsedio.recibirDanio(ATAQUE_ESPADACHIN_A_UNIDAD);

    }

    //tests de mover
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
        ((ArmaDeAsedio) armaDeAsedio).refrescar();
        armaDeAsedio.desmontar();

        int tiempoEsperado = 0;
        assertEquals(tiempoEsperado, ((ArmaDeAsedio) armaDeAsedio).obtenerTiempoEsperado());

    }

    @Test(expected = ArmaDeAsedioMontadaSinMovimientoException.class)
    public void testMoverArmaDeAsedioEnEstadoMontado() {

        Montable unArmaDeAsedio = new ArmaDeAsedio();

        unArmaDeAsedio.montar();
        ((ArmaDeAsedio) unArmaDeAsedio).refrescar();
        ((ArmaDeAsedio) unArmaDeAsedio).movimientoPosible();

    }

    //tests de getters

    @Test
    public void testObtenerNombreDevuelveArmaDeAsedio(){
        ArmaDeAsedio armaDeAsedio =  new ArmaDeAsedio();
        assertEquals("ArmaDeAsedio", armaDeAsedio.obtenerNombre());
    }

    @Test
    public void testGetTamanioDevuelve1(){
        ArmaDeAsedio armaDeAsedio =  new ArmaDeAsedio();

        assertEquals((long)1, (long)armaDeAsedio.getTamanio());
    }

    @Test
    public void testObtenerTypeDevuelveUnidadArmaDeAsedio(){
        ArmaDeAsedio armaDeAsedio =  new ArmaDeAsedio();
        assertEquals(UNIDAD_ARMADEASEDIO, armaDeAsedio.obtenerType());
    }

    @Test
    public void testObtenerDistanciaDeAtaque(){
        ArmaDeAsedio armaDeAsedio =  new ArmaDeAsedio();
        assertEquals(5, armaDeAsedio.obtenerDistanciaAtaque());
    }
}
