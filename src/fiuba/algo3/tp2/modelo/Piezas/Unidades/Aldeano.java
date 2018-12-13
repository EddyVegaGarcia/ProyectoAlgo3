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
    public void construir(Edificio unEdificio)  {

        this.ValidarEdificio(unEdificio);
        this.validarAcciones();

        this.turnosConstruccion++;
        this.estado = estado.construir(unEdificio,turnosConstruccion);
        if(turnosConstruccion == TURNOS_CONSTRUCCION_MAXIMO){
            this.turnosConstruccion = 0;
        }

        this.accionRealizada();
    }

    @Override
    public Edificio colocarPieza(PiezaType piezaType, Jugador unJugador) {

        this.validarOroSufiente(unJugador.oro);

        if (piezaType == PiezaType.EDIFICIO_CUARTEL ||piezaType == PiezaType.EDIFICIO_PLAZACENTRAL ) {

            this.validarAcciones();
            this.accionesRealizadas++;

            if(piezaType == EDIFICIO_CUARTEL)
                unJugador.pagar(COSTO_CUARTEL);
            if(piezaType == EDIFICIO_PLAZACENTRAL)
                unJugador.pagar(COSTO_PLAZACENTRAL);

            return (Edificio) PiezaFactory.crearPieza(piezaType);

        }
        else
            throw new InvalidUnidadTypeException();

    }

    private void ValidarEdificio(Edificio unEdificio) {

        if(unEdificio.obtenerTamanio() == 16)
            throw new ConstruccionCastilloException();

    }

    @Override
    public void validarAcciones() {
        if(accionesRealizadas == 1 && !estado.estaTrabajando())
            throw new AccionUnicaRealizadaException();
    }

    public void reparar(Edificio edificio) {

        this.estado.reparar(this.estado);

        edificio.darVidaPorReparacion();

    }

   /* public int obtenerOroTotal() {
        return stringOro;
    }

   public void sumarOro(){
        this.stringOro = stringOro + 20;
    }

    public void ganarMonedas(){ estado.ganarOro(this);
    }*/

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
}
