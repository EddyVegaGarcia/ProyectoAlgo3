package fiuba.algo3.tp2;

import org.junit.Assert;
import org.junit.Test;

public class CuartelTest {

    @Test
    public void cuartelCreaEspadachin() {
        Cuartel cuartel = new Cuartel();
        Unidad espadachin = cuartel.crearEspadachin();
        Assert.assertEquals(100, espadachin.obtenerVida());
    }

    @Test
    public void cuartelCreaArquero() {
        Cuartel cuartel = new Cuartel();
        Unidad arquero = cuartel.crearArquero();
        Assert.assertEquals(75, arquero.obtenerVida());
    }
}
