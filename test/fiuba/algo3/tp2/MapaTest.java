package fiuba.algo3.tp2;

import org.junit.Test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class MapaTest {


    @Test
    public void testIniciarMapaBaseCorrespondiente() {

        //Mapa Base se inicia con 35 * 40 = 1400 espacios
        Mapa mapa = new Mapa();

        int tamanio = 1400;

        assertTrue(mapa.compararTamanio(tamanio));
    }

    @Test
    public void testIniciarMapaBaseNoCorrespondiente() {

        //Mapa Base se inicia con 35 * 40 = 1400 espacios
        Mapa mapa = new Mapa();

        int tamanio = 1000;

        assertFalse(mapa.compararTamanio(tamanio));
    }

    @Test
    public void testColocarUnidadEnUnaUbiacionEnElMapaCorrectamente() {

        //Mapa Base ubica una unidad en una celda correspondiente
        Mapa mapa = new Mapa();

        int posicionFila = 35;
        int posicionColumna = 35;

        //Unidad Aldeano, espadachin, arquero, arma de asedio (1 parcela)
        mapa.colocarUnidad(posicionFila, posicionColumna);

    }

    @Test
    public void testColocarUnidadYEstaEnParcelaCorrectamente() {

        //Mapa Base ubica una unidad en una celda correspondiente
        Mapa mapa = new Mapa();

        int posicionFila = 35;
        int posicionColumna = 35;

        mapa.colocarUnidad(posicionFila, posicionColumna);

        assertTrue(mapa.estaOcupadaEnPosicion(posicionFila, posicionColumna));

    }

    @Test (expected = UbicacionErroneaException.class)
    public void testColocarUnidadEnUnaUbicacionErronea() {

        //Mapa Base ubica una unidad en una celda correspondiente
        Mapa mapa = new Mapa();

        int posicionFila = 49;
        int posicionColumna = 35;

        mapa.colocarUnidad(posicionFila, posicionColumna);
    }

    @Test ( expected = UbicacionOcupadaException.class)
    public void testColocarUnidadEnUnaOcupada() {

        //Mapa Base ubica una unidad en una celda correspondiente
        Mapa mapa = new Mapa();

        int posicionFila = 35;
        int posicionColumna = 35;

        //Unidad Aldeano, espadachin, arquero, arma de asedio (1 parcela)
        mapa.colocarUnidad(posicionFila, posicionColumna);
        mapa.colocarUnidad(posicionFila, posicionColumna);
    }

}
