package fiuba.algo3.tp2.modelo.Piezas.Unidades;

import fiuba.algo3.tp2.controlador.MouseEventHandler;
import fiuba.algo3.tp2.modelo.Estados.*;
import fiuba.algo3.tp2.modelo.Exception.AccionUnicaRealizadaException;
import fiuba.algo3.tp2.modelo.Exception.ConstruccionCastilloException;
import fiuba.algo3.tp2.modelo.Interfaces.*;
import fiuba.algo3.tp2.modelo.Piezas.*;


import static fiuba.algo3.tp2.modelo.Campo.Constantes.*;

public class Aldeano extends Unidad implements Constructor {

    public int oro;
    public EstadoDeAldeano estado;
    int turnosConstruccion;


    public Aldeano() {

        this.vida = VIDA_MAXIMA_ALDEANO;
        this.costo = COSTO_ALDEANO;
        this.oro = 0;
        this.estado = new EnReposo();
        this.tamanio = TAMANIO_UNIDAD;
        this.turnosConstruccion = 0;

    }

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

    public int obtenerOroTotal() {
        return oro;
    }

    public void sumarOro(){
        this.oro = oro + 20;
    }

    public void ganarMonedas(){ estado.ganarOro(this);
    }

    public boolean estaTrabajando() {
        return estado.estaTrabajando();
    }

    @Override
    public boolean sosPlazaCentral() {
        return false;
    }

    @Override
    public boolean sosAldeano() {
        return true;
    }

    @Override
    public boolean sosArmaAsedio() {
        return false;
    }

    @Override
    public String nombre() {
        return "Aldeano";
    }

    @Override
    public boolean podesMoverte() {
        return true;
    }

    @Override
    public boolean podesAtacar() {
        return false;
    }

    @Override
    public boolean podesConstruirArmaDeAsedio() {
        return false;
    }

    @Override
    public boolean podesDesmontarArmaAsedio() {
        return false;
    }

    @Override
    public boolean podesCrearUnAldeano() {
        return false;
    }

    @Override
    public boolean podesReparar() {
        return true;
    }

    @Override
    public double getTamanio() {
        return tamanio;
    }
}
