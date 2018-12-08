package fiuba.algo3.tp2.modelo.Piezas.Unidades;

import fiuba.algo3.tp2.modelo.Estados.*;
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

        this.turnosConstruccion++;
        this.estado = estado.construir(unEdificio,turnosConstruccion);
        if(turnosConstruccion == TURNOS_CONSTRUCCION_MAXIMO){
            this.turnosConstruccion = 0;
        }
    }

    private void ValidarEdificio(Edificio unEdificio) {

        if(unEdificio.obtenerTamanio() == 16)
            throw new ConstruccionCastilloException();

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
}