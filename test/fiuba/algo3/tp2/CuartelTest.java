package fiuba.algo3.tp2;

import fiuba.algo3.tp2.modelo.Campo.Mapa;
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
import static fiuba.algo3.tp2.modelo.UnidadFactory.PiezaType.EDIFICIO_CUARTEL;
import static junit.framework.TestCase.assertTrue;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;

public class CuartelTest {

    //tests de creacion de unidades
    @Test
    public void testCuartelCreaEspadachin() {

        Jugador jugador = new Jugador("loo", new Mapa());
        Edificio cuartel = new Cuartel();

        ((Cuartel) cuartel).iniciarConstruccion();
        ((Cuartel) cuartel).finalizarConstruccion();

        Unidad espadachin = ((Cuartel) cuartel).colocarPieza(PiezaType.UNIDAD_ESPADACHIN, jugador);

        int vidaEsperada = 100;
        assertEquals(vidaEsperada, espadachin.obtenerVida());
    }

    @Test
    public void testCuartelCreaArquero() {

        Jugador jugador = new Jugador("loo", new Mapa());
        Edificio cuartel = new Cuartel();

        ((Cuartel) cuartel).iniciarConstruccion();
        ((Cuartel) cuartel).finalizarConstruccion();

        Unidad arquero = ((Cuartel) cuartel).colocarPieza(PiezaType.UNIDAD_ARQUERO, jugador);

        int vidaEsperada = 75;
        assertEquals(vidaEsperada, arquero.obtenerVida());
    }

    @Test (expected = InvalidUnidadTypeException.class)
    public void testCrearUnidadIncorrectaDeArmaDeAsedioEnCuartel() {
        Jugador jugador = new Jugador("loo", new Mapa());

        Edificio cuartel = new Cuartel();

        ((Cuartel) cuartel).iniciarConstruccion();
        ((Cuartel) cuartel).finalizarConstruccion();

        Unidad arquero = ((Cuartel) cuartel).colocarPieza(PiezaType.UNIDAD_ARMADEASEDIO, jugador);
    }

    //tests de recibeDanio
    @Test
    public void testCuartelRecibeDanioDeEspadachin() {

        Edificio cuartel = new Cuartel();

        for(int i = 0; i < 4; i++){
            //cuartel.construir();
        }
        cuartel.recibirDanioDe(new Espadachin());

        int vidaEsperada = 235;
        assertEquals(vidaEsperada, cuartel.obtenerVida());

    }

    @Test
    public void testCuartelRecibeDanioDeArquero() {

        Edificio cuartel = new Cuartel();

        for(int i = 0; i < 4; i++){
           // cuartel.construir();
        }
        cuartel.recibirDanioDe(new Arquero());

        int vidaEsperada = 240;
        assertEquals(vidaEsperada, cuartel.obtenerVida());

    }

    @Test
    public void testCuartelRecibeDanioDeArmaDeAsedio() {

        Edificio cuartel = new Cuartel();

        for(int i = 0; i < 4; i++){
            //cuartel.construir();
        }
        cuartel.recibirDanioDe(new ArmaDeAsedio());

        int vidaEsperada = 175;
        assertEquals(vidaEsperada, cuartel.obtenerVida());

    }

    @Test
    public void testCuartelRecibeDanioDeEspadachinArqueroYArmaDeAsedio() {

        Edificio cuartel = new Cuartel();

        cuartel.recibirDanioDe(new Espadachin());
        cuartel.recibirDanioDe(new Arquero());
        cuartel.recibirDanioDe(new ArmaDeAsedio());

        int vidaEsperada = 150;
        assertEquals(vidaEsperada, cuartel.obtenerVida());
    }

    //tests de getters

    @Test
    public void testGetTamanioDevuelve4(){
        Cuartel cuartel = new Cuartel();
        assertEquals(4, (long)cuartel.getTamanio());
    }

    @Test
    public void testObtenerTypeDevuelveEdificioCuartel(){
        Cuartel cuartel = new Cuartel();
        assertEquals(EDIFICIO_CUARTEL, cuartel.obtenerType());
    }

    //test dar vida por reparacion

    @Test
    public void testDarVidaPorReparacionAumentalaVidaDelCuartelEn50ComoMaximo() {
        Cuartel cuartel = new Cuartel();
        cuartel.recibirDanioDe(new ArmaDeAsedio());
        cuartel.reparacionPor(new Aldeano());

        assertEquals(225, cuartel.obtenerVida());
    }

    @Test
    public void testDarVidaPorReparacionAumentaLaVidaDelCuartelEn20SiElCuartelTiene230DeVida(){
        Cuartel cuartel = new Cuartel();
        Aldeano unAldeano = new Aldeano();
        cuartel.recibirDanioDe(new Espadachin());
        unAldeano.repararPieza(cuartel);

        assertEquals(250, cuartel.obtenerVida());
    }

    @Test
    public void testDarVidaPorReparacionNoAumentaLaVidaSiCuartelTieneVidaMaxima(){
        Cuartel cuartel = new Cuartel();
        cuartel.reparacionPor(new Aldeano());

        assertEquals(250, cuartel.obtenerVida());
    }


    //tests de estados

    @Test(expected = EdificioEnReparacionException.class)
    public void testIniciarReparacionCambiaElEstadoDeCuartelAEnReparacion(){
        Cuartel cuartel = new Cuartel();
        cuartel.recibirDanioDe(new Espadachin());
        cuartel.iniciarReparacion();

        cuartel.verificarProcesoEnReparacion();
    }

    @Test(expected = EdificioYaReparadoException.class)
    public void testIniciarReparacionLanzaExcepcionSiCuartelNoEstaDaniado(){
        Cuartel cuartel = new Cuartel();
        cuartel.iniciarReparacion();
    }

    @Test
    public void testCuartelRecienCreadoEstaEnEstadoReperado(){
        Cuartel cuartel = new Cuartel();

        assertFalse(cuartel.obtenerEstadoVida().estaEnReparacion());
        assertTrue(cuartel.obtenerEstadoVida().estaReparado());
    }

    @Test
    public void testCuartelRecienCreadoNoEstaEnConstruccion(){
        Cuartel cuartel = new Cuartel();

        assertFalse(cuartel.obtenerEstado().estaConstruido());
        assertFalse(cuartel.obtenerEstado().estaEnConstruccion());
    }

    @Test(expected = EdificioEnConstruccionException.class)
    public void testCuartelIniciarConstruccionCambiaElEstadoDeCuartelAEStaEnConstruccion(){
        Cuartel cuartel = new Cuartel();
        cuartel.iniciarConstruccion();

        cuartel.verificarProcesoEnConstruccion();
    }

    @Test
    public void testTerminarConstruccionCambiaElEstadoDeCuartelAConstruido(){
        Cuartel cuartel = new Cuartel();
        cuartel.iniciarConstruccion();
        cuartel.finalizarConstruccion();

        assertTrue(cuartel.obtenerEstado().estaConstruido());
        assertFalse(cuartel.obtenerEstado().estaEnConstruccion());
    }


}
