package fiuba.algo3.tp2;
import org.junit.Test;

import static org.junit.Assert.assertTrue;

public class AldeanoMovimientosTest {

    /* Cuando realizo movimientos, le paso por parámetro la dimensión del mapa
        que en estas pruebas es de 40x70 */

    @Test
    public void aldeanoMovimientosValidos() {
        Aldeano aldeano = new Aldeano("4,3");

        aldeano.moverArriba("40,70");
        assertTrue(aldeano.estaEnCasillero("3,3"));

        aldeano.moverIzquierda("40,70");
        assertTrue(aldeano.estaEnCasillero("3,2"));

        aldeano.moverAbajo("40,70");
        assertTrue(aldeano.estaEnCasillero("4,2"));

        aldeano.moverDerecha("40,70");
        assertTrue(aldeano.estaEnCasillero("4,3"));

        aldeano.moverSuperiorDerecha("40,70");
        assertTrue(aldeano.estaEnCasillero("3,4"));

        aldeano.moverSuperiorIzquierda("40,70");
        assertTrue(aldeano.estaEnCasillero("2,3"));

        aldeano.moverInferiorDerecha("40,70");
        assertTrue(aldeano.estaEnCasillero("3,4"));

        aldeano.moverInferiorIzquierda("40,70");
        assertTrue(aldeano.estaEnCasillero("4,3"));
    }

    @Test
    public void aldeanoMovimientosInvalidos(){
        Aldeano aldeano = new Aldeano("40,5");
        try {
            aldeano.moverAbajo("40,70");
        } catch (RuntimeException movimientoInvalido) {
            System.out.println("Movimiento inválido, intente otra vez.");
        }

        try {
            aldeano.moverSuperiorDerecha("70,5");
        } catch (RuntimeException movimientoInvalido) {
            System.out.println("Movimiento inválido, intente otra vez.");
        }

        try {
            aldeano.moverInferiorDerecha("40,70");
        } catch (RuntimeException movimientoInvalido) {
            System.out.println("Movimiento inválido, intente otra vez.");
        }

    }

}