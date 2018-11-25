package fiuba.algo3.tp2;

import fiuba.algo3.tp2.modelo.*;
import org.junit.Test;

import static fiuba.algo3.tp2.modelo.Constantes.*;
import static org.junit.Assert.assertEquals;

public class PlazaCentralTest {

    @Test
    public void testPlazaCentralCreaAldeano(){

        Edificio plaza = new PlazaCentral();

        Unidad aldeano = ((PlazaCentral) plaza).crearAldeano();

        int vidaEsperada = 50;
        assertEquals(vidaEsperada, aldeano.obtenerVida());

    }

    @Test
    public void testPlazaCentralRecibeDanioDeEspadachin() {

        Edificio plazaCentral = new PlazaCentral();

        for(int i = 0; i < 4; i++){
            plazaCentral.construir();
        }
        plazaCentral.recibirDanio(ATAQUE_ESPADACHIN_A_EDIFICIO);

        int vidaEsperada = 435;
        assertEquals(vidaEsperada, plazaCentral.obtenerVida());

    }

    @Test
    public void testPlazaCentralRecibeDanioDeArquero() {

        Edificio plazaCentral = new PlazaCentral();

        for(int i = 0; i < 4; i++){
            plazaCentral.construir();
        }
        plazaCentral.recibirDanio(ATAQUE_ARQUERO_A_EDIFICIO);

        int vidaEsperada = 440;
        assertEquals(vidaEsperada, plazaCentral.obtenerVida());

    }

    @Test
    public void testPlazaCentralRecibeDanioDeArmaDeAsedio() {

        Edificio plazaCentral = new PlazaCentral();

        for(int i = 0; i < 4; i++){
            plazaCentral.construir();
        }
        plazaCentral.recibirDanio(ATAQUE_ARMADEASEDIO);

        int vidaEsperada = 375;
        assertEquals(vidaEsperada, plazaCentral.obtenerVida());

    }

    @Test
    public void testPlazaCentralRecibeDanioDeEspadachinArqueroYArmaDeAsedio() {

        Edificio plazaCentral = new PlazaCentral();

        for(int i = 0; i < 4; i++){
            plazaCentral.construir();
        }
        plazaCentral.recibirDanio(ATAQUE_ESPADACHIN_A_EDIFICIO);
        plazaCentral.recibirDanio(ATAQUE_ARQUERO_A_EDIFICIO);
        plazaCentral.recibirDanio(ATAQUE_ARMADEASEDIO);

        int vidaEsperada = 350;
        assertEquals(vidaEsperada, plazaCentral.obtenerVida());

    }

}
