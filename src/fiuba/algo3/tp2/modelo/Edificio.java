package fiuba.algo3.tp2.modelo;

import static fiuba.algo3.tp2.modelo.Constantes.*;

public abstract class Edificio extends Pieza {

    EstadoDeEdificio estado;
    int turnosConstruccion;

    public void construir() {
        if(turnosConstruccion == TURNOS_CONSTRUCCION){
            this.estado = estado.cambiar();
            this.darleVida();
        }
        this.turnosConstruccion = turnosConstruccion + 1;
    }

    public void reparar(){
        this.vida = vida + VIDA_REPARACION;
        if (vida == this.vidaMaxima()){
            this.estado = estado.cambiar();
        }
    }

    @Override
    public void recibirDanio(int danio){
        if(vida == this.vidaMaxima()){
            this.estado = estado.cambiar();
        }
        this.vida = vida - danio;
    }

    protected abstract int vidaMaxima();

    protected abstract void darleVida();
}