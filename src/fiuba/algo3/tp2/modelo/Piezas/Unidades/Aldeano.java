package fiuba.algo3.tp2.modelo.Piezas.Unidades;

import fiuba.algo3.tp2.modelo.Estados.*;
import fiuba.algo3.tp2.modelo.Exception.*;
import fiuba.algo3.tp2.modelo.Interfaces.*;
import fiuba.algo3.tp2.modelo.Juego.Jugador;
import fiuba.algo3.tp2.modelo.Piezas.*;
import fiuba.algo3.tp2.modelo.UnidadFactory.PiezaFactory;
import fiuba.algo3.tp2.modelo.UnidadFactory.PiezaType;


import static fiuba.algo3.tp2.modelo.Constantes.*;
import static fiuba.algo3.tp2.modelo.UnidadFactory.PiezaType.*;

public class Aldeano extends Unidad implements Constructor, Creable {

    public EstadoDeAldeano estado;
    int turnosConstruccion;
    Edificio edificioCreado;


    public Aldeano() {

        this.vida = VIDA_MAXIMA_ALDEANO;
        this.costo = COSTO_ALDEANO;
        this.estado = new EnReposo();
        this.tamanio = TAMANIO_UNIDAD;
        this.turnosConstruccion = 0;

    }

    @Override
    public Edificio colocarPieza(PiezaType piezaType, Jugador unJugador) {

        if ( (piezaType != PiezaType.EDIFICIO_CUARTEL) && (piezaType != PiezaType.EDIFICIO_PLAZACENTRAL) )
            throw new InvalidUnidadTypeException();

        this.validarAcciones();

        Creable edificio;
        edificio = (Creable)PiezaFactory.crearPieza(piezaType);
        edificio.validarOroSuficiente(unJugador.obtenerOro());
        unJugador.pagar(edificio.costo());

        this.accionRealizada();
        return (Edificio)edificio;
    }

    @Override
    public void construir(Pieza unaPieza)  {

        this.validarPiezaEdificio(unaPieza);
        this.ValidarConstruirCastillo(unaPieza);
        this.validarAcciones();

        ((Construible)unaPieza).verificarProcesoEnConstruccion();

        edificioCreado = (Edificio)unaPieza;

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

        ((Reparable)unaPieza).verificarProcesoEnReparacion();

        edificioCreado = (Edificio) unaPieza;

        this.seguirReparando();

        this.accionRealizada();
    }

    public boolean estaTrabajando() {
        return ((Colocador)estado).estaTrabajando();
    }

    public boolean estaReparando(){
        return ((Reparador)estado).estaReparando();
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
    public int oroRecolectado() {
        return estado.oroRecolectado();
    }

    @Override
    public void refrescar() {
       if(!((Colocador)estado).estaTrabajando() && !((Reparador)estado).estaReparando())
           super.refrescar();
    }

    @Override
    public void validarOroSuficiente(int oro) {
        if( oro < COSTO_ALDEANO )
            throw new OroInsuficienteException();
    }

    @Override
    public int costo() {
        return COSTO_ALDEANO;
    }

    @Override
    public void seguirTrabajando() {

        this.construccionRealizada();

        this.estado = ((Colocador)estado).construir(edificioCreado, turnosConstruccion);

        if(turnosConstruccion == TURNOS_CONSTRUCCION_MAXIMO){
            this.turnosConstruccion = 0;
        }

    }

    @Override
    public void seguirReparando() {

        edificioCreado.darVidaPorReparacion();
        this.estado = ((Reparador)estado).reparar(edificioCreado, edificioCreado.obtenerType());
    }
}
