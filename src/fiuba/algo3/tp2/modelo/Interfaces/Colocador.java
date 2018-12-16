package fiuba.algo3.tp2.modelo.Interfaces;

import fiuba.algo3.tp2.modelo.Piezas.Edificio;

public interface Colocador extends EstadoDeAldeano {

    boolean estaTrabajando();

    EstadoDeAldeano construir(Edificio edificio, int turnosConstruccion);

}
