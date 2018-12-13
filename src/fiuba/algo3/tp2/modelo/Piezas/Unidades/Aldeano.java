package fiuba.algo3.tp2.modelo.Piezas.Unidades;

import fiuba.algo3.tp2.modelo.Estados.*;
import fiuba.algo3.tp2.modelo.Exception.*;
import fiuba.algo3.tp2.modelo.Interfaces.*;
import fiuba.algo3.tp2.modelo.Juego.Jugador;
import fiuba.algo3.tp2.modelo.Piezas.*;
import fiuba.algo3.tp2.modelo.UnidadFactory.PiezaFactory;
import fiuba.algo3.tp2.modelo.UnidadFactory.PiezaType;


import static fiuba.algo3.tp2.modelo.Campo.Constantes.*;
import static fiuba.algo3.tp2.modelo.UnidadFactory.PiezaType.*;

public class Aldeano extends Unidad implements Constructor {

    //public int stringOro;
    public EstadoDeAldeano estado;
    int turnosConstruccion;
    Edificio edificioEnConstruccion;


    public Aldeano() {

        this.vida = VIDA_MAXIMA_ALDEANO;
        this.costo = COSTO_ALDEANO;
        //this.stringOro = 0;
        this.estado = new EnReposo();
        this.tamanio = TAMANIO_UNIDAD;
        this.turnosConstruccion = 0;

    }

    @Override
    public void validarOroSufiente(int cantidadOroActual) {

        if( cantidadOroActual < COSTO_CUARTEL || cantidadOroActual < COSTO_PLAZACENTRAL )
            throw new OroInsuficienteException();

    }

    @Override
    public Edificio colocarPieza(PiezaType piezaType, Jugador unJugador) {

        this.validarOroSufiente(unJugador.oro);

        if (piezaType == PiezaType.EDIFICIO_CUARTEL ||piezaType == PiezaType.EDIFICIO_PLAZACENTRAL ) {

            this.validarAcciones();
            this.accionRealizada();

            if(piezaType == EDIFICIO_CUARTEL)
                unJugador.pagar(COSTO_CUARTEL);
            if(piezaType == EDIFICIO_PLAZACENTRAL)
                unJugador.pagar(COSTO_PLAZACENTRAL);

            return (Edificio) PiezaFactory.crearPieza(piezaType);

        }
        else
            throw new InvalidUnidadTypeException();

    }

    @Override
    public void construir(Pieza unaPieza)  {

        this.validarPiezaEdificio(unaPieza);
        this.ValidarConstruirCastillo(unaPieza);
        this.validarAcciones();

        ((Construible)unaPieza).verificarProcesoEnConstruccion();

        edificioEnConstruccion = (Edificio)unaPieza;

        this.seguirTrabajando();

        turnosConstruccion = 0;

        this.accionRealizada();
    }

    public void construccionRealizada() {

        this.turnosConstruccion++;
    }

    private void ValidarConstruirCastillo(Pieza unaPieza) {

        if(unaPieza.obtenerTamanio() == 16)
            throw new ConstruccionCastilloException();

    }

    private void validarPiezaEdificio(Pieza unaPieza){

        if(unaPieza.obtenerTamanio() == 1)
            throw new PiezaNoReparableNoConstruibleException();

    }

    @Override
    public void repararPieza(Pieza unaPieza) {

        this.validarPiezaEdificio(unaPieza);
        this.validarAcciones();


        this.estado.reparar(this.estado);
        ((Edificio)unaPieza).darVidaPorReparacion();

    }

    public boolean estaTrabajando() {
        return estado.estaTrabajando();
    }

    @Override
    public PiezaType obtenerType() {
        return UNIDAD_ALDEANO;
    }

    @Override
    public double getTamanio() {
        return tamanio;
    }

    @Override
    public String obtenerNombre() {
        return "Aldeano";
    }

    @Override
    public int oroRecolectado() {
        return estado.oroRecolectado();
    }

    @Override
    public void refrescar() {
       if(!estado.estaTrabajando())
           super.refrescar();
    }

    @Override
    public void seguirTrabajando() {

        this.construccionRealizada();

        this.estado = estado.construir(edificioEnConstruccion, turnosConstruccion);

        if(turnosConstruccion == TURNOS_CONSTRUCCION_MAXIMO){
            this.turnosConstruccion = 0;
        }

    }

}
