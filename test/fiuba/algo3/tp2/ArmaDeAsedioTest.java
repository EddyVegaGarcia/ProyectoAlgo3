package fiuba.algo3.tp2;

import fiuba.algo3.tp2.modelo.Campo.Mapa;
import fiuba.algo3.tp2.modelo.Campo.Posicion;
import fiuba.algo3.tp2.modelo.Exception.*;
import fiuba.algo3.tp2.modelo.Exception.PiezaDestruidaException;
import fiuba.algo3.tp2.modelo.Interfaces.Atacante;
import fiuba.algo3.tp2.modelo.Interfaces.Montable;
import fiuba.algo3.tp2.modelo.Juego.Jugador;
import fiuba.algo3.tp2.modelo.Piezas.*;
import fiuba.algo3.tp2.modelo.Piezas.Edificios.Castillo;
import fiuba.algo3.tp2.modelo.Piezas.Edificios.Cuartel;
import fiuba.algo3.tp2.modelo.Piezas.Edificios.PlazaCentral;
import fiuba.algo3.tp2.modelo.Piezas.Unidades.*;
import org.junit.Test;

import java.util.ArrayList;

import static fiuba.algo3.tp2.modelo.Constantes.*;
import static fiuba.algo3.tp2.modelo.UnidadFactory.PiezaType.UNIDAD_ARMADEASEDIO;
import static org.junit.Assert.assertEquals;

public class ArmaDeAsedioTest {

    //test de recibir danio
    @Test
    public void testArmaDeAsedioRecibirDanioLaCantidadDeAtaqueDeEspadachin() {

        Unidad armaDeAsedio = new ArmaDeAsedio();

        armaDeAsedio.recibirDanio(ATAQUE_ESPADACHIN_A_UNIDAD);

        int vidaEsperada = 125;
        assertEquals(vidaEsperada, armaDeAsedio.obtenerVida());

    }

    @Test
    public void testArmaDeAsedioRecibirDanioLaCantidadDeAtaqueDeArquero() {

        Unidad armaDeAsedio = new ArmaDeAsedio();

        armaDeAsedio.recibirDanio(ATAQUE_ARQUERO_A_UNIDAD);

        int vidaEsperada = 135;
        assertEquals(vidaEsperada, armaDeAsedio.obtenerVida());

    }

    @Test
    public void testArmaDeAsedioRecibirDanioLaCantidadDeAtaqueDeCastillo() {

        Unidad armaDeAsedio = new ArmaDeAsedio();

        armaDeAsedio.recibirDanio(ATAQUE_CASTILLO);

        int vidaEsperada = 130;
        assertEquals(vidaEsperada, armaDeAsedio.obtenerVida());

    }

    @Test (expected = PiezaDestruidaException.class)
    public void testArmaDeAsedioRecibeDanioLaCantidadDeAtaqueDeEspadachinSeisVecesYMuere() {

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

        ArmaDeAsedio armaDeAsedio = new ArmaDeAsedio();

        armaDeAsedio.montar();

        int tiempoEsperado = 1;
        assertEquals(tiempoEsperado, armaDeAsedio.obtenerTiempoEsperado());

    }

    @Test
    public void testDesmontarArmaDeAsedioReiniciandoElContador() {

        ArmaDeAsedio armaDeAsedio = new ArmaDeAsedio();

        armaDeAsedio.montar();
        armaDeAsedio.refrescar();
        armaDeAsedio.desmontar();

        int tiempoEsperado = 0;
        assertEquals(tiempoEsperado, armaDeAsedio.obtenerTiempoEsperado());

    }

    @Test(expected = ArmaDeAsedioMontadaSinMovimientoException.class)
    public void testMoverArmaDeAsedioEnEstadoMontado() {

        ArmaDeAsedio unArmaDeAsedio = new ArmaDeAsedio();

        unArmaDeAsedio.montar();
        unArmaDeAsedio.refrescar();
        unArmaDeAsedio.movimientoPosible();

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
    public void testObtenerDistanciaDeAtaque() {
        ArmaDeAsedio armaDeAsedio = new ArmaDeAsedio();
        assertEquals(5, armaDeAsedio.obtenerDistanciaAtaque());
    }

    //tests de ataques
    @Test(expected = PiezaAtacadaNoValidaException.class)
    public void testArmaDeAsedioAtacaUnAldeano() {

        Atacante unArmaDeAsedio = new ArmaDeAsedio();
        Pieza unAldeano = new Aldeano();

        unArmaDeAsedio.atacarPieza(unAldeano);

    }

    @Test(expected = PiezaAtacadaNoValidaException.class)
    public void testArmaDeAsedioAtacaUnaPiezaCualquiera() {

        Atacante unArmaDeAsedio = new ArmaDeAsedio();
        Pieza unaPieza = new Arquero();

        unArmaDeAsedio.atacarPieza(unaPieza);

    }

    @Test
    public void testArmaDeAsedioAtacaUnCuartelADistanciaDeAtaqueCorrecto() {

        ArrayList<Posicion> unaListaPosicionAtacante = new ArrayList<>();
        ArrayList<Posicion> unaListaPosicionAtacable = new ArrayList<>();

        ArmaDeAsedio unArmaDeASedio = new ArmaDeAsedio();
        Posicion unaPosicionDelAtacante = new Posicion(15,15);
        unaListaPosicionAtacante.add(unaPosicionDelAtacante);
        
        unArmaDeASedio.agregarPosicion(unaListaPosicionAtacante);

        Pieza unCuartel = new Cuartel();

        unaListaPosicionAtacable.add(new Posicion(13,13));
        unaListaPosicionAtacable.add(new Posicion(13,14));
        unaListaPosicionAtacable.add( new Posicion(14,13));
        unaListaPosicionAtacable.add(new Posicion(14,14));
        
        unCuartel.agregarPosicion(unaListaPosicionAtacable);

        unArmaDeASedio.montar();
        unArmaDeASedio.refrescar();

        unArmaDeASedio.atacarPieza(unCuartel);

        int vidaEsperada = 175;
        assertEquals(vidaEsperada, unCuartel.obtenerVida());

    }

    @Test
    public void testArmaDeAsedioAtacaUnaPlazaCentralADistanciaDeAtaqueCorrecto() {

        ArrayList<Posicion> unaListaPosicionAtacante = new ArrayList<>();
        ArrayList<Posicion> unaListaPosicionAtacable = new ArrayList<>();

        ArmaDeAsedio unArmaDeASedio = new ArmaDeAsedio();
        Posicion unaPosicionDelAtacante = new Posicion(15,15);
        unaListaPosicionAtacante.add(unaPosicionDelAtacante);

        unArmaDeASedio.agregarPosicion(unaListaPosicionAtacante);

        Pieza unaPLazaCentral = new PlazaCentral();

        unaListaPosicionAtacable.add(new Posicion(13,13));
        unaListaPosicionAtacable.add(new Posicion(13,14));
        unaListaPosicionAtacable.add( new Posicion(14,13));
        unaListaPosicionAtacable.add(new Posicion(14,14));

        unaPLazaCentral.agregarPosicion(unaListaPosicionAtacable);

        unArmaDeASedio.montar();
        unArmaDeASedio.refrescar();

        unArmaDeASedio.atacarPieza(unaPLazaCentral);

        int vidaEsperada = 375;
        assertEquals(vidaEsperada, unaPLazaCentral.obtenerVida());
    }

    @Test
    public void testArmaDeAsedioAtacaUnCastilloADistanciaDeAtaqueCorrecto() {

        ArrayList<Posicion> unaListaPosicionAtacante = new ArrayList<>();

        Jugador unJugador = new Jugador("alex", new Mapa());

        Castillo unCastillo = unJugador.obtenerCastillo();

        ArmaDeAsedio unArmaDeASedio = new ArmaDeAsedio();
        Posicion unaPosicionDelAtacante = new Posicion(5,32);
        unaListaPosicionAtacante.add(unaPosicionDelAtacante);

        unArmaDeASedio.agregarPosicion(unaListaPosicionAtacante);

        unJugador.ubicarEdificiosPorDefault(POSICION_DEFAULT_CASTILLO1,POSICION_DEFAULT_PLAZA1);

        unArmaDeASedio.montar();
        unArmaDeASedio.refrescar();

        unArmaDeASedio.atacarPieza(unCastillo);

        int vidaEsperada = 925;
        assertEquals(vidaEsperada, unCastillo.obtenerVida());

    }

    @Test(expected = PiezaAtacadaNoEstaEnRangoDeAtaqueExeception.class)
    public void testArmaDeAsedioAtacaAUnEdificioQueNoSeEncuentraEnSuRangoDeAtaqueQueEsCinco() {

        ArrayList<Posicion> unaListaPosicionAtacante = new ArrayList<>();
        ArrayList<Posicion> unaListaPosicionAtacable = new ArrayList<>();

        ArmaDeAsedio unArmaDeASedio = new ArmaDeAsedio();
        Posicion unaPosicionDelAtacante = new Posicion(15,15);
        unaListaPosicionAtacante.add(unaPosicionDelAtacante);

        unArmaDeASedio.agregarPosicion(unaListaPosicionAtacante);

        Pieza unCuartel = new Cuartel();

        unaListaPosicionAtacable.add(new Posicion(8,8));
        unaListaPosicionAtacable.add(new Posicion(8,9));
        unaListaPosicionAtacable.add( new Posicion(9,8));
        unaListaPosicionAtacable.add(new Posicion(9,9));

        unCuartel.agregarPosicion(unaListaPosicionAtacable);

        unArmaDeASedio.montar();
        unArmaDeASedio.refrescar();

        unArmaDeASedio.atacarPieza(unCuartel);

    }
}
