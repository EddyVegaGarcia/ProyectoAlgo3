package fiuba.algo3.tp2;

import fiuba.algo3.tp2.modelo.Campo.*;
import fiuba.algo3.tp2.modelo.Direcciones.*;
import fiuba.algo3.tp2.modelo.Piezas.*;
import fiuba.algo3.tp2.modelo.Piezas.Unidades.*;
import fiuba.algo3.tp2.modelo.Piezas.Edificios.*;
import org.junit.Test;

import fiuba.algo3.tp2.modelo.Exception.*;

import java.util.ArrayList;

import static org.junit.Assert.*;

public class MapaTest {

    @Test
    public void testIniciarMapaBaseCorrespondiente() {

        Mapa mapa = new Mapa();

        int espacioEsperado = 27 * 37;
        assertEquals(espacioEsperado,mapa.getTamanio());
    }

    @Test
    public void testColocarUnidadEnPosicionCorrectamente() {

        Mapa mapa = new Mapa();
        Posicion posicion = new Posicion(10,15);
        Unidad unAldeano = new Aldeano();
        mapa.colocarPieza(unAldeano, posicion);

        assertEquals(unAldeano, mapa.recuperarPieza(posicion));

    }

    @Test (expected = UbicacionErroneaException.class)
    public void testColocarUnidadEnUnaUbicacionErronea() {

        Mapa mapa = new Mapa();
        Posicion posicion = new Posicion(40,45);
        mapa.colocarPieza(new Aldeano(), posicion);

    }

    @Test ( expected = UbicacionOcupadaException.class)
    public void testColocarUnidadEnUnaOcupada() {

        Mapa mapa = new Mapa();
        Posicion posicion = new Posicion(20,25);
        Unidad unAldeano = new Aldeano();
        Unidad otroAldeano = new Aldeano();

        mapa.colocarPieza(unAldeano, posicion);
        mapa.colocarPieza(otroAldeano, posicion);

    }

    @Test
    public void testMoverAldeanoHaciaArriba() {

        Mapa mapa = new Mapa();
        Posicion posicion = new Posicion(20,25);
        Unidad unAldeano = new Aldeano();

        mapa.colocarPieza(unAldeano, posicion);
        mapa.moverUnidad(posicion, new DireccionArriba());
        Posicion posicionNueva = new Posicion(19,25);

        assertEquals(mapa.recuperarPieza(posicionNueva), unAldeano);
    }


    @Test (expected = UbicacionErroneaException.class)
    public void testMoverUnidadHaciaArribaInvalido() {

        Mapa mapa = new Mapa();
        Posicion posicion = new Posicion(0,18);
        Unidad unAldeano = new Aldeano();

        mapa.colocarPieza(unAldeano, posicion);
        mapa.moverUnidad(posicion, new DireccionArriba());

    }

    @Test
    public void testMoverUnidadHaciaAbajo() {

        Mapa mapa = new Mapa();
        Posicion posicion = new Posicion(20,25);
        Unidad espadachin = new Espadachin();

        mapa.colocarPieza(espadachin, posicion);
        mapa.moverUnidad(posicion, new DireccionAbajo());

        Posicion posicionNueva = new Posicion(21,25);
        assertEquals(mapa.recuperarPieza(posicionNueva), espadachin);

    }

    @Test (expected = UbicacionErroneaException.class)
    public void testMoverUnidadHaciaAbajoInvalido() {

        Mapa mapa = new Mapa();
        Posicion posicion = new Posicion(35,25);
        Unidad unAldeano = new Aldeano();

        mapa.colocarPieza(unAldeano, posicion);
        mapa.moverUnidad(posicion, new DireccionAbajo());

    }

    @Test
    public void testMoverUnidadHaciaIzquierda() {

        Mapa mapa = new Mapa();
        Posicion posicion = new Posicion(24,30);
        Unidad unArquero = new Arquero();

        mapa.colocarPieza(unArquero, posicion);
        mapa.moverUnidad(posicion, new DireccionIzquierda());

        Posicion posicionNueva = new Posicion(24,29);
        assertEquals(mapa.recuperarPieza(posicionNueva), unArquero);

    }

    @Test(expected = UbicacionErroneaException.class)
    public void testMoverUnidadHaciaIzquierdaInvalido() {

        Mapa mapa = new Mapa();
        Posicion posicion = new Posicion(20,0);
        Unidad armaDeAsedio = new ArmaDeAsedio();

        mapa.colocarPieza(armaDeAsedio, posicion);
        mapa.moverUnidad(posicion, new DireccionIzquierda());


    }

    @Test
    public void testMoverUnidadHaciaDerecha() {

        Mapa mapa = new Mapa();
        Posicion posicion = new Posicion(21,25);
        Unidad espadachin = new Espadachin();

        mapa.colocarPieza(espadachin, posicion);
        mapa.moverUnidad(posicion, new DireccionDerecha());

        Posicion posicionNueva = new Posicion(21,26);
        assertEquals(mapa.recuperarPieza(posicionNueva), espadachin);

    }

    @Test(expected = UbicacionErroneaException.class)
    public void testMoverUnidadHaciaDerechaInvalido() {

        Mapa mapa = new Mapa();
        Posicion posicion = new Posicion(21,40);
        Unidad espadachin = new Espadachin();

        mapa.colocarPieza(espadachin, posicion);
        mapa.moverUnidad(posicion, new DireccionDerecha());

    }

    @Test(expected = UbicacionOcupadaException.class)
    public void testMoverUnidadArribaDerechaHaciaPosicionYaOcupadaConUnaUnidad() {

        Mapa mapa = new Mapa();
        Posicion posicion = new Posicion(21,25);
        Unidad espadachin = new Espadachin();

        Posicion posicionNueva = new Posicion(20,26);
        Unidad arquero = new Arquero();

        mapa.colocarPieza(espadachin, posicion);
        mapa.colocarPieza(arquero, posicionNueva);

        mapa.moverUnidad(posicion, new DireccionArribaDerecha());

    }

    @Test(expected = UbicacionErroneaException.class)
    public void testMoverUnidadAbajoIzquierdaInvalido() {

        Mapa mapa = new Mapa();
        Posicion posicion = new Posicion(35,1);
        Unidad espadachin = new Espadachin();

        mapa.colocarPieza(espadachin, posicion);

        mapa.moverUnidad(posicion, new DireccionAbajoIzquierda());

    }

    @Test(expected = UbicacionOcupadaException.class)
    public void testMoverUnidadArribaIzquierdaHaciaPosicionYaOcupadaPorEdificio() {

        Mapa mapa = new Mapa();
        Posicion posicion = new Posicion(12,12);
        Unidad unAldeano = new Aldeano();

        Posicion posicionNueva = new Posicion(10,10);
        Edificio unEdificio = new Cuartel();

        mapa.colocarPieza(unAldeano, posicion);
        mapa.colocarPieza(unEdificio, posicionNueva);

        mapa.moverUnidad(posicion, new DireccionArribaIzquierda());

    }

    @Test
    public void testBorrarUnidad() {

        Mapa mapa = new Mapa();
        Arquero arquero = new Arquero();
        Posicion posicion = new Posicion(4,5);

        mapa.colocarPieza(arquero, posicion);
        mapa.borrarUnidad(arquero, posicion);

        assertNull(mapa.recuperarPieza(posicion));
        
    }


    @Test
    public void testColocarEdificioCorrectamente() {

        Mapa mapa = new Mapa();
        PlazaCentral unaPlaza = new PlazaCentral();
        Posicion posicionPlaza = new Posicion(3,3);

        mapa.colocarPieza(unaPlaza, posicionPlaza);

        assertEquals(mapa.recuperarPieza(new Posicion(4, 4)), unaPlaza);

    }

    @Test(expected = UbicacionErroneaException.class)
    public void testColocarEdificioIncorrectamente() {

        Mapa mapa = new Mapa();
        PlazaCentral unaPlaza = new PlazaCentral();
        Posicion posicionPlaza = new Posicion(35,40);

        mapa.colocarPieza(unaPlaza, posicionPlaza);

    }

    @Test
    public void testObtenerPiezasEnUnRangoDe3DesdeUnaPosicionConUnTamanioDe4(){
        Mapa mapa =  new Mapa();
        PlazaCentral unaPlaza = new PlazaCentral();
        Arquero arquero = new Arquero();

        mapa.colocarPieza(unaPlaza, new Posicion(10, 13));
        mapa.colocarPieza(arquero, new Posicion(13,10));

        ArrayList<Pieza> piezas = mapa.obtenerPiezasQueEstanEnRango(new Posicion(10,10), 4, 3);
        assertTrue(piezas.contains(unaPlaza));
        assertTrue(piezas.contains(arquero));
    }

    @Test
    public void testObtenerPiezasEnUnRangoDe3DesdeUnaPosicionConUnTamanio4DeUnaPiezaQueEstaFueraDeRango(){
        Mapa mapa =  new Mapa();
        PlazaCentral unaPlaza = new PlazaCentral();

        mapa.colocarPieza(unaPlaza, new Posicion(10, 16));

        ArrayList<Pieza> piezas = mapa.obtenerPiezasQueEstanEnRango(new Posicion(10,10), 4, 3);
        assertTrue(piezas.size() == 0);
    }

    @Test(expected = UbicacionOcupadaException.class)
    public void testValidarPosicionEnUnaPosicionOcupadaLanzaException(){
        Mapa mapa =  new Mapa();
        mapa.colocarPieza(new PlazaCentral(), new Posicion(10,10));

        mapa.validarPosicion(new Posicion(10,10));
    }

    @Test(expected = UbicacionErroneaException.class)
    public void testValidarPosicionEnUnaPosicionFueraDelMapaLanzaException(){
        Mapa mapa =  new Mapa();
        mapa.validarPosicion(new Posicion(30,10));
    }
}
