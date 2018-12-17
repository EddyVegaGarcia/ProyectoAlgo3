package fiuba.algo3.tp2;

import fiuba.algo3.tp2.modelo.Campo.Posicion;
import fiuba.algo3.tp2.modelo.Exception.PiezaAtacadaNoEstaEnRangoDeAtaqueExeception;
import fiuba.algo3.tp2.modelo.Piezas.*;
import fiuba.algo3.tp2.modelo.Piezas.Edificios.Cuartel;
import fiuba.algo3.tp2.modelo.Piezas.Edificios.PlazaCentral;
import fiuba.algo3.tp2.modelo.Piezas.Unidades.*;

import org.junit.Test;

import java.util.ArrayList;

import static fiuba.algo3.tp2.modelo.Constantes.*;
import static fiuba.algo3.tp2.modelo.UnidadFactory.PiezaType.UNIDAD_ARQUERO;
import static org.junit.Assert.assertEquals;

public class ArqueroTest {


    @Test
    public void testArquerochinRecibirDanioLaCantidadDeAtaqueDeEspadachin() {

        Unidad arquero = new Arquero();

        arquero.recibirDanio(ATAQUE_ESPADACHIN_A_UNIDAD);

        int vidaEsperada = 50;
        assertEquals(vidaEsperada, arquero.obtenerVida());

    }

    @Test
    public void testArquerochinRecibirDanioLaCantidadDeAtaqueDeOtroArquero() {

        Unidad arquero = new Arquero();

        arquero.recibirDanio(ATAQUE_ARQUERO_A_UNIDAD);

        int vidaEsperada = 60;
        assertEquals(vidaEsperada, arquero.obtenerVida());

    }

    @Test
    public void testArqueroRecibirDanioLaCantidadDeAtaqueDeCastillo() {

        Unidad arquero = new Arquero();

        arquero.recibirDanio(ATAQUE_CASTILLO);

        int vidaEsperada = 55;
        assertEquals(vidaEsperada, arquero.obtenerVida());

    }

    @Test
    public void testArqueroRecibirDanioLaCantidadDeAtaqueDeEspadachinOtroArqueroYCastillo() {

        Unidad arquero = new Arquero();

        arquero.recibirDanio(ATAQUE_ESPADACHIN_A_UNIDAD);
        arquero.recibirDanio(ATAQUE_ARQUERO_A_UNIDAD);
        arquero.recibirDanio(ATAQUE_CASTILLO);

        int vidaEsperada = 15;
        assertEquals(vidaEsperada, arquero.obtenerVida());

    }

    //tests de getters
    @Test
    public void testObtenerDistanciaDeAtaqueDevuelveTres(){
        Arquero arquero =  new Arquero();
        assertEquals(3, arquero.obtenerDistanciaAtaque());
    }

    @Test
    public void testGetTamanioDevuelve1(){
        Arquero arquero = new Arquero();
        assertEquals(1, (long)arquero.getTamanio());
    }

    @Test
    public void testObtenerTypeDevuelveUnidadArquero(){
        Arquero arquero = new Arquero();
        assertEquals(UNIDAD_ARQUERO, arquero.obtenerType());
    }

    @Test
    public void testArqueroAtacaAUnAldeanoADistanciaDeAtaqueCorrecto() {

        ArrayList<Posicion> unaListaPosicionAtacante = new ArrayList<>();
        ArrayList<Posicion> unaListaPosicionAtacable = new ArrayList<>();

        Arquero unArquero = new Arquero();
        unaListaPosicionAtacante.add(new Posicion(15,15));

        unArquero.agregarPosicion(unaListaPosicionAtacante);

        Aldeano unAldeano = new Aldeano();
        unaListaPosicionAtacable.add(new Posicion(13,13));
        unAldeano.agregarPosicion(unaListaPosicionAtacable);

        unArquero.atacarPieza(unAldeano);

        int vidaEsperada = 35;
        assertEquals(vidaEsperada, unAldeano.obtenerVida());

    }

    @Test
    public void testArqueroAtacaAUnEspadachinADistanciaDeAtaqueCorrecto() {

        ArrayList<Posicion> unaListaPosicionAtacante = new ArrayList<>();
        ArrayList<Posicion> unaListaPosicionAtacable = new ArrayList<>();

        Arquero unArquero = new Arquero();
        unaListaPosicionAtacante.add(new Posicion(15,15));

        unArquero.agregarPosicion(unaListaPosicionAtacante);

        Espadachin unEspadachin = new Espadachin();
        unaListaPosicionAtacable.add(new Posicion(13,13));
        unEspadachin.agregarPosicion(unaListaPosicionAtacable);

        unArquero.atacarPieza(unEspadachin);

        int vidaEsperada = 85;
        assertEquals(vidaEsperada, unEspadachin.obtenerVida());

    }

    @Test
    public void testArqueroAtacaAOtroArqueroADistanciaDeAtaqueCorrecto() {

        ArrayList<Posicion> unaListaPosicionAtacante = new ArrayList<>();
        ArrayList<Posicion> unaListaPosicionAtacable = new ArrayList<>();

        Arquero unArquero = new Arquero();
        unaListaPosicionAtacante.add(new Posicion(15,15));

        unArquero.agregarPosicion(unaListaPosicionAtacante);

        Arquero otroArquero = new Arquero();
        unaListaPosicionAtacable.add(new Posicion(13,13));
        otroArquero.agregarPosicion(unaListaPosicionAtacable);

        unArquero.atacarPieza(otroArquero);

        int vidaEsperada = 60;
        assertEquals(vidaEsperada, otroArquero.obtenerVida());

    }

    @Test(expected = PiezaAtacadaNoEstaEnRangoDeAtaqueExeception.class)
    public void testArqueroAtacaAUnaUnidadQueNoSeEncuentraEnSuRangoDeAtaqueQueEsTres() {

        ArrayList<Posicion> unaListaPosicionAtacante = new ArrayList<>();
        ArrayList<Posicion> unaListaPosicionAtacable = new ArrayList<>();

        Arquero unArquero = new Arquero();
        unaListaPosicionAtacante.add(new Posicion(15,15));

        unArquero.agregarPosicion(unaListaPosicionAtacante);

        Arquero otroArquero = new Arquero();
        unaListaPosicionAtacable.add(new Posicion(10,10));
        otroArquero.agregarPosicion(unaListaPosicionAtacable);

        unArquero.atacarPieza(otroArquero);

    }


    @Test
    public void testArqueroAtacaAUnEdificioQueSeEncuentraEnSuRangoDeAtaqueQueEsTres() {

        ArrayList<Posicion> unaListaPosicionAtacante = new ArrayList<>();
        ArrayList<Posicion> unaListaPosicionAtacable = new ArrayList<>();

        Arquero unArquero = new Arquero();
        unaListaPosicionAtacante.add(new Posicion(12,12));

        unArquero.agregarPosicion(unaListaPosicionAtacante);

        Pieza unaPlazaCentral = new PlazaCentral();

        unaListaPosicionAtacable.add(new Posicion(8,8));
        unaListaPosicionAtacable.add(new Posicion(8,9));
        unaListaPosicionAtacable.add( new Posicion(9,8));
        unaListaPosicionAtacable.add(new Posicion(9,9));

        unaPlazaCentral.agregarPosicion(unaListaPosicionAtacable);

        unArquero.atacarPieza(unaPlazaCentral);

        int vidaEsperada = 440;

        assertEquals(vidaEsperada, unaPlazaCentral.obtenerVida());

    }

    @Test(expected = PiezaAtacadaNoEstaEnRangoDeAtaqueExeception.class)
    public void testArqueroAtacaAUnEdificioQueNoSeEncuentraEnSuRangoDeAtaqueQueEsTres() {

        ArrayList<Posicion> unaListaPosicionAtacante = new ArrayList<>();
        ArrayList<Posicion> unaListaPosicionAtacable = new ArrayList<>();

        Arquero unArquero = new Arquero();
        unaListaPosicionAtacante.add(new Posicion(15,15));

        unArquero.agregarPosicion(unaListaPosicionAtacante);

        Pieza unCuartel = new Cuartel();

        unaListaPosicionAtacable.add(new Posicion(8,8));
        unaListaPosicionAtacable.add(new Posicion(8,9));
        unaListaPosicionAtacable.add( new Posicion(9,8));
        unaListaPosicionAtacable.add(new Posicion(9,9));

        unCuartel.agregarPosicion(unaListaPosicionAtacable);

        unArquero.atacarPieza(unCuartel);

    }

}
