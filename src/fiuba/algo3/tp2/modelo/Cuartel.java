package fiuba.algo3.tp2.modelo;

public class Cuartel extends Edificio {
    static final int VIDAMAXIMA = 250;
    static final int TURNOSCOMPLETOS = 2;

    public Cuartel(){
        this.costo = 50;
        this.vida = 0;
        this.tamanio = 4;
        this.estado = new EnConstruccion();
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
    protected int vidaMaxima() {
        return VIDAMAXIMA;
    }

    public Espadachin crearEspadachin() {
        return new Espadachin();
    }

    public Arquero crearArquero() {
        return new Arquero();
    }
}
