package fiuba.algo3.tp2.modelo.Piezas;

import fiuba.algo3.tp2.modelo.Exception.EdificioEnReparacionException;
import fiuba.algo3.tp2.modelo.Interfaces.Constructor;
import fiuba.algo3.tp2.modelo.Interfaces.*;

public abstract class Edificio extends Pieza implements Reparable {

    protected EstadoDeEdificio estado;
    protected EstadoVidaEdificio estadoVida;
    protected int vidaMaxima;

    /* METODOS ABSTRACTOS*/

    public  abstract void reparacionPor(Constructor unConstructor);

    public void darVidaPorReparacion(int unaCantidadReparacion){ this.vida = vida + unaCantidadReparacion;}

    /* METODOS */

    public EstadoDeEdificio obtenerEstado(){return estado;}

    public void iniciarReparacion() {
        this.estadoVida =  this.estadoVida.reparar();
    }

    public void finalizarReparacion() {
        this.estadoVida = this.estadoVida.finalizarReparacion();
    }

    public EstadoVidaEdificio obtenerEstadoVida(){ return estadoVida;}

    public void verificarProcesoEnReparacion() {
        if(estadoVida.estaEnReparacion())
            throw new EdificioEnReparacionException();
    }

    public boolean estasReparado(){

        return estadoVida.estaReparado();

    }
}