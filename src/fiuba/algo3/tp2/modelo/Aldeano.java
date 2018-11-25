package fiuba.algo3.tp2.modelo;

import static fiuba.algo3.tp2.modelo.Constantes.*;

public class Aldeano extends Unidad {

    int oro;
    private EstadoDeAldeano estado;


    public Aldeano() {
        this.vida = VIDA_MAXIMA_ALDEANO;
        this.costo = COSTO_ALDEANO;
        this.oro = 0;
        this.estado = new EnReposo();
    }

    public void construir(Edificio edificio)  {
        this.estado = estado.trabajando();
        edificio.construir();
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

    public void ganarMonedas(){
       estado.ganarOro(this);
    }


    public EstadoDeAldeano obtenerEstado() {
        return estado;
    }
}
