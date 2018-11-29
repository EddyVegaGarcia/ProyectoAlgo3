package fiuba.algo3.tp2;

import fiuba.algo3.tp2.modelo.*;
import org.junit.Assert;
import org.junit.Test;
import fiuba.algo3.tp2.modelo.Exception.*;

import java.util.ArrayList;

import static fiuba.algo3.tp2.modelo.Constantes.*;
import static org.junit.Assert.assertEquals;

public class AldeanoTest {

    @Test
    public void AldeanoConstruyeCuartel() {

        Mapa mapa = new Mapa(FILA_DEFAULT_MAPA, COLUMNA_DEFAULT_MAPA);

       ArrayList posicionAldeano = new ArrayList<Posicion>();
       ArrayList posicionCuartel = new ArrayList<Posicion>();
       Posicion posicion1 = new Posicion(29, 13);
       Posicion posicion2 = new Posicion(27, 13);
       posicionAldeano.add(posicionAldeano);
       posicionCuartel.add(posicion2);

       Aldeano aldeano = new Aldeano(posicionAldeano);
       Cuartel unCuartel = new Cuartel(posicionCuartel);


        mapa.colocarUnidad(aldeano,posicion1);
        mapa.colocarEdificio(unCuartel, posicion2);

        aldeano.construir(unCuartel);

        Assert.assertTrue(true);

    }

    @Test
    public void testAldeanoRecibirDanioDeEspadachin() {

        Unidad aldeano = new Aldeano();

        aldeano.recibirDanio(ATAQUE_ESPADACHIN_A_UNIDAD);

        int vidaEsperada = 25;
        assertEquals(vidaEsperada, aldeano.obtenerVida());

    }

    @Test
    public void testAldeanoRecibirDanioDeArquero() {

        Unidad aldeano = new Aldeano();

        aldeano.recibirDanio(ATAQUE_ARQUERO_A_UNIDAD);

        int vidaEsperada = 35;
        assertEquals(vidaEsperada, aldeano.obtenerVida());

    }

    @Test
    public void testAldeanoRecibirDanioDeCastillo() {

        Unidad aldeano = new Aldeano();

        aldeano.recibirDanio(ATAQUE_CASTILLO);

        int vidaEsperada = 30;
        assertEquals(vidaEsperada, aldeano.obtenerVida());

    }

    @Test (expected = PiezaDestruidaException.class)
    public void testAldeanoRecibeDanioDeEspadachinDosVecesYMuere() {

        Unidad aldeano = new Aldeano();

        aldeano.recibirDanio(ATAQUE_ESPADACHIN_A_UNIDAD);
        aldeano.recibirDanio(ATAQUE_ESPADACHIN_A_UNIDAD);
    }
}