package fiuba.algo3.tp2;


import fiuba.algo3.tp2.modelo.Campo.*;
import fiuba.algo3.tp2.modelo.Piezas.Pieza;
import org.junit.Test;

import fiuba.algo3.tp2.modelo.Piezas.Unidades.*;
import fiuba.algo3.tp2.modelo.Piezas.Edificios.*;

import java.util.ArrayList;

public class RangoDeAtaqueTest {

    @Test
    public void testRangoDeAtaqueDeCastilloRealizaAtaqueALasUnidadesEnSuRango() {


        Pieza unAldeano = new Aldeano();
        Pieza unEspadachin = new Espadachin();
        Pieza unaArmaDeAsedio = new ArmaDeAsedio();

        Pieza unCastillo = new Castillo();

        Posicion unaPosicion_1 = new Posicion(20,20);
        Posicion unaPosicion_2 = new Posicion(30,30);
        Posicion unaPosicion_3 = new Posicion(40, 40);
/*
        unAldeano.cambiarPosicion(unaPosicion_1);
        unEspadachin.cambiarPosicion(unaPosicion_2);
        unaArmaDeAsedio.cambiarPosicion(unaPosicion_3);
*/
        ArrayList<Pieza> unaLista = new ArrayList<>();

        unaLista.add(unAldeano);
        unaLista.add(unEspadachin);
        unaLista.add(unaArmaDeAsedio);



    }
}
