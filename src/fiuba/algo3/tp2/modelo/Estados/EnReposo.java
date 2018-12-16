package fiuba.algo3.tp2.modelo.Estados;

import fiuba.algo3.tp2.modelo.Exception.EdificioConstruidoException;
import fiuba.algo3.tp2.modelo.Exception.EdificioEnConstruccionException;
import fiuba.algo3.tp2.modelo.Exception.EdificioEnReparacionException;
import fiuba.algo3.tp2.modelo.Exception.EdificioYaReparadoException;
import fiuba.algo3.tp2.modelo.Interfaces.Construible;
import fiuba.algo3.tp2.modelo.Interfaces.EstadoDeAldeano;
import fiuba.algo3.tp2.modelo.Piezas.*;
import fiuba.algo3.tp2.modelo.UnidadFactory.PiezaType;

public class EnReposo implements EstadoDeAldeano {

    @Override
    public boolean estaTrabajando() {
        return false;
    }

    @Override
    public EstadoDeAldeano construir(Edificio edificio, int turnosConstruccion) {

        if(!edificio.obtenerEstado().estaConstruido() && !edificio.obtenerEstado().estaEnConstruccion()) {
            ((Construible)edificio).iniciarConstruccion();
            return new EstaTrabajando();

        }
        else if(edificio.obtenerEstado().estaConstruido())
            throw new EdificioConstruidoException();
        else if(edificio.obtenerEstado().estaEnConstruccion())
            throw new EdificioEnConstruccionException();

        return new EnReposo();
    }

    @Override
    public EstadoDeAldeano reparar(Edificio unEdificio, PiezaType unaPiezaType) {

        if(!unEdificio.obtenerEstadoVida().estaReparado() && !unEdificio.obtenerEstadoVida().estaEnReparacion()){

            System.out.print("entro al if");
            unEdificio.iniciarReparacion();
            return new EstaTrabajando();

        }
        else if(unEdificio.obtenerEstadoVida().estaReparado())
            throw new EdificioYaReparadoException();
        else if (unEdificio.obtenerEstadoVida().estaEnReparacion())
            throw new EdificioEnReparacionException();

        return this;
    }

    @Override
    public int oroRecolectado() {
        return 20;
    }

}

