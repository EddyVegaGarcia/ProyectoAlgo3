package fiuba.algo3.tp2;

import org.junit.Assert;
import org.junit.Test;

public class JugadorTest {

    @Test
    public void testJugadorIniciaCon100deOro() {
        Jugador jugador = new Jugador();
        Assert.assertEquals(100, jugador.oro());
    }

    @Test
    public void testJugadorIniciaCon3Aldeanos() {
        Jugador jugador = new Jugador();
        Assert.assertEquals(3, jugador.cantidadDeAdeanos());
    }

    @Test
    public void testJugadorIniciaConUnCastillo() {
        Jugador jugador = new Jugador();
        Assert.assertTrue(jugador.tenesCastillo());
    }

    @Test
    public void testJugadorIniciaConUnaPlazaCentral() {
        Jugador jugador = new Jugador();
        Assert.assertEquals(1, jugador.cantidadDePlazas());
    }

    @Test
    public void testJugadorCrearUnaUnidadRestaElCostoDeLaMisma() {
        Jugador jugador = new Jugador();
        jugador.crearUnidad(25);
        Assert.assertEquals(75, jugador.oro());
    }

    @Test(expected = NoHaySuficienteOroException.class)
    public void testJugadorNohaySuficienteOroParaCrearUnidadLanzaException() {
        Jugador jugador = new Jugador();
        jugador.crearUnidad(150);
    }

    @Test(expected = ExcedeElLimiteDePoblacionPosibleException.class)
    public void testJugadorCrearUnidadCuandoEstaEnElimiteDePoblacionLanzaException() {
        Jugador jugador = new Jugador();
        for (int i = 0; i < 47; i++) {
            jugador.agregarAldeano(new Aldeano("0,0"));
        }
        jugador.crearUnidad(25);
    }

    @Test
    public void testJugadorCrearUnEdificioRestaElCostoDeLMismo() {
        Jugador jugador = new Jugador();
        jugador.crearEdificio(50);
        Assert.assertEquals(50, jugador.oro());
    }

    @Test(expected = NoHaySuficienteOroException.class)
    public void testJugadorNohaySuficienteOroParaCrearEdificioLanzaException() {
        Jugador jugador = new Jugador();
        jugador.crearEdificio(200);
    }

    @Test
    public void testJugadorRecauda20DeOroPorAldeano() {
        Jugador jugador = new Jugador();
        jugador.recaudarOro();
        Assert.assertEquals(160, jugador.oro());
    }

    @Test
    public void testJugadorAgragaUnAldeano() {
        Jugador jugador = new Jugador();
        jugador.agregarAldeano(new Aldeano("0,0"));
        Assert.assertEquals(4, jugador.cantidadDeAdeanos());
    }

    @Test
    public void testJugadorAgragaUnEspadachin() {
        Jugador jugador = new Jugador();
        jugador.agregarEspadachin(new Espadachin("0,0"));
        Assert.assertEquals(1, jugador.cantidadEspadachin());
    }

    @Test
    public void testJugadorAgragaUnArquero() {
        Jugador jugador = new Jugador();
        jugador.agregarArquero(new Arquero("0,0"));
        Assert.assertEquals(1, jugador.cantidadArqueros());
    }

    @Test
    public void testJugadorAgragaUnArmaAsedio() {
        Jugador jugador = new Jugador();
        jugador.agregarArmaAsedio(new ArmaAsedio("0,0"));
        Assert.assertEquals(1, jugador.cantidadArmaAsedio());
    }

    @Test
    public void testJugadorCastilloDestruidoNoTieneCastillo(){
        Jugador jugador = new Jugador();
        jugador.castilloDestruido();
        Assert.assertFalse( jugador.tenesCastillo());
    }
}