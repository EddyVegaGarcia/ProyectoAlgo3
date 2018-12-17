package fiuba.algo3.tp2.modelo.Piezas;

import fiuba.algo3.tp2.modelo.Campo.Posicion;
import fiuba.algo3.tp2.modelo.Exception.EdificioInexistenteException;
import fiuba.algo3.tp2.modelo.Interfaces.EstadoDeEdificio;
import fiuba.algo3.tp2.modelo.Interfaces.EstadoVidaEdificio;
import fiuba.algo3.tp2.modelo.Interfaces.Reparable;

import java.util.ArrayList;

public abstract class Edificio extends Pieza implements Reparable {

    protected EstadoDeEdificio estado;
    protected EstadoVidaEdificio estadoVida;

    public EstadoDeEdificio obtenerEstado(){return estado;}

    public EstadoVidaEdificio obtenerEstadoVida(){ return estadoVida;}

    public abstract void darVidaPorReparacion();

    public ArrayList<Posicion> obtenerPosiciones() {
        return posiciones;
    }
}