package fiuba.algo3.tp2;

import fiuba.algo3.tp2.modelo.*;
import org.junit.Assert;
import org.junit.Test;
import static fiuba.algo3.tp2.modelo.Constantes.*;

public class AldeanoTest {

    @Test
    public void AldeanoConstruyeCuartel() {
        Mapa mapa = new Mapa(FILA_DEFAULT_MAPA, COLUMNA_DEFAULT_MAPA);
        Aldeano aldeano = new Aldeano();
        Cuartel unCuartel = new Cuartel();

        Posicion posicionAldeano = new Posicion(29, 13);
        Posicion posicionCuartel = new Posicion(28, 13);

        mapa.colocarUnidad(aldeano, posicionAldeano);
        mapa.colocarEdificio(unCuartel, posicionCuartel);

        aldeano.construir(unCuartel);

        Assert.assertEquals(new EstaTrabajando().getEstado(),aldeano.obtenerEstado().getEstado());
    }
}