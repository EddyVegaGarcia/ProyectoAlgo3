package fiuba.algo3.tp2;

import fiuba.algo3.tp2.modelo.*;
import org.junit.Test;

import static junit.framework.TestCase.assertEquals;
import static junit.framework.TestCase.assertTrue;

public class AldeanoConstruccionTest {

    static final int DANIO = 30;
    static final int VIDAPLAZA = 450;
    static final int VIDACUARTEL = 250;
    static final int VIDACASTILLO = 1000;

    @Test
    public void AldeanoConstruyePlazaCentral() {

        Aldeano aldeano = new Aldeano();
        PlazaCentral plaza = new PlazaCentral();

        /* La plaza no tiene vida y no existe por lo que no puede crear unidades*/
        assertEquals(0, plaza.obtenerVida());

        aldeano.construir(plaza);
        aldeano.ganarMonedas();

        aldeano.construir(plaza);
        aldeano.ganarMonedas();

        aldeano.construir(plaza);
        aldeano.ganarMonedas();

        assertEquals(VIDAPLAZA, plaza.obtenerVida());

        /* Aldeano No suma Oro*/
        assertEquals(0,aldeano.obtenerOroTotal());
    }

    @Test
    public void AldeanoConstruyeCuartel(){

        Aldeano aldeano = new Aldeano();
        Cuartel cuartel = new Cuartel();

        /* El cuartelno tiene vida y no existe por lo que no puede crear unidades*/
        assertEquals(0, cuartel.obtenerVida());


        aldeano.construir(cuartel);
        aldeano.ganarMonedas();

        aldeano.construir(cuartel);
        aldeano.ganarMonedas();

        aldeano.construir(cuartel);
        aldeano.ganarMonedas();

        assertEquals(VIDACUARTEL, cuartel.obtenerVida());

        assertEquals(0,aldeano.obtenerOroTotal());
    }

    @Test
    public void AldeanoReparaCastillo(){

        Aldeano aldeano = new Aldeano();
        Castillo castillo = new Castillo();

        castillo.recibirDanio(DANIO);
        aldeano.ganarMonedas();

        /*Aldeano suma oro*/
        assertEquals(20, aldeano.obtenerOroTotal());

        aldeano.reparar(castillo);
        aldeano.ganarMonedas();

        /*Aldeano no suma oro*/
        assertEquals(20, aldeano.obtenerOroTotal());
        assertEquals(VIDACASTILLO-15, castillo.obtenerVida());
    }
}