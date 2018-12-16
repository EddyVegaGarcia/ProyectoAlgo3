package fiuba.algo3.tp2.modelo.Interfaces;

import fiuba.algo3.tp2.modelo.Juego.Jugador;
import fiuba.algo3.tp2.modelo.Piezas.Pieza;
import fiuba.algo3.tp2.modelo.UnidadFactory.PiezaType;

public interface Diseñador {

    void validarOroSufiente(int cantidadOroActual, int costo);

    Pieza colocarPieza(PiezaType unidadType, Jugador unJugador);

}
