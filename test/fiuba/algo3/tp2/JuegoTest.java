package fiuba.algo3.tp2;

import org.junit.Assert;
import org.junit.Test;

public class JuegoTest{

    @Test
    public void testJuegoAlCrearseTieneDosJugadores(){
        Juego juego = new Juego();
        Assert.assertEquals(2, juego.cantidadDeJugadores());
    }


    @Test
    public void testJuegoNoFinalizaSiNingunCastilloFueDestruido(){
        Juego juego = new Juego();
        Assert.assertFalse(juego.estaFinalizado());
    }

    @Test
    public void testJuegoFinalizaCuandoElCastilloDeUnJugadorEsDestruido(){
        Juego juego = new Juego();
        Jugador jugador = juego.jugador(1);
        jugador.castilloDestruido();
        Assert.assertTrue(juego.estaFinalizado());
    }

    @Test
    public void testPerdioJugador1SiSuCastilloFueDestruido(){
        Juego juego = new Juego();
        Jugador jugador = juego.jugador(1);
        jugador.castilloDestruido();
        Jugador perdedor = Juego.perdedor();
        Assert.assertEquals(jugador.nombre(), perdedor.nombre());
    }

    @Test
    public void testGanoJugador2SiElCastilloDelJugador1FueDestruido(){
        Juego juego = new Juego();
        Jugador jugador = juego.jugador(1);
        jugador.castilloDestruido();
        Jugador jugador2 = juego.jugador(2);
        Jugador ganador = Juego.ganador();
        Assert.assertEquals(jugador2.nombre(), ganador.nombre());
    }
}
