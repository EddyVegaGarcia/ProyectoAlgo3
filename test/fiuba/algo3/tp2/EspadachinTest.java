package fiuba.algo3.tp2;

import fiuba.algo3.tp2.modelo.Piezas.*;
import fiuba.algo3.tp2.modelo.Piezas.Unidades.Arquero;
import fiuba.algo3.tp2.modelo.Piezas.Unidades.Espadachin;
import org.junit.Test;

import static fiuba.algo3.tp2.modelo.Constantes.*;
import static fiuba.algo3.tp2.modelo.UnidadFactory.PiezaType.UNIDAD_ARQUERO;
import static fiuba.algo3.tp2.modelo.UnidadFactory.PiezaType.UNIDAD_ESPADACHIN;
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

    //tests de getters

    @Test
    public void testObtenerNombreDevuelveEspadachin(){
        Espadachin espadachin = new Espadachin();
        assertEquals("Espadachin", espadachin.obtenerNombre());
    }

    @Test
    public void testObtenerDistanciaDeAtaqueDevuelve1(){
        Espadachin espadachin = new Espadachin();
        assertEquals(1, espadachin.obtenerDistanciaAtaque());
    }

    @Test
    public void testGetTamanioDevuelve1(){
        Espadachin espadachin = new Espadachin();
        assertEquals(1, (long)espadachin.getTamanio());
    }

    @Test
    public void testObtenerTypeDevuelveUnidadEspadachin(){
        Espadachin espadachin = new Espadachin();
        assertEquals(UNIDAD_ESPADACHIN, espadachin.obtenerType());
    }
}
