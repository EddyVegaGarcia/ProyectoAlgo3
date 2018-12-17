package fiuba.algo3.tp2.modelo.Piezas.Edificios;

import static fiuba.algo3.tp2.modelo.Constantes.*;

import fiuba.algo3.tp2.modelo.Estados.*;
import fiuba.algo3.tp2.modelo.Exception.*;
import fiuba.algo3.tp2.modelo.Interfaces.Construible;
import fiuba.algo3.tp2.modelo.Interfaces.Diseñador;
import fiuba.algo3.tp2.modelo.Juego.Jugador;
import fiuba.algo3.tp2.modelo.Piezas.*;
import fiuba.algo3.tp2.modelo.UnidadFactory.*;
import static fiuba.algo3.tp2.modelo.UnidadFactory.PiezaType.*;

public class PlazaCentral extends Edificio implements Diseñador, Construible {

    public PlazaCentral(){

        this.costo = COSTO_PLAZACENTRAL;
        this.estado = new EnProceso();
        this.estadoVida =  new Reparado();
        this.tamanio = TAMANIO_PLAZA;
        this.vida = VIDA_MAXIMA_PLAZACENTRAL;

    }

    @Override
    public void recibirDanio(int unDanio) {
        estadoVida = new Daniado();
        super.recibirDanio(unDanio);
    }

    @Override
    public void validarOroSufiente(int cantidadOroActual, int costo) {

        if( cantidadOroActual < costo )
            throw new OroInsuficienteException();

    }

    @Override
    public Unidad colocarPieza(PiezaType piezaType, Jugador unJugador){

        this.validarExistencia();
        this.validarOroSufiente(unJugador.obtenerOro(), COSTO_ALDEANO);

        if(piezaType == UNIDAD_ALDEANO ){
            this.validarAcciones();
            this.accionRealizada();

            unJugador.pagar(COSTO_ALDEANO);

            return (Unidad) PiezaFactory.crearPieza(piezaType);
        }
        else
            throw new InvalidUnidadTypeException();

    }

    @Override
    public void darVidaPorReparacion() {
        if(vida + VIDA_REPARACION_A_CUARTEL > VIDA_MAXIMA_PLAZACENTRAL)
            vida = VIDA_MAXIMA_PLAZACENTRAL;
        else
            this.vida = vida + VIDA_REPARACION_A_PLAZACENTRAL;
    }

    @Override
    public PiezaType obtenerType() {
        return EDIFICIO_PLAZACENTRAL;
    }

    @Override
    public double getTamanio() {
        return tamanio;
    }

    @Override
    public String obtenerNombre() {
        return "Plaza Central";
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
    public void verificarProcesoEnReparacion() {

        if(estadoVida.estaEnReparacion()){
            throw new EdificioEnReparacionException();
        }

    }

    @Override
    public void finalizarReparacion() {

        this.estadoVida = this.estadoVida.finalizarReparacion();

    }

    @Override
    public void iniciarReparacion() {

        this.estadoVida =  this.estadoVida.reparar();

    }

    @Override
    public void validarExistencia() {

        if(!estado.estaConstruido())
            throw new EdificioInexistenteException();

    }


}
