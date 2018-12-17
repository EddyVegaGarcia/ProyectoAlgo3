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

public class Cuartel extends Edificio implements Diseñador, Construible{

    public Cuartel() {
        this.costo = COSTO_CUARTEL;
        this.tamanio = TAMANIO_CUARTEL;
        this.estado = new EnProceso();
        this.estadoVida = new Reparado();
        this.vida = VIDA_MAXIMA_CUARTEL;
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
    public Unidad colocarPieza(PiezaType piezaType, Jugador unJugador) {

        this.validarExistencia();

        if ((piezaType == UNIDAD_ESPADACHIN) || (piezaType == UNIDAD_ARQUERO)) {

            if(piezaType == UNIDAD_ESPADACHIN) {
                this.validarOroSufiente(unJugador.obtenerOro(), COSTO_ESPADACHIN);
                this.validarAcciones();
                unJugador.pagar(COSTO_ESPADACHIN);
            }
            if(piezaType == UNIDAD_ARQUERO) {
                this.validarOroSufiente(unJugador.obtenerOro(), COSTO_ARQUERO);
                this.validarAcciones();
                unJugador.pagar(COSTO_ARQUERO);
            }

            this.accionRealizada();
            return (Unidad) PiezaFactory.crearPieza(piezaType);
        }
        else
            throw new InvalidUnidadTypeException();


    }

    @Override
    public void darVidaPorReparacion() {
        if(vida + VIDA_REPARACION_A_CUARTEL > VIDA_MAXIMA_CUARTEL)
            vida = VIDA_MAXIMA_CUARTEL;
        else
            this.vida = vida + VIDA_REPARACION_A_CUARTEL;
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
    public void verificarProcesoEnReparacion() {

        if(estadoVida.estaEnReparacion()){
            throw new EdificioEnReparacionException();
        }

    }

    @Override
    public void finalizarConstruccion() {

        this.estado = this.estado.finalizarConstruccion();

    }

    @Override
    public void finalizarReparacion() {

        this.estadoVida = this.estadoVida.finalizarReparacion();

    }

    @Override
    public void iniciarConstruccion() {

        this.estado = this.estado.iniciarConstruccion();

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
