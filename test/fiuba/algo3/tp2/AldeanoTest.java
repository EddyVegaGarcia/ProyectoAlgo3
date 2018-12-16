package fiuba.algo3.tp2;

import fiuba.algo3.tp2.modelo.Interfaces.*;
import fiuba.algo3.tp2.modelo.Piezas.*;
import fiuba.algo3.tp2.modelo.Piezas.Unidades.*;
import fiuba.algo3.tp2.modelo.Piezas.Edificios.*;
import org.junit.Test;

import fiuba.algo3.tp2.modelo.Exception.*;

import static fiuba.algo3.tp2.modelo.Constantes.*;
import static junit.framework.TestCase.assertTrue;
import static org.junit.Assert.assertEquals;

public class AldeanoTest {

    @Test
    public void testAldeanoConstruyeCuartelYCambiaDeEstadoAEstaTrabajando() {

        Constructor unAldeano = new Aldeano();
        Edificio unCuartel = new Cuartel();

        unAldeano.construir(unCuartel);

        assertTrue(unAldeano.estaTrabajando());

    }

    @Test(expected = ConstruccionCastilloException.class)
    public void testAldeanoNoPuedeConstruirCastilloYaQueNoEsUnEdificioConstruible() {

        Constructor unAldeano = new Aldeano();
        Edificio unCastillo = new Castillo();

        unAldeano.construir(unCastillo);

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

    @Test
    public void testOroRecolectadoEs20SiEstaEnReposo(){
         Aldeano aldeano = new Aldeano();

         assertEquals(20, aldeano.oroRecolectado());
    }

    @Test
    public void testOroRecolectadoEs0SiEstaTrabajando(){
        Aldeano aldeano = new Aldeano();
        aldeano.construir(new Cuartel());

        assertEquals(0, aldeano.oroRecolectado());
    }

    @Test
    public void testOroRecolectadoEs20DespuesDeConstruirTodoElCuartel(){
        Aldeano aldeano =  new Aldeano();
        aldeano.construir(new Cuartel());
        aldeano.seguirTrabajando();
        aldeano.seguirTrabajando();
        aldeano.seguirTrabajando();

        assertEquals(20, aldeano.oroRecolectado());
    }

    @Test
    public void testOroRecolectadoEs0SiEstaReparando(){
        Aldeano aldeano = new Aldeano();
        Cuartel cuartel =  new Cuartel();
        cuartel.recibirDanio(50);
        aldeano.repararPieza(cuartel);

        assertEquals(0, aldeano.oroRecolectado());
    }

    @Test
    public void testOroRecolectadoEs20SiTerminoDeReparar(){
        Aldeano aldeano = new Aldeano();
        Cuartel cuartel =  new Cuartel();
        cuartel.recibirDanio(50);
        aldeano.repararPieza(cuartel);

        assertEquals(20, aldeano.oroRecolectado());
    }

    @Test
    public void testAldeanoObtenerNombreDevuelveStringAldeano(){
        Aldeano aldeano = new Aldeano();

        assertEquals("Aldeano", aldeano.obtenerNombre());
    }

    @Test
    public void testTamanioDevuelve1(){
        Aldeano aldeano = new Aldeano();
        long obtenido = (long)aldeano.getTamanio();
        assertEquals((long)1, obtenido);
    }
    
}