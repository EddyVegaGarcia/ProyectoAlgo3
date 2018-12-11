package fiuba.algo3.tp2;

import fiuba.algo3.tp2.modelo.Piezas.*;
import fiuba.algo3.tp2.modelo.Piezas.Edificios.*;
import fiuba.algo3.tp2.modelo.Exception.*;
import fiuba.algo3.tp2.modelo.UnidadFactory.*;
import org.junit.Test;

import static fiuba.algo3.tp2.modelo.Campo.Constantes.*;
import static org.junit.Assert.assertEquals;

public class CuartelTest {

    @Test
    public void testCuartelCreaEspadachin() {

        Edificio cuartel = new Cuartel();

        Unidad espadachin = cuartel.crearUnidad(PiezaType.UNIDAD_ESPADACHIN);

        int vidaEsperada = 100;
        assertEquals(vidaEsperada, espadachin.obtenerVida());
    }

    @Test
    public void testCuartelCreaArquero() {

        Edificio cuartel = new Cuartel();

        Unidad arquero = cuartel.crearUnidad(PiezaType.UNIDAD_ARQUERO);

        int vidaEsperada = 75;
        assertEquals(vidaEsperada, arquero.obtenerVida());
    }

    @Test (expected = InvalidUnidadTypeException.class)
    public void testCrearUnidadIncorrectaDeArmaDeAsedioEnCuartel() {

        Edificio cuartel = new Cuartel();

        Unidad arquero = cuartel.crearUnidad(PiezaType.UNIDAD_ARMADEASEDIO);

    }

    @Test
    public void testCuartelRecibeDanioDeEspadachin() {

        Edificio cuartel = new Cuartel();

        for(int i = 0; i < 4; i++){
            //cuartel.construir();
        }
        cuartel.recibirDanio(ATAQUE_ESPADACHIN_A_EDIFICIO);

        int vidaEsperada = 235;
        assertEquals(vidaEsperada, cuartel.obtenerVida());

    }

    @Test
    public void testCuartelRecibeDanioDeArquero() {

        Edificio cuartel = new Cuartel();

        for(int i = 0; i < 4; i++){
           // cuartel.construir();
        }
        cuartel.recibirDanio(ATAQUE_ARQUERO_A_EDIFICIO);

        int vidaEsperada = 240;
        assertEquals(vidaEsperada, cuartel.obtenerVida());

    }

    @Test
    public void testCuartelRecibeDanioDeArmaDeAsedio() {

        Edificio cuartel = new Cuartel();

        for(int i = 0; i < 4; i++){
            //cuartel.construir();
        }
        cuartel.recibirDanio(ATAQUE_ARMADEASEDIO);

        int vidaEsperada = 175;
        assertEquals(vidaEsperada, cuartel.obtenerVida());

    }

    @Test
    public void testCuartelRecibeDanioDeEspadachinArqueroYArmaDeAsedio() {

        Edificio cuartel = new Cuartel();

        for(int i = 0; i < 4; i++){
            //cuartel.construir();
        }
        cuartel.recibirDanio(ATAQUE_ESPADACHIN_A_EDIFICIO);
        cuartel.recibirDanio(ATAQUE_ARQUERO_A_EDIFICIO);
        cuartel.recibirDanio(ATAQUE_ARMADEASEDIO);

        int vidaEsperada = 150;
        assertEquals(vidaEsperada, cuartel.obtenerVida());

    }
}
