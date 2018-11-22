package fiuba.algo3.tp2.modelo;

public class PlazaCentral extends Edificio {
    static final int VIDAMAXIMA = 450;
    static final int TURNOSCOMPLETOS = 2;


    public PlazaCentral(){
        this.costo = 100;
        this.vida = 0;
        this.estado = new EnConstruccion();
        this.tamanio = 4;
        this.turnosConstruccion = 0;
    }

    @Override
    public void construir() {
        if(turnosConstruccion == TURNOSCOMPLETOS){
           this.estado = estado.cambiar();
           this.vida = VIDAMAXIMA;
        }
        this.turnosConstruccion = turnosConstruccion + 1;
    }

      @Override
    protected int vidaMaxima(){
        return VIDAMAXIMA;
    }

    public Aldeano crearAldeano() {
        return new Aldeano();
    }
}
