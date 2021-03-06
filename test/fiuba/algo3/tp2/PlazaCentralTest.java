package fiuba.algo3.tp2;

import fiuba.algo3.tp2.modelo.Campo.Mapa;
import fiuba.algo3.tp2.modelo.Exception.*;
import fiuba.algo3.tp2.modelo.Juego.Jugador;
import fiuba.algo3.tp2.modelo.Piezas.Edificios.PlazaCentral;
import fiuba.algo3.tp2.modelo.Piezas.*;
import fiuba.algo3.tp2.modelo.Piezas.Unidades.ArmaDeAsedio;
import fiuba.algo3.tp2.modelo.Piezas.Unidades.Arquero;
import fiuba.algo3.tp2.modelo.Piezas.Unidades.Espadachin;
import fiuba.algo3.tp2.modelo.UnidadFactory.*;
import org.junit.Test;

import static fiuba.algo3.tp2.modelo.Constantes.*;
import static org.junit.Assert.*;

public class PlazaCentralTest {

    @Test
    public void testPlazaCentralCreaAldeano(){
        Jugador jugador = new Jugador("loo", new Mapa());

        Edificio plazaCentral = new PlazaCentral();

        ((PlazaCentral) plazaCentral).iniciarConstruccion();
        ((PlazaCentral) plazaCentral).finalizarConstruccion();

        Unidad aldeano = ((PlazaCentral) plazaCentral).colocarPieza(PiezaType.UNIDAD_ALDEANO, jugador);

        int vidaEsperada = 50;
        assertEquals(vidaEsperada, aldeano.obtenerVida());

    }

    @Test (expected = InvalidUnidadTypeException.class)
    public void testCrearUnidadIncorrectaDeEspadachinEnPlazaCentral() {

        Jugador jugador = new Jugador("loo", new Mapa());
        Edificio plazaCentral = new PlazaCentral();

        ((PlazaCentral) plazaCentral).iniciarConstruccion();
        ((PlazaCentral) plazaCentral).finalizarConstruccion();

        Unidad aldeano = ((PlazaCentral) plazaCentral).colocarPieza(PiezaType.UNIDAD_ESPADACHIN, jugador);
    }

    @Test
    public void testPlazaCentralRecibeDanioDeEspadachin() {

        Edificio plazaCentral = new PlazaCentral();

        for(int i = 0; i < 4; i++){
            //plazaCentral.construir();
        }
        plazaCentral.recibirDanioDe(new Espadachin());

        int vidaEsperada = 435;
        assertEquals(vidaEsperada, plazaCentral.obtenerVida());

    }

    @Test
    public void testPlazaCentralRecibeDanioDeArquero() {

        Edificio plazaCentral = new PlazaCentral();

        for(int i = 0; i < 4; i++){
            //plazaCentral.construir();
        }
        plazaCentral.recibirDanioDe(new Arquero());

        int vidaEsperada = 440;
        assertEquals(vidaEsperada, plazaCentral.obtenerVida());

    }

    @Test
    public void testPlazaCentralRecibeDanioDeArmaDeAsedio() {

        Edificio plazaCentral = new PlazaCentral();

        for(int i = 0; i < 4; i++){
            //plazaCentral.construir();
        }
        plazaCentral.recibirDanioDe(new ArmaDeAsedio());

        int vidaEsperada = 375;
        assertEquals(vidaEsperada, plazaCentral.obtenerVida());

    }

    @Test
    public void testPlazaCentralRecibeDanioDeEspadachinArqueroYArmaDeAsedio() {

        Edificio plazaCentral = new PlazaCentral();

        for(int i = 0; i < 4; i++){
            //plazaCentral.construir();
        }
        plazaCentral.recibirDanioDe(new Espadachin());
        plazaCentral.recibirDanioDe(new Arquero());
        plazaCentral.recibirDanioDe(new ArmaDeAsedio());

        int vidaEsperada = 350;
        assertEquals(vidaEsperada, plazaCentral.obtenerVida());

    }

    //tests de estados
    @Test
    public void testPlazaRecienCreadaNoEstaEnConstruccion(){
        PlazaCentral plazaCentral =  new PlazaCentral();

        assertFalse(plazaCentral.obtenerEstado().estaEnConstruccion());
        assertFalse(plazaCentral.obtenerEstado().estaConstruido());
    }

    @Test
    public void testIniciarConstruccionEnPlazaCambiaSuEstadoAEnConstruccion(){
        PlazaCentral plazaCentral =  new PlazaCentral();
        plazaCentral.iniciarConstruccion();

        assertTrue(plazaCentral.obtenerEstado().estaEnConstruccion());
        assertFalse(plazaCentral.obtenerEstado().estaConstruido());
    }

    @Test(expected = EdificioYaConstruidoException.class)
    public void testTerminarConstruccionCambiaElEstadoDePlazaAConstruidoYLanzaException(){
        PlazaCentral plazaCentral =  new PlazaCentral();
        plazaCentral.iniciarConstruccion();
        plazaCentral.finalizarConstruccion();

        plazaCentral.verificarProcesoEnConstruccion();
    }

    @Test
    public void testPlazaRecienCreadaEstaReparada(){
        PlazaCentral plazaCentral =  new PlazaCentral();

        assertTrue(plazaCentral.obtenerEstadoVida().estaReparado());
    }

    @Test
    public void testPlazaDaniadaNoEstaReparada(){
        PlazaCentral plazaCentral =  new PlazaCentral();
        plazaCentral.recibirDanioDe(new Espadachin());

        assertFalse(plazaCentral.obtenerEstadoVida().estaReparado());
    }

    @Test(expected = EdificioEnReparacionException.class)
    public void testPlazaDaniadaInnciarReparacionCambiaElEstadoAEnReparacion(){
        PlazaCentral plazaCentral =  new PlazaCentral();
        plazaCentral.recibirDanioDe(new Espadachin());
        plazaCentral.iniciarReparacion();

        plazaCentral.verificarProcesoEnReparacion();
    }

    @Test
    public void testTerminarReparacionDeUnaPlazaEnReparacionEstaReparada(){
        PlazaCentral plazaCentral =  new PlazaCentral();
        plazaCentral.recibirDanioDe(new Espadachin());
        plazaCentral.iniciarReparacion();
        plazaCentral.finalizarReparacion();

        assertTrue(plazaCentral.obtenerEstadoVida().estaReparado());
    }


}
