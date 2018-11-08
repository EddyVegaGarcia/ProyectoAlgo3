package fiuba.algo3.tp2.modelo;

import static fiuba.algo3.tp2.modelo.Constantes.*;

public abstract class EstadoDeAldeano {

    public abstract void ganarOro(Aldeano aldeano);

    public EstadoDeAldeano trabajando(){
        return new EstaTrabajando();
    }

    public abstract boolean estaTrabajando();

    public abstract EstadoDeAldeano construir(Edificio edificio, int turnosConstruccion);

}


