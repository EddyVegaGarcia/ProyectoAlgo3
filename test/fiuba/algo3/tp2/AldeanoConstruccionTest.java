package fiuba.algo3.tp2;
import org.junit.Test;

import static junit.framework.TestCase.assertEquals;
import static junit.framework.TestCase.assertTrue;

public class AldeanoConstruccionTest {

    @Test
    public void AldeanoConstruyePlazaCentral() {

        Aldeano aldeano = new Aldeano("3,3");
        PlazaCentral plaza = new PlazaCentral();
        /*Tarda 3 turnos en crearse */
        aldeano.construir(plaza);
        aldeano.construir(plaza);
        aldeano.construir(plaza);

        assertTrue(plaza.estaConstruido());

        try{
            aldeano.construir(plaza);
        }
        catch (RuntimeException YaEstaConstruidoError){
            System.out.println("Ya esta construido");
        }

        /* No suma Oro*/

        assertEquals(0,aldeano.obtenerOroTotal());
    }

    @Test
    public void AldeanoConstruyeCuartel(){

        Aldeano aldeano = new Aldeano("4,3");
        Cuartel cuartel = new Cuartel();

        aldeano.construir(cuartel);
        aldeano.construir(cuartel);
        aldeano.construir(cuartel);

        assertTrue(cuartel.estaConstruido());

        try{
            aldeano.construir(cuartel);
        }
        catch (RuntimeException YaEstaConstruidoError) {
            System.out.println("Ya está construido");
        }

        assertEquals(0,aldeano.obtenerOroTotal());
    }

}