package fiuba.algo3.tp2;

import fiuba.algo3.tp2.modelo.Campo.Posicion;
import fiuba.algo3.tp2.modelo.Exception.*;
import fiuba.algo3.tp2.modelo.Exception.PiezaDestruidaException;
import fiuba.algo3.tp2.modelo.Interfaces.Atacante;
import fiuba.algo3.tp2.modelo.Interfaces.Montable;
import fiuba.algo3.tp2.modelo.Piezas.*;
import fiuba.algo3.tp2.modelo.Piezas.Edificios.Cuartel;
import fiuba.algo3.tp2.modelo.Piezas.Edificios.PlazaCentral;
import fiuba.algo3.tp2.modelo.Piezas.Unidades.*;
import org.junit.Test;

import java.util.ArrayList;

import static fiuba.algo3.tp2.modelo.Constantes.*;
import static org.junit.Assert.assertEquals;

public class ArmaDeAsedioTest {

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

    @Test
    public void testMontarArmaDeAsedioConContadorIniciado() {

        Montable armaDeAsedio = new ArmaDeAsedio();

        armaDeAsedio.montar();

        int tiempoEsperado = 1;
        assertEquals(tiempoEsperado, ((ArmaDeAsedio) armaDeAsedio).obtenerTiempoEsperado());

    }

    @Test
    public void testDesmontarArmaDeAsedioReiniciandoElContador() {

        Montable armaDeAsedio = new ArmaDeAsedio();

        armaDeAsedio.montar();
        ((ArmaDeAsedio) armaDeAsedio).refrescar();
        armaDeAsedio.desmontar();

        int tiempoEsperado = 0;
        assertEquals(tiempoEsperado, ((ArmaDeAsedio) armaDeAsedio).obtenerTiempoEsperado());

    }

    @Test(expected = ArmaDeAsedioMontadaSinMovimientoException.class)
    public void testMoverArmaDeAsedioEnEstadoMontado() {

        Montable unArmaDeAsedio = new ArmaDeAsedio();

        unArmaDeAsedio.montar();
        ((ArmaDeAsedio) unArmaDeAsedio).refrescar();
        ((ArmaDeAsedio) unArmaDeAsedio).movimientoPosible();

    }

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
    public void testArmaDeAsedioAtacaUnCuartel() {

        ArrayList<Posicion> unaListaPosicionAtacante = new ArrayList<>();
        ArrayList<Posicion> unaListaPosicionAtacable = new ArrayList<>();

        Atacante unArmaDeASedio = new ArmaDeAsedio();
        Posicion unaPosicionDelAtacante = new Posicion(15,15);
        unaListaPosicionAtacante.add(unaPosicionDelAtacante);
        
        ((ArmaDeAsedio) unArmaDeASedio).agregarPosicion(unaListaPosicionAtacante);

        Pieza unCuartel = new Cuartel();
        Posicion unaPosicionDelAtacable_1 = new Posicion(13,13);
        unaListaPosicionAtacable.add(unaPosicionDelAtacable_1);
        Posicion unaPosicionDelAtacable_2 = new Posicion(13,14);
        unaListaPosicionAtacable.add(unaPosicionDelAtacable_2);
        Posicion unaPosicionDelAtacable_3 = new Posicion(14,13);
        unaListaPosicionAtacable.add(unaPosicionDelAtacable_3);
        Posicion unaPosicionDelAtacable_4 = new Posicion(14,14);
        unaListaPosicionAtacable.add(unaPosicionDelAtacable_4);
        
        unCuartel.agregarPosicion(unaListaPosicionAtacable);

        ((ArmaDeAsedio) unArmaDeASedio).montar();
        ((ArmaDeAsedio) unArmaDeASedio).refrescar();

        unArmaDeASedio.atacarPieza(unCuartel);

        int vidaEsperada = 175;
        assertEquals(vidaEsperada, unCuartel.obtenerVida());

    }

    @Test
    public void testArmaDeAsedioAtacaUnaPlazaCentral() {

        ArrayList<Posicion> unaListaPosicionAtacante = new ArrayList<>();
        ArrayList<Posicion> unaListaPosicionAtacable = new ArrayList<>();

        Atacante unArmaDeASedio = new ArmaDeAsedio();
        Posicion unaPosicionDelAtacante = new Posicion(15,15);
        unaListaPosicionAtacante.add(unaPosicionDelAtacante);

        ((ArmaDeAsedio) unArmaDeASedio).agregarPosicion(unaListaPosicionAtacante);

        Pieza unaPLazaCentral = new PlazaCentral();
        Posicion unaPosicionDelAtacable_1 = new Posicion(13,13);
        unaListaPosicionAtacable.add(unaPosicionDelAtacable_1);
        Posicion unaPosicionDelAtacable_2 = new Posicion(13,14);
        unaListaPosicionAtacable.add(unaPosicionDelAtacable_2);
        Posicion unaPosicionDelAtacable_3 = new Posicion(14,13);
        unaListaPosicionAtacable.add(unaPosicionDelAtacable_3);
        Posicion unaPosicionDelAtacable_4 = new Posicion(14,14);
        unaListaPosicionAtacable.add(unaPosicionDelAtacable_4);

        unaPLazaCentral.agregarPosicion(unaListaPosicionAtacable);

        ((ArmaDeAsedio) unArmaDeASedio).montar();
        ((ArmaDeAsedio) unArmaDeASedio).refrescar();

        unArmaDeASedio.atacarPieza(unaPLazaCentral);

        int vidaEsperada = 375;
        assertEquals(vidaEsperada, unaPLazaCentral.obtenerVida());
    }
}
