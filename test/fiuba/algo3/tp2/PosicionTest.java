package fiuba.algo3.tp2;

import fiuba.algo3.tp2.modelo.Campo.Posicion;
import org.junit.Test;

import static junit.framework.TestCase.*;

public class PosicionTest {

    @Test
    public void testCompararPosicionesSimilares() {

        Posicion posicion1 = new Posicion(15,15);
        Posicion posicion2 = new Posicion(15,15);

        assertTrue(posicion1.compararPosicion(posicion2));

    }

    @Test
    public void testCompararPosicionesDiferentes() {

        Posicion posicion1 = new Posicion(15,15);
        Posicion posicion2 = new Posicion(16,16);

        assertFalse(posicion1.compararPosicion(posicion2));

    }

    @Test
    public void testPosicionEstaEncapsuladaEnLosLimitesMaximosDeOtraPosicion() {

        Posicion posicion1 = new Posicion(20, 20);
        Posicion posicionEncapsuladora = new Posicion(30,30);

        assertTrue(posicion1.estaContenidaEnDimensiones(posicionEncapsuladora));

    }

    @Test
    public void testPosicionNoSeEncapsuladaEnLosLimitesMaximosDeOtraPosicion() {


        Posicion posicion1 = new Posicion(30, 30);
        Posicion posicionEncapsuladora = new Posicion(20,20);

        assertFalse(posicion1.estaContenidaEnDimensiones(posicionEncapsuladora));


    }

    @Test
    public void testPosicionEstaEncapuladaEnLosLimitesConTamanioDeterminado() {

        Posicion posicion1 = new Posicion(15,15);
        Posicion posicion2 = new Posicion(15,16);

        int tamanioDeterminadoDeEncapsulamiento  = 2;
        assertTrue(posicion2.estaContenidaEn(posicion1, tamanioDeterminadoDeEncapsulamiento));

    }

    @Test
    public void testTamanioLimiteMaximoParaEncapsularOtrasPosiciones() {

        Posicion posicion1 = new Posicion(20,20);

        int tamanioEsperadoDeEncapsulamiento = 400;
        assertEquals(tamanioEsperadoDeEncapsulamiento, posicion1.obtenerTamanioLimite());

    }
}
