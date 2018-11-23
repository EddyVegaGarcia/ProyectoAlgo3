package fiuba.algo3.tp2;

import fiuba.algo3.tp2.modelo.*;
import org.junit.Test;

import static org.junit.Assert.*;

public class MapaTest {


    @Test
    public void testIniciarMapaBaseCorrespondiente() {

        //Mapa Base se inicia con 35 * 40 = 1400 espacios
        Mapa mapa = new Mapa();

        int tamanio = 1400;

        assertEquals(mapa.getTamanio(), tamanio);
    }

    @Test
    public void testIniciarMapaBaseNoCorrespondiente() {

        //Mapa Base se inicia con 35 * 40 = 1400 espacios
        Mapa mapa = new Mapa();

        int tamanio = 1000;

        assertNotEquals(mapa.getTamanio(), tamanio);
    }

    @Test
    public void testColocarUnidadEnParcelaCorrectamente() {

        //Mapa Base ubica una unidad en una celda correspondiente
        Mapa mapa = new Mapa();

        Posicion posicion = new Posicion(35,35);

        Aldeano unAldeano = new Aldeano();

        //se coloca al aldeano en la parcela de fila:35 y columna:35
        mapa.colocarUnidad(unAldeano, posicion);

        assertEquals(mapa.recuperarUnidad(posicion), unAldeano);

    }

    @Test (expected = UbicacionErroneaException.class)
    public void testColocarUnidadEnUnaUbicacionErronea() {

        //Mapa Base ubica una unidad en una celda correspondiente
        Mapa mapa = new Mapa();

        Posicion posicion = new Posicion(40,45);

        mapa.colocarUnidad(new Aldeano(), posicion);
    }

    @Test ( expected = UbicacionOcupadaException.class)
    public void testColocarUnidadEnUnaOcupada() {

        //Mapa Base ubica una unidad en una celda correspondiente
        Mapa mapa = new Mapa();

        Posicion posicion = new Posicion(20,25);

        Aldeano unAldeano = new Aldeano();
        Espadachin unEspadachin = new Espadachin();

        //Unidad Aldeano, espadachin, arquero, arma de asedio (1 parcela)
        mapa.colocarUnidad(unAldeano, posicion);
        mapa.colocarUnidad(unEspadachin, posicion);
    }

    @Test
    public void moverUnidadHaciaArriba() {
        Mapa mapa = new Mapa();
        Posicion posicion = new Posicion(20,25);
        Aldeano unAldeano = new Aldeano();
        mapa.colocarUnidad(unAldeano, posicion);

        mapa.moverUnidadArriba(unAldeano);
        assertEquals(mapa.recuperarUnidad(new Posicion(19,25)), unAldeano);
    }


    @Test
    public void moverUnidadHaciaArribaInvalido() {
    }

    @Test
    public void moverUnidadHaciaAbajo() {
    }

    @Test
    public void moverUnidadHaciaAbajoInvalido() {
    }

    @Test
    public void moverUnidadHaciaIzquierda() {
    }

    @Test
    public void moverUnidadHaciaIzquierdaInvalido() {
    }

    @Test
    public void moverUnidadHaciaDerecha() {
    }

    @Test
    public void moverUnidadHaciaDerechaInvalido() {
    }

    //los invalidos serian los que tienen unidades en el limite del mapa o los casilleros ya ocupados por otra unidad
    //te falta agregar 4 test (los de pisar unidades)

    @Test
    public void borrarUnidad() { //borrar o destruir unidad

    }

    @Test
    public void borrarUnidadInexistente() {

        //excepciones
    }





}
