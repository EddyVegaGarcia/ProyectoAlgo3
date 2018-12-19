package fiuba.algo3.tp2;

import fiuba.algo3.tp2.modelo.Campo.Mapa;
import fiuba.algo3.tp2.modelo.Campo.Posicion;
import fiuba.algo3.tp2.modelo.Juego.Juego;
import fiuba.algo3.tp2.modelo.Juego.Jugador;
import fiuba.algo3.tp2.modelo.Piezas.*;
import fiuba.algo3.tp2.modelo.Piezas.Edificios.*;
import fiuba.algo3.tp2.modelo.Exception.*;
import fiuba.algo3.tp2.modelo.Piezas.Unidades.Aldeano;
import fiuba.algo3.tp2.modelo.Piezas.Unidades.ArmaDeAsedio;
import fiuba.algo3.tp2.modelo.Piezas.Unidades.Arquero;
import fiuba.algo3.tp2.modelo.Piezas.Unidades.Espadachin;
import fiuba.algo3.tp2.modelo.UnidadFactory.*;
import org.junit.Test;

import static fiuba.algo3.tp2.modelo.Constantes.*;
import static fiuba.algo3.tp2.modelo.UnidadFactory.PiezaType.EDIFICIO_CASTILLO;
import static junit.framework.TestCase.assertTrue;
import static org.junit.Assert.*;

public class CastilloTest {

    //test de creacion de unidades
    @Test
    public void testCastilloCreaArmaDeAsedio(){

        Jugador jugador = new Jugador("loo", new Mapa());
        jugador.ubicarAldeanosPorDefault(new Posicion(1,1), new Posicion(2,1), new Posicion( 2, 2));

        jugador.recolectarOro();
        jugador.recolectarOro();

        Edificio castillo = new Castillo();

        Unidad armaDeAsedio = ((Castillo) castillo).colocarPieza(PiezaType.UNIDAD_ARMADEASEDIO, jugador);

        int vidaEsperada = 150;
        assertEquals(vidaEsperada, armaDeAsedio.obtenerVida());

    }

    @Test (expected = InvalidUnidadTypeException.class)
    public void testCrearUnidadIncorrectaDeEspadachinEnCastillo() {

        Jugador jugador = new Jugador("loo", new Mapa());
        jugador.ubicarAldeanosPorDefault(new Posicion(1,1), new Posicion(2,1), new Posicion( 2, 2));
        jugador.recolectarOro();
        jugador.recolectarOro();

        Edificio castillo = new Castillo();

        Unidad armaDeAsedio = ((Castillo) castillo).colocarPieza(PiezaType.UNIDAD_ESPADACHIN, jugador);
    }

    //test de metodo recibir danio

    @Test
    public void testRecibirDanioCambiaElEstadoDelCastilloADaniado(){
        Castillo castillo = new Castillo();
        castillo.recibirDanioDe(new Espadachin());
        assertFalse(castillo.obtenerEstadoVida().estaReparado());
        assertFalse(castillo.obtenerEstadoVida().estaEnReparacion());
    }

    @Test
    public void testCastilloRecibeDanioDeEspadachin() {

        Edificio castillo = new Castillo();

        castillo.recibirDanioDe(new Espadachin());

        int vidaEsperada = 985;
        assertEquals(vidaEsperada, castillo.obtenerVida());

    }

    @Test
    public void testCastilloRecibeDanioDeArquero() {

        Edificio castillo = new Castillo();

        castillo.recibirDanioDe(new Arquero());

        int vidaEsperada = 990;
        assertEquals(vidaEsperada, castillo.obtenerVida());

    }

    @Test
    public void testCastilloRecibeDanioDeArmaDeAsedio() {

        Edificio castillo = new Castillo();

        castillo.recibirDanioDe(new ArmaDeAsedio());

        int vidaEsperada = 925;
        assertEquals(vidaEsperada, castillo.obtenerVida());

    }

    @Test
    public void testCastilloRecibeDanioDeEspadachinArqueroYArmaDeAsedio() {

        Edificio castillo = new Castillo();

        castillo.recibirDanioDe(new Espadachin());
        castillo.recibirDanioDe(new Arquero());
        castillo.recibirDanioDe(new ArmaDeAsedio());

        int vidaEsperada = 900;
        assertEquals(vidaEsperada, castillo.obtenerVida());

    }

    //test de metodo atacarA
    @Test
    public void testCastilloAtacaAEspadachin(){
        Espadachin espadachin = new Espadachin();
        Castillo castillo = new Castillo();

        castillo.atacarPieza(espadachin);
        assertEquals(80, espadachin.obtenerVida());
    }

    @Test
    public void testCastilloAtacaAArquero(){
        Arquero arquero = new Arquero();
        Castillo castillo = new Castillo();

        castillo.atacarPieza(arquero);
        assertEquals(55, arquero.obtenerVida());
    }

    @Test
    public void testCastilloAtacaAAldeno(){
        Aldeano aldeano = new Aldeano();
        Castillo castillo = new Castillo();

        castillo.atacarPieza(aldeano);
        assertEquals(30, aldeano.obtenerVida());
    }

    @Test
    public void testCastilloAtacaACuartel(){
        Cuartel cuartel = new Cuartel();
        Castillo castillo = new Castillo();

        castillo.atacarPieza(cuartel);
        assertEquals(230, cuartel.obtenerVida());
    }

    @Test
    public void testCastilloAtacaAPlazaCentral(){
        PlazaCentral plaza = new PlazaCentral();
        Castillo castillo = new Castillo();

        castillo.atacarPieza(plaza);
        assertEquals(430, plaza.obtenerVida());
    }

    @Test
    public void testObtenerTamanioDevuelve16(){
         Castillo castillo = new Castillo();
        assertEquals(16, castillo.obtenerTamanio());
    }

    @Test
    public void testObtenerTypeDevuelveEdificioCastillo(){
        Castillo castillo = new Castillo();
        assertEquals(EDIFICIO_CASTILLO, castillo.obtenerType());
    }

    //test del metodo dar vida por reparacion
    @Test
    public void testDarVidaPorReparacionAumentaLaVidaDelCastilloEn15(){
        Castillo castillo = new Castillo();
        castillo.recibirDanioDe(new Castillo());
        castillo.darVidaPorReparacion();

        assertEquals(995, castillo.obtenerVida());
    }

    @Test
    public void testDarVidaPorReparacionAumentaLaVidaDelCastilloEn10SiACastilloLeFaltaDiezParaTenerLaVidaCompleta(){
        Castillo castillo = new Castillo();
        castillo.recibirDanioDe(new Arquero());
        castillo.darVidaPorReparacion();

        assertEquals(1000, castillo.obtenerVida());
    }

    @Test
    public void testIniciarReparacionEnCastilloDaniadoCambiaElEstadoAEnReparacion(){
        Castillo castillo = new Castillo();
        castillo.recibirDanioDe(new Arquero());
        castillo.iniciarReparacion();
        assertTrue(castillo.obtenerEstadoVida().estaEnReparacion());
    }

    @Test(expected = EdificioYaReparadoException.class)
    public void testIniciarReparacionEnCastilloConVidaMaximaLanzaException(){
        Castillo castillo = new Castillo();
        castillo.iniciarReparacion();
        assertTrue(castillo.obtenerEstadoVida().estaEnReparacion());
    }

    @Test
    public void testTerminarReparacionEnCastilloEnReparacionLeCambiaElEstadoAReparado(){
        Castillo castillo = new Castillo();
        castillo.recibirDanioDe(new Arquero());
        castillo.iniciarReparacion();
        castillo.finalizarReparacion();
        assertTrue(castillo.obtenerEstadoVida().estaReparado());
    }

    @Test
    public void testFinalizarReparacionEnCastilloReparadoMantieneElEstadoEnReparado(){
        Castillo castillo = new Castillo();
        castillo.finalizarReparacion();
        assertTrue(castillo.obtenerEstadoVida().estaReparado());
    }

    //tests de metodo verificarProcesoEnReparacion

    @Test(expected = EdificioEnReparacionException.class)
    public void testVerificarProcesoEnReparacionLanzaExceptionSiEstaEnReparacion(){
        Castillo castillo = new Castillo();
        castillo.recibirDanioDe(new Arquero());
        castillo.iniciarReparacion();

        castillo.verificarProcesoEnReparacion();
    }

    //tests de Posicion

    @Test
    public void testObtenerPoscionDevuelveLaPosicionExtremaSuperiorIzquierda(){

        Jugador unJugador = new Jugador("alex", new Mapa());
        unJugador.ubicarEdificiosPorDefault(POSICION_DEFAULT_CASTILLO1, POSICION_DEFAULT_PLAZA1);

        Castillo unCastillo = unJugador.obtenerCastillo();
        Posicion unaPosicion = unCastillo.obtenerPrimeraPosicion();

        Posicion otraPosicion = new Posicion(0,33);

        assertTrue(unaPosicion.compararPosicion(otraPosicion));
    }

    //tests ataque masivo

    @Test
    public void testAtaqueMasivoAtacaALasUnidadesEnRangoDeAtaqueDe1(){
        Juego juego = new Juego("victor", "manuel");
        Mapa mapa  = juego.mapa();
        Jugador jugador = juego.jugador1();

        Arquero arquero = new Arquero();
        Espadachin espadachin = new Espadachin();

        juego.jugador2().agregaPieza(arquero);
        juego.jugador2().agregaPieza(espadachin);

        mapa.colocarPieza(arquero, new Posicion(0,32));
        mapa.colocarPieza(espadachin, new Posicion(1,32));

        Castillo castillo = jugador.obtenerCastillo();
        castillo.ataqueMasivo(jugador, mapa, juego);

        assertEquals(80, espadachin.obtenerVida());
        assertEquals(55, arquero.obtenerVida());
    }

    @Test
    public void testAtaqueMasivoAtacaALasUnidadesEnRangoDeAtaqueDe2(){
        Juego juego = new Juego("victor", "manuel");
        Mapa mapa  = juego.mapa();
        Jugador jugador = juego.jugador1();

        Arquero arquero = new Arquero();
        Espadachin espadachin = new Espadachin();

        juego.jugador2().agregaPieza(arquero);
        juego.jugador2().agregaPieza(espadachin);

        mapa.colocarPieza(arquero, new Posicion(0,31));
        mapa.colocarPieza(espadachin, new Posicion(1,31));

        Castillo castillo = jugador.obtenerCastillo();
        castillo.ataqueMasivo(jugador, mapa, juego);

        assertEquals(80, espadachin.obtenerVida());
        assertEquals(55, arquero.obtenerVida());
    }

    @Test
    public void testAtaqueMasivoAtacaALasUnidadesEnRangoDeAtaqueDe3(){
        Juego juego = new Juego("victor", "manuel");
        Mapa mapa  = juego.mapa();
        Jugador jugador = juego.jugador1();

        Arquero arquero = new Arquero();
        Espadachin espadachin = new Espadachin();

        juego.jugador2().agregaPieza(arquero);
        juego.jugador2().agregaPieza(espadachin);

        mapa.colocarPieza(arquero, new Posicion(2,30));
        mapa.colocarPieza(espadachin, new Posicion(6,30));

        Castillo castillo = jugador.obtenerCastillo();
        castillo.ataqueMasivo(jugador, mapa, juego);

        assertEquals(80, espadachin.obtenerVida());
        assertEquals(55, arquero.obtenerVida());
    }

    @Test
    public void testAtaqueMasivoAtacaALasUnidadesEnRangoDeAtaqueVariado(){
        Juego juego = new Juego("victor", "manuel");
        Mapa mapa  = juego.mapa();
        Jugador jugador = juego.jugador1();

        Arquero arquero = new Arquero();
        Espadachin espadachin = new Espadachin();

        juego.jugador2().agregaPieza(arquero);
        juego.jugador2().agregaPieza(espadachin);

        mapa.colocarPieza(arquero, new Posicion(0,32));
        mapa.colocarPieza(espadachin, new Posicion(1,31));

        Castillo castillo = jugador.obtenerCastillo();
        castillo.ataqueMasivo(jugador, mapa, juego);

        assertEquals(80, espadachin.obtenerVida());
        assertEquals(55, arquero.obtenerVida());
    }

    @Test
    public void testAtaqueMasivoAtacaALosEdificiosEnRangoDeAtaqueDe1(){
        Juego juego = new Juego("victor", "manuel");
        Mapa mapa  = juego.mapa();
        Jugador jugador = juego.jugador1();

        Cuartel cuartel = new Cuartel();
        PlazaCentral plazaCentral =  new PlazaCentral();

        juego.jugador2().agregaPieza(cuartel);
        juego.jugador2().agregaPieza(plazaCentral);

        mapa.colocarPieza(cuartel, new Posicion(5,34));
        mapa.colocarPieza(plazaCentral, new Posicion(0,31));

        Castillo castillo = jugador.obtenerCastillo();
        castillo.ataqueMasivo(jugador, mapa, juego);

        assertEquals(230, cuartel.obtenerVida());
        assertEquals(430, plazaCentral.obtenerVida());
    }

    @Test
    public void testAtaqueMasivoAtacaALosEdificiosEnRangoDeAtaqueDe2(){
        Juego juego = new Juego("victor", "manuel");
        Mapa mapa  = juego.mapa();
        Jugador jugador = juego.jugador1();

        Cuartel cuartel = new Cuartel();

        juego.jugador2().agregaPieza(cuartel);

        mapa.colocarPieza(cuartel, new Posicion(6,34));

        Castillo castillo = jugador.obtenerCastillo();
        castillo.ataqueMasivo(jugador, mapa, juego);

        assertEquals(230, cuartel.obtenerVida());
    }

    @Test
    public void testAtaqueMasivoAtacaALosEdificiosEnRangoDeAtaqueDe3(){
        Juego juego = new Juego("victor", "manuel");
        Mapa mapa  = juego.mapa();
        Jugador jugador = juego.jugador1();

        Cuartel cuartel = new Cuartel();

        juego.jugador2().agregaPieza(cuartel);

        mapa.colocarPieza(cuartel, new Posicion(6,34));

        Castillo castillo = jugador.obtenerCastillo();
        castillo.ataqueMasivo(jugador, mapa, juego);

        assertEquals(230, cuartel.obtenerVida());
    }

    @Test
    public void testAtaqueMasivoAtacaAPiezasEnRangoDeAtaqueVariado(){
        Juego juego = new Juego("victor", "manuel");
        Mapa mapa  = juego.mapa();
        Jugador jugador = juego.jugador1();

        Cuartel cuartel = new Cuartel();
        PlazaCentral plazaCentral =  new PlazaCentral();
        Arquero arquero = new Arquero();
        Espadachin espadachin = new Espadachin();

        juego.jugador2().agregaPieza(cuartel);
        juego.jugador2().agregaPieza(plazaCentral);
        juego.jugador2().agregaPieza(arquero);
        juego.jugador2().agregaPieza(espadachin);

        mapa.colocarPieza(cuartel, new Posicion(5,34));
        mapa.colocarPieza(plazaCentral, new Posicion(0,31));
        mapa.colocarPieza(arquero, new Posicion(3,32));
        mapa.colocarPieza(espadachin, new Posicion(5,32));

        Castillo castillo = jugador.obtenerCastillo();
        castillo.ataqueMasivo(jugador, mapa, juego);

        assertEquals(230, cuartel.obtenerVida());
        assertEquals(430, plazaCentral.obtenerVida());
        assertEquals(80, espadachin.obtenerVida());
        assertEquals(55, arquero.obtenerVida());
    }

}
