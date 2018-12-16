package fiuba.algo3.tp2;

import com.sun.org.apache.bcel.internal.generic.CASTORE;
import fiuba.algo3.tp2.modelo.Campo.Mapa;
import fiuba.algo3.tp2.modelo.Campo.Posicion;
import fiuba.algo3.tp2.modelo.Juego.Juego;
import fiuba.algo3.tp2.modelo.Juego.Jugador;
import fiuba.algo3.tp2.modelo.Piezas.*;
import fiuba.algo3.tp2.modelo.Piezas.Edificios.*;
import fiuba.algo3.tp2.modelo.Exception.*;
import fiuba.algo3.tp2.modelo.Piezas.Unidades.Aldeano;
import fiuba.algo3.tp2.modelo.Piezas.Unidades.Arquero;
import fiuba.algo3.tp2.modelo.Piezas.Unidades.Espadachin;
import fiuba.algo3.tp2.modelo.UnidadFactory.*;
import fiuba.algo3.tp2.vista.Main;
import org.junit.Test;

import java.util.ArrayList;

import static fiuba.algo3.tp2.modelo.Constantes.*;
import static fiuba.algo3.tp2.modelo.UnidadFactory.PiezaType.EDIFICIO_CASTILLO;
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
        castillo.recibirDanio(20);
        assertFalse(castillo.obtenerEstadoVida().estaReparado());
        assertFalse(castillo.obtenerEstadoVida().estaEnReparacion());
    }

    @Test
    public void testCastilloRecibeDanioDeEspadachin() {

        Edificio castillo = new Castillo();

        castillo.recibirDanio(ATAQUE_ESPADACHIN_A_EDIFICIO);

        int vidaEsperada = 985;
        assertEquals(vidaEsperada, castillo.obtenerVida());

    }

    @Test
    public void testCastilloRecibeDanioDeArquero() {

        Edificio castillo = new Castillo();

        castillo.recibirDanio(ATAQUE_ARQUERO_A_EDIFICIO);

        int vidaEsperada = 990;
        assertEquals(vidaEsperada, castillo.obtenerVida());

    }

    @Test
    public void testCastilloRecibeDanioDeArmaDeAsedio() {

        Edificio castillo = new Castillo();

        castillo.recibirDanio(ATAQUE_ARMADEASEDIO);

        int vidaEsperada = 925;
        assertEquals(vidaEsperada, castillo.obtenerVida());

    }

    @Test
    public void testCastilloRecibeDanioDeEspadachinArqueroYArmaDeAsedio() {

        Edificio castillo = new Castillo();

        castillo.recibirDanio(ATAQUE_ESPADACHIN_A_EDIFICIO);
        castillo.recibirDanio(ATAQUE_ARQUERO_A_EDIFICIO);
        castillo.recibirDanio(ATAQUE_ARMADEASEDIO);

        int vidaEsperada = 900;
        assertEquals(vidaEsperada, castillo.obtenerVida());

    }

    //test de metodo atacarA
    @Test
    public void testCastilloAtacaAEspadachin(){
        Espadachin espadachin = new Espadachin();
        Castillo castillo = new Castillo();

        castillo.atacarA(espadachin);
        assertEquals(80, espadachin.obtenerVida());
    }

    @Test
    public void testCastilloAtacaAArquero(){
        Arquero arquero = new Arquero();
        Castillo castillo = new Castillo();

        castillo.atacarA(arquero);
        assertEquals(55, arquero.obtenerVida());
    }

    @Test
    public void testCastilloAtacaAAldeno(){
        Aldeano aldeano = new Aldeano();
        Castillo castillo = new Castillo();

        castillo.atacarA(aldeano);
        assertEquals(30, aldeano.obtenerVida());
    }

    @Test
    public void testCastilloAtacaACuartel(){
        Cuartel cuartel = new Cuartel();
        Castillo castillo = new Castillo();

        castillo.atacarA(cuartel);
        assertEquals(230, cuartel.obtenerVida());
    }

    @Test
    public void testCastilloAtacaAPlazaCentral(){
        PlazaCentral plaza = new PlazaCentral();
        Castillo castillo = new Castillo();

        castillo.atacarA(plaza);
        assertEquals(430, plaza.obtenerVida());
    }

    @Test
    public void testCastilloObtenerNombreEsCastillo(){
        Castillo castillo = new Castillo();
        assertEquals("Castillo", castillo.obtenerNombre());
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
        castillo.recibirDanio(20);
        castillo.darVidaPorReparacion();

        assertEquals(995, castillo.obtenerVida());
    }

    @Test
    public void testDarVidaPorReparacionAumentaLaVidaDelCastilloEn10SiACastilloLeFaltaDiezParaTenerLaVidaCompleta(){
        Castillo castillo = new Castillo();
        castillo.recibirDanio(10);
        castillo.darVidaPorReparacion();

        assertEquals(1000, castillo.obtenerVida());
    }

    @Test
    public void testIniciarReparacionEnCastilloDaniadoCambiaElEstadoAEnReparacion(){
        Castillo castillo = new Castillo();
        castillo.recibirDanio(20);
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
        castillo.recibirDanio(20);
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
        castillo.recibirDanio(20);
        castillo.iniciarReparacion();

        castillo.verificarProcesoEnReparacion();
    }

    //tests de Posicion

    @Test
    public void testObtenerPoscionDevuelveLaPrimeraPosicionDeLaLista(){
        Castillo castillo = new Castillo();
        ArrayList<Posicion> posiciones = new ArrayList<>();
        Posicion pos1 = new Posicion(1,1);
        posiciones.add(pos1);
        posiciones.add(new Posicion(2,2));
        castillo.agregarPosicion(posiciones);

        assertEquals(pos1, castillo.obtenerPosicion());
    }

/*    @Test
    public void testAtaqueMasivoAtacaALasUnidadesEnSuRangoDeAtaque(){
        Juego juego = new Juego("victor", "manuel");
        Mapa mapa  = juego.mapa();
        Jugador jugador = juego.jugadorDeTurno();

        Arquero arquero = new Arquero();
        Espadachin espadachin = new Espadachin();

        jugador.agregaPieza(arquero);
        jugador.agregaPieza(espadachin);

        mapa.colocarPieza(arquero, new Posicion());
    }*/
}
