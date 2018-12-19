package fiuba.algo3.tp2.modelo.Piezas.Edificios;

import static fiuba.algo3.tp2.modelo.Constantes.*;

import fiuba.algo3.tp2.modelo.Estados.*;
import fiuba.algo3.tp2.modelo.Exception.*;
import fiuba.algo3.tp2.modelo.Interfaces.*;
import fiuba.algo3.tp2.modelo.Juego.Jugador;
import fiuba.algo3.tp2.modelo.Piezas.*;
import fiuba.algo3.tp2.modelo.UnidadFactory.*;
import static fiuba.algo3.tp2.modelo.UnidadFactory.PiezaType.*;

public class Cuartel extends Edificio implements Diseñador, Construible, Creable {

    public Cuartel() {
        this.costo = COSTO_CUARTEL;
        this.tamanio = TAMANIO_CUARTEL;
        this.estado = new EnProceso();
        this.estadoVida = new Reparado();
        this.vida = VIDA_MAXIMA_CUARTEL;
    }

    @Override
    public Unidad colocarPieza(PiezaType piezaType, Jugador unJugador) {

        if ((piezaType != UNIDAD_ESPADACHIN) && (piezaType != UNIDAD_ARQUERO))
            throw new InvalidUnidadTypeException();

        this.validarExistencia();
        Creable unidad = (Creable)PiezaFactory.crearPieza(piezaType);
        unidad.validarOroSuficiente(unJugador.obtenerOro());
        this.validarAcciones();

        this.accionRealizada();
        return (Unidad) unidad;
    }

    @Override
    public void reparacionPor(Constructor unConstructor) {

        unConstructor.repararCuartel(this);

    }

    @Override
    public void darVidaPorReparacion(int unaCantidadReparacion) {

        if(vida + unaCantidadReparacion >= VIDA_MAXIMA_CUARTEL) {
            vida = VIDA_MAXIMA_CUARTEL;
            this.finalizarReparacion();
        }
        else
            super.darVidaPorReparacion(unaCantidadReparacion);

    }

    @Override
    public PiezaType obtenerType() {
        return EDIFICIO_CUARTEL;
    }

    @Override
    public double getTamanio() {
        return tamanio;
    }


    @Override
    public void verificarProcesoEnConstruccion() {

        if(estado.estaEnConstruccion()){
            throw new EdificioEnConstruccionException();
        }

    }

    @Override
    public void finalizarConstruccion() {

        this.estado = this.estado.finalizarConstruccion();

    }

    @Override
    public void iniciarConstruccion() {

        this.estado = this.estado.iniciarConstruccion();

    }

    @Override
    public void validarExistencia() {

        if(!estado.estaConstruido())
            throw new EdificioInexistenteException();

    }

    @Override
    public void validarOroSuficiente(int oro) {
        if( oro < COSTO_CUARTEL )
            throw new OroInsuficienteException();
    }

    @Override
    public int costo() {
        return costo;
    }

    @Override
    public void verificarPosibleConstruccion() {
        this.verificarProcesoEnConstruccion();
    }

    @Override
    public void verificarPosibleReparacion() {
        this.verificarProcesoEnReparacion();
    }

    @Override
    public void recibirDanioDe(Atacante atacante) {

        estadoVida = new Daniado();

        atacante.atacarEdificio(this);

    }

}
