package fiuba.algo3.tp2;


import org.junit.Assert;
import org.junit.Test;

public class CastilloTest {
    @Test
    public void castilloCreaArmaDeAsedio(){
        Castillo castillo = new Castillo();
        Unidad arma = castillo.crearArmaAsedio();
        Assert.assertEquals(150, arma.obtenerVida());
    }
}
