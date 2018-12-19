package fiuba.algo3.tp2.modelo.Piezas.Edificios;

import static fiuba.algo3.tp2.modelo.Constantes.*;

import fiuba.algo3.tp2.modelo.Estados.*;
import fiuba.algo3.tp2.modelo.Exception.*;
import fiuba.algo3.tp2.modelo.Interfaces.*;
import fiuba.algo3.tp2.modelo.Juego.Jugador;
import fiuba.algo3.tp2.modelo.Piezas.*;
import fiuba.algo3.tp2.modelo.UnidadFactory.*;
import static fiuba.algo3.tp2.modelo.UnidadFactory.PiezaType.*;

public class PlazaCentral extends Edificio implements Diseñador, Construible, Creable {

    public PlazaCentral(){

        this.costo = COSTO_PLAZACENTRAL;
        this.estado = new EnProceso();
        this.estadoVida =  new Reparado();
        this.tamanio = TAMANIO_PLAZA;
        this.vida = VIDA_MAXIMA_PLAZACENTRAL;

    }

    @Override
    public void recibirDanioDe(Atacante atacante) {

        estadoVida = new Daniado();

        atacante.atacarEdificio(this);

    }

    @Override
    public Unidad colocarPieza(PiezaType piezaType, Jugador unJugador){
        if(piezaType != UNIDAD_ALDEANO )
            throw new InvalidUnidadTypeException();

        Creable unidad = (Creable)PiezaFactory.crearPieza(piezaType);;
        this.validarExistencia();
        unidad.validarOroSuficiente(unJugador.obtenerOro());

        this.validarAcciones();
        this.accionRealizada();

        return (Unidad) unidad;
    }

    @Override
    public void reparacionPor(Constructor unConstructor) {

        unConstructor.repararPlazaCentral(this);

    }

    @Override
    public void darVidaPorReparacion(int unaCantidadReparacion) {

        if(vida + unaCantidadReparacion >= VIDA_MAXIMA_PLAZACENTRAL) {
            vida = VIDA_MAXIMA_PLAZACENTRAL;
            this.finalizarReparacion();
        }
        else
            super.darVidaPorReparacion(unaCantidadReparacion);

    }

    @Override
    public PiezaType obtenerType() {
        return EDIFICIO_PLAZACENTRAL;
    }

    @Override
    public void validarOroSuficiente(int oro) {
        if( oro < COSTO_PLAZACENTRAL )
            throw new OroInsuficienteException();
    }

    @Override
    public int costo() {
        return costo;
    }

    @Override
    public double getTamanio() {
        return tamanio;
    }

    @Override
    public void verificarProcesoEnConstruccion() {

        if(estado.estaConstruido()){
            throw new EdificioYaConstruidoException();
        }

    }

    @Override
    public void finalizarConstruccion() {

        estado = estado.finalizarConstruccion();

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
    public void verificarPosibleConstruccion() {
        this.verificarProcesoEnConstruccion();
    }

    @Override
    public void verificarPosibleReparacion() {
        this.verificarProcesoEnReparacion();
    }
}
