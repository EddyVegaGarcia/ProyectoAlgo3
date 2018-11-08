package fiuba.algo3.tp2.modelo;

import static fiuba.algo3.tp2.modelo.Constantes.*;
import fiuba.algo3.tp2.modelo.UnidadFactory.*;
import fiuba.algo3.tp2.modelo.Exception.*;

public abstract class Edificio extends Pieza {

    public EstadoDeEdificio estado;

    public void iniciarConstruccion(){
        this.estado = new EnConstruccion();
    }

    public void finalizarConstruccion(){
        this.estado = new Construido();
    }

    public abstract Unidad crearUnidad(UnidadType unidadType);

    public boolean estaConstruido(){
        return estado.estaConstruido();
    }

}