package fiuba.algo3.tp2.modelo;

import java.util.ArrayList;

import static fiuba.algo3.tp2.modelo.Constantes.*;

public class Aldeano extends Unidad {

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

    public void construir(Edificio edificio)  {
        this.turnosConstruccion++;
        this.estado = estado.construir(edificio,turnosConstruccion);
        if(turnosConstruccion == TURNOS_CONSTRUCCION_MAXIMO){
            this.turnosConstruccion = 0;
        }
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

}
