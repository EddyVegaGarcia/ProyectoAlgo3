package fiuba.algo3.tp2.modelo.Piezas;

import fiuba.algo3.tp2.modelo.Exception.EdificioInexistenteException;
import fiuba.algo3.tp2.modelo.Interfaces.EstadoDeEdificio;
import fiuba.algo3.tp2.modelo.Interfaces.EstadoVidaEdificio;
import fiuba.algo3.tp2.modelo.Interfaces.Reparable;

public abstract class Edificio extends Pieza implements Reparable {

    public EstadoDeEdificio estado;
    public EstadoVidaEdificio estadoVida;

    public EstadoDeEdificio obtenerEstado(){return estado;}

    public abstract void darVidaPorReparacion();

    protected void validarExistencia() {

        if(!estado.estaConstruido())
            throw new EdificioInexistenteException();

    }

    

}