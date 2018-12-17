package fiuba.algo3.tp2;

import fiuba.algo3.tp2.modelo.Campo.Mapa;
import fiuba.algo3.tp2.modelo.Campo.Posicion;
import fiuba.algo3.tp2.modelo.Exception.SobrepoblacionException;
import fiuba.algo3.tp2.modelo.Juego.Juego;
import fiuba.algo3.tp2.modelo.Juego.Jugador;
import fiuba.algo3.tp2.modelo.Piezas.Edificios.Castillo;
import fiuba.algo3.tp2.modelo.Piezas.Edificios.Cuartel;
import fiuba.algo3.tp2.modelo.Piezas.Edificios.PlazaCentral;
import fiuba.algo3.tp2.modelo.Piezas.Unidades.Aldeano;
import fiuba.algo3.tp2.modelo.Piezas.Unidades.ArmaDeAsedio;
import fiuba.algo3.tp2.modelo.Piezas.Unidades.Arquero;
import fiuba.algo3.tp2.modelo.Piezas.Unidades.Espadachin;
import javafx.geometry.Pos;
import org.junit.Test;

import static junit.framework.TestCase.assertEquals;
import static junit.framework.TestCase.assertTrue;
import static org.junit.Assert.assertFalse;

public class JugadorTest {

    @Test
    public void testObtenerNombreDeJugadorVictorDevuelveStringVictor(){
        Jugador jugador = new Jugador("Victor", new Mapa());

        assertEquals("Victor", jugador.obtenerNombre());
    }

    @Test
    public void testObtenerCastilloDevuelveElMismoCastillo(){
        Jugador jugador = new Jugador("Victor", new Mapa());

        Castillo castillo = jugador.obtenerCastillo();
        assertEquals(castillo, jugador.obtenerCastillo());
    }

    @Test
    public void testJugadorRecienCreadoTiene100DeOro(){
        Jugador jugador = new Jugador("Victor", new Mapa());

        assertEquals(100, jugador.obtenerOro());
    }

    @Test
    public void testJugadorRecolecta20DeOroPor1Aldeano(){
        Jugador jugador = new Jugador("Victor", new Mapa());
        jugador.agregaPieza(new Aldeano());
        jugador.recolectarOro();

        assertEquals(120, jugador.obtenerOro());
    }

    @Test
    public void testJugadorConOroRecolectadoDe3AldeanosTiene160DeOro(){
        Jugador jugador = new Jugador("Victor", new Mapa());
        jugador.ubicarAldeanosPorDefault(new Posicion(1,1),
                                         new Posicion(2,1),
                                         new Posicion(2,2));
        jugador.recolectarOro();

        assertEquals(160, jugador.obtenerOro());
    }

    @Test
    public void testJugadorConOroRecolectadoDe0AldeanosTiene100DeOro(){
        Jugador jugador = new Jugador("Victor", new Mapa());
        jugador.recolectarOro();

        assertEquals(100, jugador.obtenerOro());
    }

    @Test
    public void testUbicarAldeanosPorDefaultColocaTresAldeanosEnPosicionesPasadasPorParametro(){
        Mapa mapa =  new Mapa();
        Posicion posicion1 = new Posicion(1,1);
        Posicion posicion2 = new Posicion(2,1);
        Posicion posicion3 = new Posicion(2,2);
        Jugador jugador = new Jugador("Victor", mapa);
        jugador.ubicarAldeanosPorDefault(posicion1, posicion2, posicion3);

        assertEquals(3, jugador.poblacion());
        assertEquals("Aldeano", mapa.recuperarPieza(posicion1).getClass().getSimpleName());
        assertEquals("Aldeano", mapa.recuperarPieza(posicion2).getClass().getSimpleName());
        assertEquals("Aldeano", mapa.recuperarPieza(posicion3).getClass().getSimpleName());
    }

    @Test
    public void testUbicarEdificiosPorDefaultUbica1castilloY1PlazaCentral(){
        Mapa mapa =  new Mapa();
        Posicion posicion1 = new Posicion(1,1);
        Posicion posicion2 = new Posicion(6,1);
        Jugador jugador = new Jugador("Victor", mapa);
        jugador.ubicarEdificiosPorDefault(posicion1, posicion2);

        assertEquals(0, jugador.poblacion());
        assertEquals("Castillo", mapa.recuperarPieza(posicion1).getClass().getSimpleName());
        assertEquals("PlazaCentral", mapa.recuperarPieza(posicion2).getClass().getSimpleName());
    }

    @Test
    public void testAgregarPiezaAumentaLaPoblacionSiLaPiezaEsUnaUnidad(){
        Jugador jugador =  new Jugador("Victor", new Mapa());
        jugador.agregaPieza(new Aldeano());
        jugador.agregaPieza(new Arquero());
        jugador.agregaPieza(new Espadachin());
        jugador.agregaPieza(new ArmaDeAsedio());

        assertEquals(4, jugador.poblacion());
    }

    @Test
    public void testAgregarPiezaNoAumentaLaPoblacionSiLaPiezaEsUnEdificioLoAgregaAPiezas(){
        Jugador jugador =  new Jugador("Victor", new Mapa());
        jugador.agregaPieza(new Cuartel());
        jugador.agregaPieza(new PlazaCentral());

        assertEquals(2, jugador.getPiezas().size());
    }

    @Test
    public void testSosDuenioDePiezaDevueveTrueSiEsDelJugador(){
        Jugador jugador =  new Jugador("Victor", new Mapa());
        Cuartel cuartel = new Cuartel();
        PlazaCentral plazaCentral =  new PlazaCentral();
        Aldeano aldeano = new Aldeano();

        jugador.agregaPieza(cuartel);
        jugador.agregaPieza(plazaCentral);
        jugador.agregaPieza(aldeano);

        assertTrue(jugador.sosDuenioDe(cuartel));
        assertTrue(jugador.sosDuenioDe(plazaCentral));
        assertTrue(jugador.sosDuenioDe(aldeano));
    }

    @Test
    public void testSosDuenioDeDevuelveFalseSiElJugadorNoEsDuenioDeLaPieza(){
        Jugador jugador =  new Jugador("Victor", new Mapa());
        Cuartel cuartel = new Cuartel();

        assertFalse(jugador.sosDuenioDe(cuartel));
    }

    @Test
    public void testPagarDisminuyeElOroPorElCostoDeLaPaga(){
        Jugador jugador =  new Jugador("Victor", new Mapa());
        jugador.pagar(50);

        assertEquals(50, jugador.obtenerOro());
    }

    @Test(expected = SobrepoblacionException.class)
    public void testValidarPoblacionMaximaLanzaExceptionSiLaPoblacionEsMayorA50(){
        Jugador jugador =  new Jugador("Victor", new Mapa());
        for(int i=0; i<51; i++)
            jugador.agregaPieza(new Aldeano());

        jugador.validarPoblacionMaxima();
    }

    @Test
    public void testJugadorYaNoTieneLasPiezasDestruidasCuandoSeActualizanLasPiezas(){
        Jugador jugador =  new Jugador("Victor", new Mapa());
        Aldeano aldeano = new Aldeano();

        jugador.agregaPieza(aldeano);

        try {
            aldeano.recibirDanio(50);
        }catch (Exception e ){}

        jugador.actualizarPiezas();
        assertEquals(0, jugador.poblacion());
        assertEquals(0, jugador.getPiezas().size());
    }

    @Test
    public void testActualizarPiezasNoEliminaLasPiezasQueNoEstanDestruidas(){
        Jugador jugador =  new Jugador("Victor", new Mapa());
        Aldeano aldeano = new Aldeano();

        jugador.agregaPieza(aldeano);

        jugador.actualizarPiezas();
        assertEquals(1, jugador.poblacion());
        assertEquals(1, jugador.getPiezas().size());
    }

    @Test
    public void testCastilloAtaqueMasivoAtacaAPiezasDelJugadorContrarioQueEstenenUnRangoMenorOIgualA3() {
        Juego juego = new Juego("victor", "manuel");
        Mapa mapa = juego.mapa();
        Jugador jugador1 = juego.jugador1();

        Cuartel cuartel = new Cuartel();
        PlazaCentral plazaCentral = new PlazaCentral();
        Arquero arquero = new Arquero();
        Espadachin espadachin = new Espadachin();

        juego.jugador2().agregaPieza(cuartel);
        juego.jugador2().agregaPieza(plazaCentral);
        juego.jugador2().agregaPieza(arquero);
        juego.jugador2().agregaPieza(espadachin);

        mapa.colocarPieza(cuartel, new Posicion(5, 34));
        mapa.colocarPieza(plazaCentral, new Posicion(0, 31));
        mapa.colocarPieza(arquero, new Posicion(3, 32));
        mapa.colocarPieza(espadachin, new Posicion(5, 32));

        jugador1.castilloAtaqueMasivo(juego);

        assertEquals(230, cuartel.obtenerVida());
        assertEquals(430, plazaCentral.obtenerVida());
        assertEquals(80, espadachin.obtenerVida());
        assertEquals(55, arquero.obtenerVida());
    }
}
