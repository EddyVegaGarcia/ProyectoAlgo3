package fiuba.algo3.tp2;

import fiuba.algo3.tp2.modelo.Campo.Mapa;
import fiuba.algo3.tp2.modelo.Exception.*;
import fiuba.algo3.tp2.modelo.Juego.Jugador;
import fiuba.algo3.tp2.modelo.Piezas.Edificios.PlazaCentral;
import fiuba.algo3.tp2.modelo.Piezas.*;
import fiuba.algo3.tp2.modelo.UnidadFactory.*;
import org.junit.Test;

import static fiuba.algo3.tp2.modelo.Constantes.*;
import static org.junit.Assert.assertEquals;

public class PlazaCentralTest {

    @Test
    public void testPlazaCentralCreaAldeano(){
        Jugador jugador = new Jugador("loo", new Mapa());

        Edificio plaza = new PlazaCentral();

        Unidad aldeano = ((PlazaCentral) plaza).colocarPieza(PiezaType.UNIDAD_ALDEANO, jugador);

        int vidaEsperada = 50;
        assertEquals(vidaEsperada, aldeano.obtenerVida());

    }

    @Test (expected = InvalidUnidadTypeException.class)
    public void testCrearUnidadIncorrectaDeEspadachinEnPlazaCentral() {

        Jugador jugador = new Jugador("loo", new Mapa());
        Edificio plazaCentral = new PlazaCentral();

        Unidad aldeano = ((PlazaCentral) plazaCentral).colocarPieza(PiezaType.UNIDAD_ESPADACHIN, jugador);
    }

    @Test
    public void testPlazaCentralRecibeDanioDeEspadachin() {

        Edificio plazaCentral = new PlazaCentral();

        for(int i = 0; i < 4; i++){
            //plazaCentral.construir();
        }
        plazaCentral.recibirDanio(ATAQUE_ESPADACHIN_A_EDIFICIO);

        int vidaEsperada = 435;
        assertEquals(vidaEsperada, plazaCentral.obtenerVida());

    }

    @Test
    public void testPlazaCentralRecibeDanioDeArquero() {

        Edificio plazaCentral = new PlazaCentral();

        for(int i = 0; i < 4; i++){
            //plazaCentral.construir();
        }
        plazaCentral.recibirDanio(ATAQUE_ARQUERO_A_EDIFICIO);

        int vidaEsperada = 440;
        assertEquals(vidaEsperada, plazaCentral.obtenerVida());

    }

    @Test
    public void testPlazaCentralRecibeDanioDeArmaDeAsedio() {

        Edificio plazaCentral = new PlazaCentral();

        for(int i = 0; i < 4; i++){
            //plazaCentral.construir();
        }
        plazaCentral.recibirDanio(ATAQUE_ARMADEASEDIO);

        int vidaEsperada = 375;
        assertEquals(vidaEsperada, plazaCentral.obtenerVida());

    }

    @Test
    public void testPlazaCentralRecibeDanioDeEspadachinArqueroYArmaDeAsedio() {

        Edificio plazaCentral = new PlazaCentral();

        for(int i = 0; i < 4; i++){
            //plazaCentral.construir();
        }
        plazaCentral.recibirDanio(ATAQUE_ESPADACHIN_A_EDIFICIO);
        plazaCentral.recibirDanio(ATAQUE_ARQUERO_A_EDIFICIO);
        plazaCentral.recibirDanio(ATAQUE_ARMADEASEDIO);

        int vidaEsperada = 350;
        assertEquals(vidaEsperada, plazaCentral.obtenerVida());

    }

}
