package fiuba.algo3.tp2.modelo.Piezas;

import fiuba.algo3.tp2.modelo.Estados.*;


public abstract class Edificio extends Pieza {

    public EstadoDeEdificio estado;

    public void iniciarConstruccion(){
        this.estado = new EnConstruccion();
    }

    public void finalizarConstruccion(){
        this.estado = new Construido();
    }

    public boolean estaConstruido(){
        return estado.estaConstruido();
    }

    public abstract void darVidaPorReparacion();

}