package fiuba.algo3.tp2.modelo;

import java.util.ArrayList;

import static fiuba.algo3.tp2.modelo.Constantes.*;

public class Aldeano extends Unidad {

    public int oro;
    public EstadoDeAldeano estado;


    public Aldeano(ArrayList<Posicion> unasPosiciones) {
        this.vida = VIDA_MAXIMA_ALDEANO;
        this.costo = COSTO_ALDEANO;
        this.oro = 0;
        this.estado = new EnReposo();
        this.posiciones = unasPosiciones;
        this.tamanio = TAMANIO_UNIDAD;
    }

    public void construir(Edificio edificio)  {
        estado.construir(edificio)
    }


    public void reparar(Edificio edificio) {
        this.estado = estado.trabajando();
        edificio.reparar();

    }

    public int obtenerOroTotal() {
        return oro;
    }

    public void sumarOro(){
        this.oro = oro + 20;
    }

    public void ganarMonedas(){ estado.ganarOro(this);
    }


    public EstadoDeAldeano obtenerEstado() {
        return estado;
    }
}
