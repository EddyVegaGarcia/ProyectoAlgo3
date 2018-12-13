package fiuba.algo3.tp2.modelo.Piezas;

import fiuba.algo3.tp2.modelo.Exception.EdificioInexistenteException;
import fiuba.algo3.tp2.modelo.Interfaces.EstadoDeEdificio;

public abstract class Edificio extends Pieza {

    public EstadoDeEdificio estado;

    public EstadoDeEdificio obtenerEstado(){return estado;}

    public abstract void darVidaPorReparacion();

    protected void validarExistencia() {

        if(!estado.estaProcesoDeConstruccion())
            throw new EdificioInexistenteException();

    }
}