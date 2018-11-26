package fiuba.algo3.tp2;

import fiuba.algo3.tp2.modelo.*;
import org.junit.Assert;
import org.junit.Test;

import static fiuba.algo3.tp2.modelo.Constantes.*;
import static org.junit.Assert.*;

public class MapaTest {

    @Test
    public void testIniciarMapaBaseCorrespondiente() {
        //Mapa Base se inicia con 35 * 40 = 1400 espacios
        Mapa mapa = new Mapa(FILA_DEFAULT_MAPA, COLUMNA_DEFAULT_MAPA);

        Assert.assertEquals(FILA_DEFAULT_MAPA*COLUMNA_DEFAULT_MAPA,mapa.getTamanio());
    }

    @Test
    public void testColocarUnidadEnPosicionCorrectamente() {
        Mapa mapa = new Mapa(FILA_DEFAULT_MAPA, COLUMNA_DEFAULT_MAPA);
        Posicion posicion = new Posicion(35,15);
        Aldeano unAldeano = new Aldeano();
        mapa.colocarPiezaNoAtacante(unAldeano, posicion);

        Assert.assertEquals(unAldeano,mapa.recuperarPieza(posicion));

    }

    @Test (expected = UbicacionErroneaException.class)
    public void testColocarUnidadEnUnaUbicacionErronea() {
        Mapa mapa = new Mapa(FILA_DEFAULT_MAPA, COLUMNA_DEFAULT_MAPA);
        Posicion posicion = new Posicion(40,45);
        mapa.colocarPiezaNoAtacante(new Aldeano(), posicion);
    }

    @Test ( expected = UbicacionOcupadaException.class)
    public void testColocarUnidadEnUnaOcupada() {
        Mapa mapa = new Mapa(FILA_DEFAULT_MAPA, COLUMNA_DEFAULT_MAPA);
        Posicion posicion = new Posicion(20,25);
        Aldeano unAldeano = new Aldeano();
        Aldeano otroAldeano = new Aldeano();

        mapa.colocarPiezaNoAtacante(unAldeano, posicion);
        mapa.colocarPiezaNoAtacante(otroAldeano, posicion);
    }

    @Test
    public void moverAldeanoHaciaArriba() {
        Mapa mapa = new Mapa(FILA_DEFAULT_MAPA, COLUMNA_DEFAULT_MAPA);
        Posicion posicion = new Posicion(20,25);
        Aldeano unAldeano = new Aldeano();

        mapa.colocarPiezaNoAtacante(unAldeano, posicion);
        mapa.moverAldeano(posicion, new DireccionArriba());
        Posicion posicionNueva = new Posicion(19,25);

        assertEquals(mapa.recuperarPieza(posicionNueva), unAldeano);
    }


    @Test (expected = UbicacionErroneaException.class)
    public void moverUnidadHaciaArribaInvalido() {
        Mapa mapa = new Mapa(FILA_DEFAULT_MAPA, COLUMNA_DEFAULT_MAPA);
        Posicion posicion = new Posicion(1,18);
        Aldeano unAldeano = new Aldeano();

        mapa.colocarPiezaNoAtacante(unAldeano, posicion);
        mapa.moverAldeano(posicion, new DireccionArriba());
    }
/*
    @Test
    public void moverUnidadHaciaAbajo() {
        Mapa mapa = new Mapa(FILA_DEFAULT_MAPA, COLUMNA_DEFAULT_MAPA);
        Posicion posicion = new Posicion(20,25);
        Espadachin espadachin = new Espadachin();

        mapa.colocarPiezaNoAtacante(espadachin, posicion);
        mapa.moverAtacante(posicion, new DireccionAbajo());

        Posicion posicionNueva = new Posicion(21,25);
        assertEquals(mapa.recuperarUnidad(posicionNueva), unAldeano);
    }*/

    @Test (expected = UbicacionErroneaException.class)
    public void moverUnidadHaciaAbajoInvalido() {
        Mapa mapa = new Mapa(FILA_DEFAULT_MAPA, COLUMNA_DEFAULT_MAPA);
        Posicion posicion = new Posicion(35,25);
        Aldeano unAldeano = new Aldeano();

        mapa.colocarPiezaNoAtacante(unAldeano, posicion);
        mapa.moverAldeano(posicion, new DireccionAbajo());
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

    @Test
    public void testColocarEdificioNoAtacanteCorrectamente() {
        Mapa mapa = new Mapa(FILA_DEFAULT_MAPA, COLUMNA_DEFAULT_MAPA);
        PlazaCentral unaPlaza = new PlazaCentral();
        Posicion posicionPlaza = new Posicion(3,3);

        mapa.colocarPiezaNoAtacante(unaPlaza, posicionPlaza);

        for (int i = posicionPlaza.getFila(); i <= (unaPlaza.obtenerTamanio() / 4) ; i++) {
            for (int j = posicionPlaza.getColumna(); j <= (unaPlaza.obtenerTamanio() / 4) ; j++) {
                assertEquals(mapa.recuperarPieza(new Posicion(i, j)), unaPlaza);
            }
        }
    }

    @Test
    public void testColocarCastilloCorrectamente() {
        Mapa mapa = new Mapa(FILA_DEFAULT_MAPA, COLUMNA_DEFAULT_MAPA);

        Castillo unCastillo = new Castillo();
        mapa.colocarPiezaAtacante(unCastillo, POSICION_DEFAULT_CASTILLO1);

        for (int i = POSICION_DEFAULT_CASTILLO1.getFila(); i <= (unCastillo.obtenerTamanio() / 4) ; i++) {
            for (int j = POSICION_DEFAULT_CASTILLO1.getColumna(); j <= (unCastillo.obtenerTamanio() / 4) ; j++) {
                assertEquals(mapa.recuperarPieza(new Posicion(i, j)), unCastillo);
            }
        }

    }

    @Test
    public void testCastilloAtaca() {
        Mapa mapa = new Mapa(FILA_DEFAULT_MAPA, COLUMNA_DEFAULT_MAPA);
        Castillo castillo = new Castillo();
        Aldeano aldeanoEnemigo = new Aldeano();

        mapa.colocarPiezaAtacante(castillo, POSICION_DEFAULT_CASTILLO1);
        mapa.colocarPiezaNoAtacante(aldeanoEnemigo, new Posicion(5, 3));

        castillo.atacar(mapa);
        int vidaEsperada = 30;
        assertEquals(aldeanoEnemigo.obtenerVida(), vidaEsperada);

    }
}
