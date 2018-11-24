package fiuba.algo3.tp2;

import fiuba.algo3.tp2.modelo.*;
import org.junit.Test;

import static fiuba.algo3.tp2.modelo.Constantes.*;
import static org.junit.Assert.assertEquals;

public class CuartelTest {

    @Test
    public void testCuartelCreaEspadachin() {

        Edificio cuartel = new Cuartel();

        Unidad espadachin = ((Cuartel) cuartel).crearEspadachin();

        int vidaEsperada = 100;
        assertEquals(vidaEsperada, espadachin.obtenerVida());
    }

    @Test
    public void testCuartelCreaArquero() {

        Edificio cuartel = new Cuartel();

        Unidad arquero = ((Cuartel) cuartel).crearArquero();

        int vidaEsperada = 75;
        assertEquals(vidaEsperada, arquero.obtenerVida());
    }

    @Test
    public void testCuartelRecibeDanioDeEspadachin() {

        Edificio cuartel = new Cuartel();

        for(int i = 0; i < 4; i++){
            cuartel.construir();
        }
        cuartel.recibirDanio(ATAQUE_ESPADACHIN_A_EDIFICIO);

        int vidaEsperada = 235;
        assertEquals(vidaEsperada, cuartel.obtenerVida());

    }

    @Test
    public void testCuartelRecibeDanioDeArquero() {

        Edificio cuartel = new Cuartel();

        for(int i = 0; i < 4; i++){
            cuartel.construir();
        }
        cuartel.recibirDanio(ATAQUE_ARQUERO_A_EDIFICIO);

        int vidaEsperada = 240;
        assertEquals(vidaEsperada, cuartel.obtenerVida());

    }

    @Test
    public void testCuartelRecibeDanioDeArmaDeAsedio() {

        Edificio cuartel = new Cuartel();

        for(int i = 0; i < 4; i++){
            cuartel.construir();
        }
        cuartel.recibirDanio(ATAQUE_ARMADEASEDIO);

        int vidaEsperada = 175;
        assertEquals(vidaEsperada, cuartel.obtenerVida());

    }

    @Test
    public void testCuartelRecibeDanioDeEspadachinArqueroYArmaDeAsedio() {

        Edificio cuartel = new Cuartel();

        for(int i = 0; i < 4; i++){
            cuartel.construir();
        }
        cuartel.recibirDanio(ATAQUE_ESPADACHIN_A_EDIFICIO);
        cuartel.recibirDanio(ATAQUE_ARQUERO_A_EDIFICIO);
        cuartel.recibirDanio(ATAQUE_ARMADEASEDIO);

        int vidaEsperada = 150;
        assertEquals(vidaEsperada, cuartel.obtenerVida());

    }
}
