package fiuba.algo3.tp2.modelo.Piezas;

import fiuba.algo3.tp2.modelo.Campo.Posicion;
import fiuba.algo3.tp2.modelo.Exception.EdificioEnReparacionException;
import fiuba.algo3.tp2.modelo.Exception.EdificioInexistenteException;
import fiuba.algo3.tp2.modelo.Exception.PiezaDestruidaException;
import fiuba.algo3.tp2.modelo.Interfaces.EstadoDeEdificio;
import fiuba.algo3.tp2.modelo.Interfaces.EstadoVidaEdificio;
import fiuba.algo3.tp2.modelo.Interfaces.Reparable;

import java.util.ArrayList;

public abstract class Edificio extends Pieza implements Reparable {

    protected EstadoDeEdificio estado;
    protected EstadoVidaEdificio estadoVida;
    protected int vidaMaxima;

    /* METODOS ABSTRACTOS*/

    public abstract void darVidaPorReparacion();

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
        if( vida == vidaMaxima ) {
            finalizarReparacion();
            return true;
        }
        return false;
    }

    @Override
    public void recibirDanio(int unDanioEdifcio, int unDanioUnidad){

        if (vida - unDanioEdifcio <= 0) {
            vida = 0;
            throw new PiezaDestruidaException();
        }
        this.vida = vida - unDanioEdifcio;

    }
}