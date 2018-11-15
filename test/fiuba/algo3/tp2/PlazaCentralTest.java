package fiuba.algo3.tp2;

import org.junit.Assert;
import org.junit.Test;

public class PlazaCentralTest {
    @Test
    public void plazaCentralCreaAldeano(){
        PlazaCentral plaza = new PlazaCentral();
        Unidad aldeano = plaza.crearAldeano();
        Assert.assertEquals(50, aldeano.obtenerVida());
    }
}
