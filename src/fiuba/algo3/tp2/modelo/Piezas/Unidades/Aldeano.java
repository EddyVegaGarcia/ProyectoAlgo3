package fiuba.algo3.tp2.modelo.Piezas.Unidades;

import fiuba.algo3.tp2.modelo.Estados.*;
import fiuba.algo3.tp2.modelo.Exception.*;
import fiuba.algo3.tp2.modelo.Interfaces.*;
import fiuba.algo3.tp2.modelo.Juego.Jugador;
import fiuba.algo3.tp2.modelo.Piezas.*;
import fiuba.algo3.tp2.modelo.Piezas.Edificios.Castillo;
import fiuba.algo3.tp2.modelo.Piezas.Edificios.Cuartel;
import fiuba.algo3.tp2.modelo.Piezas.Edificios.PlazaCentral;
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

        Creable edificio;
        edificio = (Creable)PiezaFactory.crearPieza(piezaType);
        edificio.validarOroSuficiente(unJugador.obtenerOro());

        return (Edificio)edificio;

    }

    @Override
    public void construir(Pieza unaPieza)  {

        this.validarAcciones();

        unaPieza.verificarPosibleConstruccion();

        edificioCreado = (Edificio)unaPieza;

        this.seguirTrabajando();

        turnosConstruccion = 0;

        this.accionRealizada();
    }

    public void construccionRealizada() {

        this.turnosConstruccion++;
    }

    @Override
    public void repararPieza(Pieza unaPieza) {

        this.validarAcciones();
        unaPieza.verificarPosibleReparacion();

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
        return costo;
    }

    @Override
    public void seguirRealizandoAccion() {

        this.estado.seguirRalizandoAccion(this);

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

        this.estado = ((Reparador)estado).reparar(edificioCreado, edificioCreado.obtenerType());
        edificioCreado.reparacionPor(this);

    }

    @Override
    public void repararCuartel(Cuartel unCuartel) {

        unCuartel.darVidaPorReparacion(VIDA_REPARACION_A_CUARTEL);

    }

    @Override
    public void repararPlazaCentral(PlazaCentral unaPlazaCentral) {

        unaPlazaCentral.darVidaPorReparacion(VIDA_REPARACION_A_PLAZACENTRAL);

    }

    @Override
    public void repararCastillo(Castillo unCastillo) {

        unCastillo.darVidaPorReparacion(VIDA_REPARACION_A_CASTILLO);

    }

    @Override
    public void recibirDanioDe(Atacante atacante) {
        atacante.atacarUnidad(this);
    }

}
