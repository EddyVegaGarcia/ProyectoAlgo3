package fiuba.algo3.tp2;

import fiuba.algo3.tp2.modelo.Campo.Posicion;
import fiuba.algo3.tp2.modelo.Direcciones.*;
import org.junit.Test;

import static junit.framework.TestCase.assertEquals;

public class DireccionTest {

    @Test
    public void testDireccionAbajoSuma1AlaFilaDeLaPosicion(){
        Posicion posicion = new Posicion(1,1);
        DireccionAbajo direccion = new DireccionAbajo();

        posicion = direccion.obtenerNuevaPosicion(posicion);
        assertEquals(2, posicion.getFila());
        assertEquals(1, posicion.getColumna());
    }

    @Test
    public void testDireccionAbajoIzquierdaSuma1AlaFilaYResta1ALaColumnaDeLaPosicion(){
        Posicion posicion = new Posicion(1,1);
        DireccionAbajoIzquierda direccion = new DireccionAbajoIzquierda();

        posicion = direccion.obtenerNuevaPosicion(posicion);
        assertEquals(2, posicion.getFila());
        assertEquals(0, posicion.getColumna());
    }

    @Test
    public void testDireccionAbajoDerechaSuma1AlaFilaYSuma1ALaColumnaDeLaPosicion(){
        Posicion posicion = new Posicion(1,1);
        DireccionAbajoDerecha direccion = new DireccionAbajoDerecha();

        posicion = direccion.obtenerNuevaPosicion(posicion);
        assertEquals(2, posicion.getFila());
        assertEquals(2, posicion.getColumna());
    }

    @Test
    public void testDireccionArribaResta1AlaFilaDeLaPosicion(){
        Posicion posicion = new Posicion(1,1);
        DireccionArriba direccion = new DireccionArriba();

        posicion = direccion.obtenerNuevaPosicion(posicion);
        assertEquals(0, posicion.getFila());
        assertEquals(1, posicion.getColumna());
    }

    @Test
    public void testDireccionArribaIzquierdaResta1AlaFilaYResta1ALaColumnaDeLaPosicion(){
        Posicion posicion = new Posicion(1,1);
        DireccionArribaIzquierda direccion = new DireccionArribaIzquierda();

        posicion = direccion.obtenerNuevaPosicion(posicion);
        assertEquals(0, posicion.getFila());
        assertEquals(0, posicion.getColumna());
    }

    @Test
    public void testDireccionArribaDerechaResta1AlaFilaYSuma1ALaColumnaDeLaPosicion(){
        Posicion posicion = new Posicion(1,1);
        DireccionArribaDerecha direccion = new DireccionArribaDerecha();

        posicion = direccion.obtenerNuevaPosicion(posicion);
        assertEquals(0, posicion.getFila());
        assertEquals(2, posicion.getColumna());
    }

    @Test
    public void testDireccionDerechaSuma1ALaColumnaDeLaPosicion(){
        Posicion posicion = new Posicion(1,1);
        DireccionDerecha direccion = new DireccionDerecha();

        posicion = direccion.obtenerNuevaPosicion(posicion);
        assertEquals(1, posicion.getFila());
        assertEquals(2, posicion.getColumna());
    }

    @Test
    public void testDireccionIzquierdaResta1ALaColumnaDeLaPosicion(){
        Posicion posicion = new Posicion(1,1);
        DireccionIzquierda direccion = new DireccionIzquierda();

        posicion = direccion.obtenerNuevaPosicion(posicion);
        assertEquals(1, posicion.getFila());
        assertEquals(0, posicion.getColumna());
    }
}
