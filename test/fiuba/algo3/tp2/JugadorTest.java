package fiuba.algo3.tp2;

import fiuba.algo3.tp2.modelo.*;
import org.junit.Assert;
import org.junit.Test;
import fiuba.algo3.tp2.modelo.Constantes.*;
public class JugadorTest {


    @Test
    public void testJugadorInicializacion(){
        Jugador jugador = new Jugador("victor", new Mapa(FILA));
        Assert.assertEquals("victor", jugador.nombre());
    }

    @Test
    public void testJugadorIniciaCon100deOro() {
        Juego juego = new Juego();
        Jugador jugador = new Jugador("victor", juego);
        Assert.assertEquals(100, jugador.oro());
    }

    @Test
    public void testJugadorIniciaCon3Aldeanos() {
        Juego juego = new Juego();
        Jugador jugador = new Jugador("victor", juego);
        Assert.assertEquals(3, jugador.cantidadDeAdeanos());
    }

    @Test
    public void testJugadorIniciaConUnCastillo() {
        Juego juego = new Juego();
        Jugador jugador = new Jugador("victor", juego);
        Assert.assertTrue(jugador.tenesCastillo());
    }

    @Test
    public void testJugadorIniciaConUnaPlazaCentral() {
        Juego juego = new Juego();
        Jugador jugador = new Jugador("victor", juego);
        Assert.assertEquals(1, jugador.cantidadDePlazas());
    }

    @Test
    public void testJugadorCrearUnaUnidadRestaElCostoDeLaMisma() {
        Juego juego = new Juego();
        Jugador jugador = new Jugador("victor", juego);
        jugador.crearUnidad(25);
        Assert.assertEquals(75, jugador.oro());
    }

    @Test(expected = NoHaySuficienteOroException.class)
    public void testJugadorNohaySuficienteOroParaCrearUnidadLanzaException() {
        Juego juego = new Juego();
        Jugador jugador = new Jugador("victor", juego);
        jugador.crearUnidad(150);
    }

    @Test(expected = ExcedeElLimiteDePoblacionPosibleException.class)
    public void testJugadorCrearUnidadCuandoEstaEnElimiteDePoblacionLanzaException() {
        Juego juego = new Juego();
        Jugador jugador = new Jugador("victor", juego);
        for (int i = 0; i < 47; i++) {
            jugador.agregarAldeano(new Aldeano());
        }
        jugador.crearUnidad(25);
    }

    @Test
    public void testJugadorCrearUnEdificioRestaElCostoDeLMismo() {
        Juego juego = new Juego();
        Jugador jugador = new Jugador("victor", juego);
        jugador.crearEdificio(50);
        Assert.assertEquals(50, jugador.oro());
    }

    @Test(expected = NoHaySuficienteOroException.class)
    public void testJugadorNohaySuficienteOroParaCrearEdificioLanzaException() {
        Juego juego = new Juego();
        Jugador jugador = new Jugador("victor", juego);
        jugador.crearEdificio(200);
    }

    @Test
    public void testJugadorRecauda20DeOroPorAldeano() {
        Juego juego = new Juego();
        Jugador jugador = new Jugador("victor", juego);
        jugador.recaudarOro();
        Assert.assertEquals(160, jugador.oro());
    }

    @Test
    public void testJugadorAgragaUnAldeano() {
        Juego juego = new Juego();
        Jugador jugador = new Jugador("victor", juego);
        jugador.agregarAldeano(new Aldeano());
        Assert.assertEquals(4, jugador.cantidadDeAdeanos());
    }

    @Test
    public void testJugadorAgragaUnEspadachin() {
        Juego juego = new Juego();
        Jugador jugador = new Jugador("victor", juego);
        jugador.agregarEspadachin(new Espadachin());
        Assert.assertEquals(1, jugador.cantidadEspadachin());
    }

    @Test
    public void testJugadorAgragaUnArquero() {
        Juego juego = new Juego();
        Jugador jugador = new Jugador("victor", juego);
        jugador.agregarArquero(new Arquero());
        Assert.assertEquals(1, jugador.cantidadArqueros());
    }

    @Test
    public void testJugadorAgragaUnArmaAsedio() {
        Juego juego = new Juego();
        Jugador jugador = new Jugador("victor", juego);
        jugador.agregarArmaAsedio(new ArmaAsedio());
        Assert.assertEquals(1, jugador.cantidadArmaAsedio());
    }

    @Test
    public void testJugadorCastilloDestruidoNoTieneCastillo(){
        Juego juego = new Juego();
        Jugador jugador = new Jugador("victor", juego);
        jugador.castilloDestruido();
        Assert.assertFalse( jugador.tenesCastillo());
    }

}