package fiuba.algo3.tp2.modelo;

import static fiuba.algo3.tp2.modelo.Constantes.*;
import fiuba.algo3.tp2.modelo.UnidadFactory.*;
import fiuba.algo3.tp2.modelo.Exception.*;

public abstract class Edificio extends Pieza {

    public EstadoDeEdificio estado;
    protected int turnosConstruccion;

    public void construir() {
        this.turnosConstruccion = turnosConstruccion + 1;
        if (turnosConstruccion == TURNOS_CONSTRUCCION) {
            this.estado = estado.cambiar();
        }
    }

    public void reparar(){
        this.vida = vida + VIDA_REPARACION;
        if (vida == this.vidaMaxima()){
            this.estado = estado.cambiar();
        }
    }

    public abstract Unidad crearUnidad(UnidadType unidadType);

}