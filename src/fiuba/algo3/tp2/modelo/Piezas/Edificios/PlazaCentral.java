package fiuba.algo3.tp2.modelo.Piezas.Edificios;

import static fiuba.algo3.tp2.modelo.Campo.Constantes.*;

import fiuba.algo3.tp2.modelo.Estados.*;
import fiuba.algo3.tp2.modelo.Exception.*;
import fiuba.algo3.tp2.modelo.Interfaces.Construible;
import fiuba.algo3.tp2.modelo.Interfaces.Creador;
import fiuba.algo3.tp2.modelo.Juego.Jugador;
import fiuba.algo3.tp2.modelo.Piezas.*;
import fiuba.algo3.tp2.modelo.UnidadFactory.*;
import static fiuba.algo3.tp2.modelo.UnidadFactory.PiezaType.*;

public class PlazaCentral extends Edificio implements Creador, Construible {

    public PlazaCentral(){

        this.costo = COSTO_PLAZACENTRAL;
        this.estado = new EnConstruccion();
        this.tamanio = TAMANIO_PLAZA;
        this.vida = VIDA_MAXIMA_PLAZACENTRAL;

    }

    @Override
    public void validarOroSufiente(int cantidadOroActual) {

        if( cantidadOroActual < COSTO_ALDEANO )
            throw new OroInsuficienteException();

    }

    @Override
    public Unidad colocarPieza(PiezaType piezaType, Jugador unJugador){

        this.validarExistencia();
        this.validarOroSufiente(unJugador.obtenerOro());

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
        this.vida = vida + VIDA_REPARACION;
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
    public void verificarConstruccionEnProceso() {

        if(estado.estaProcesoDeConstruccion()){
            throw new EdificioEnConstruccionException();
        }

    }

    @Override
    public void finalizarConstruccion() {

        this.estado.finalizarConstruccion(this.estado);

    }

}
