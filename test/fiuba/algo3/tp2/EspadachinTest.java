package fiuba.algo3.tp2;

import fiuba.algo3.tp2.modelo.Campo.Posicion;
import fiuba.algo3.tp2.modelo.Exception.PiezaAtacadaNoEstaEnRangoDeAtaqueExeception;
import fiuba.algo3.tp2.modelo.Piezas.*;
import fiuba.algo3.tp2.modelo.Piezas.Edificios.Cuartel;
import fiuba.algo3.tp2.modelo.Piezas.Edificios.PlazaCentral;
import fiuba.algo3.tp2.modelo.Piezas.Unidades.Aldeano;
import fiuba.algo3.tp2.modelo.Piezas.Unidades.Arquero;
import fiuba.algo3.tp2.modelo.Piezas.Unidades.Espadachin;
import org.junit.Test;

import java.util.ArrayList;

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

    @Test
    public void testEspadachinAtacaAUnAldeanoADistanciaDeAtaqueCorrecto() {

        ArrayList<Posicion> unaListaPosicionAtacante = new ArrayList<>();
        ArrayList<Posicion> unaListaPosicionAtacable = new ArrayList<>();

        Espadachin unEspadachin = new Espadachin();
        unaListaPosicionAtacante.add(new Posicion(15,15));

        unEspadachin.agregarPosicion(unaListaPosicionAtacante);

        Aldeano unAldeano = new Aldeano();
        unaListaPosicionAtacable.add(new Posicion(14,14));
        unAldeano.agregarPosicion(unaListaPosicionAtacable);

        unEspadachin.atacarPieza(unAldeano);

        int vidaEsperada = 25;
        assertEquals(vidaEsperada, unAldeano.obtenerVida());

    }

    @Test
    public void testEspadachinAtacaAOtroEspadachinADistanciaDeAtaqueCorrecto() {

        ArrayList<Posicion> unaListaPosicionAtacante = new ArrayList<>();
        ArrayList<Posicion> unaListaPosicionAtacable = new ArrayList<>();

        Espadachin unEspadachin = new Espadachin();
        unaListaPosicionAtacante.add(new Posicion(15,15));

        unEspadachin.agregarPosicion(unaListaPosicionAtacante);

        Espadachin otroEspadachin = new Espadachin();
        unaListaPosicionAtacable.add(new Posicion(14,16));
        otroEspadachin.agregarPosicion(unaListaPosicionAtacable);

        unEspadachin.atacarPieza(otroEspadachin);

        int vidaEsperada = 75;
        assertEquals(vidaEsperada, otroEspadachin.obtenerVida());

    }

    @Test
    public void testEspadachinAtacaAUnArqueroADistanciaDeAtaqueCorrecto() {

        ArrayList<Posicion> unaListaPosicionAtacante = new ArrayList<>();
        ArrayList<Posicion> unaListaPosicionAtacable = new ArrayList<>();

        Espadachin unEspadachin = new Espadachin();
        unaListaPosicionAtacante.add(new Posicion(15,15));

        unEspadachin.agregarPosicion(unaListaPosicionAtacante);

        Arquero unArquero = new Arquero();
        unaListaPosicionAtacable.add(new Posicion(16,14));
        unArquero.agregarPosicion(unaListaPosicionAtacable);

        unEspadachin.atacarPieza(unArquero);

        int vidaEsperada = 50;
        assertEquals(vidaEsperada, unArquero.obtenerVida());

    }

    @Test(expected = PiezaAtacadaNoEstaEnRangoDeAtaqueExeception.class)
    public void testEspadachinAtacaAUnaUnidadQueNoSeEncuentraEnSuRangoDeAtaqueQueEsUno() {

        ArrayList<Posicion> unaListaPosicionAtacante = new ArrayList<>();
        ArrayList<Posicion> unaListaPosicionAtacable = new ArrayList<>();

        Espadachin unEspadachin = new Espadachin();
        unaListaPosicionAtacante.add(new Posicion(15,15));

        unEspadachin.agregarPosicion(unaListaPosicionAtacante);

        Arquero unArquero = new Arquero();
        unaListaPosicionAtacable.add(new Posicion(10,10));
        unArquero.agregarPosicion(unaListaPosicionAtacable);

        unEspadachin.atacarPieza(unArquero);

    }

    @Test
    public void testEspadachinAtacaAUnEdificioQueSeEncuentraEnSuRangoDeAtaqueQueEsUno() {

        ArrayList<Posicion> unaListaPosicionAtacante = new ArrayList<>();
        ArrayList<Posicion> unaListaPosicionAtacable = new ArrayList<>();

        Espadachin unEspadachin = new Espadachin();
        unaListaPosicionAtacante.add(new Posicion(8,36));

        unEspadachin.agregarPosicion(unaListaPosicionAtacante);

        Pieza unaPlazaCentral = new PlazaCentral();

        unaListaPosicionAtacable.add(new Posicion(9,37));
        unaListaPosicionAtacable.add(new Posicion(9,38));
        unaListaPosicionAtacable.add( new Posicion(10,37));
        unaListaPosicionAtacable.add(new Posicion(10,38));

        unaPlazaCentral.agregarPosicion(unaListaPosicionAtacable);

        unEspadachin.atacarPieza(unaPlazaCentral);

        int vidaEsperada = 435;

        assertEquals(vidaEsperada, unaPlazaCentral.obtenerVida());

    }

    @Test(expected = PiezaAtacadaNoEstaEnRangoDeAtaqueExeception.class)
    public void testEspadachinAtacaAUnEdificioQueNoSeEncuentraEnSuRangoDeAtaqueQueEsUno() {

        ArrayList<Posicion> unaListaPosicionAtacante = new ArrayList<>();
        ArrayList<Posicion> unaListaPosicionAtacable = new ArrayList<>();

        Espadachin unEspadachin = new Espadachin();
        unaListaPosicionAtacante.add(new Posicion(11,11));

        unEspadachin.agregarPosicion(unaListaPosicionAtacante);

        Pieza unCuartel = new Cuartel();

        unaListaPosicionAtacable.add(new Posicion(8,8));
        unaListaPosicionAtacable.add(new Posicion(8,9));
        unaListaPosicionAtacable.add( new Posicion(9,8));
        unaListaPosicionAtacable.add(new Posicion(9,9));

        unCuartel.agregarPosicion(unaListaPosicionAtacable);

        unEspadachin.atacarPieza(unCuartel);

    }


}
