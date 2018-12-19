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

        aldeano.recibirDanioDe(new Espadachin());

        int vidaEsperada = 25;
        assertEquals(vidaEsperada, aldeano.obtenerVida());

    }

    @Test
    public void testAldeanoRecibirDanioDeArquero() {

        Unidad aldeano = new Aldeano();

        aldeano.recibirDanioDe(new Arquero());

        int vidaEsperada = 35;
        assertEquals(vidaEsperada, aldeano.obtenerVida());

    }

    @Test
    public void testAldeanoRecibirDanioDeCastillo() {

        Unidad aldeano = new Aldeano();

        aldeano.recibirDanioDe(new Castillo());

        int vidaEsperada = 30;
        assertEquals(vidaEsperada, aldeano.obtenerVida());

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
        cuartel.recibirDanioDe(new Espadachin());
        aldeano.repararPieza(cuartel);

        assertEquals(0, aldeano.oroRecolectado());
    }

    @Test
    public void testOroRecolectadoEs20SiTerminoDeReparar(){
        Aldeano aldeano = new Aldeano();
        Cuartel cuartel =  new Cuartel();
        cuartel.recibirDanioDe(new Espadachin());
        aldeano.repararPieza(cuartel);
        aldeano.seguirReparando();


        assertEquals(20, aldeano.oroRecolectado());
    }

    @Test
    public void testTamanioDevuelve1(){
        Aldeano aldeano = new Aldeano();
        long obtenido = (long)aldeano.getTamanio();
        assertEquals((long)1, obtenido);
    }

}