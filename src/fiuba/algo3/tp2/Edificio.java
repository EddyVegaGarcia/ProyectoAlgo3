package fiuba.algo3.tp2;

public abstract class Edificio {

    int vida;
    int costo;
    EstadoDeEdificio estado;
    int tamanio;
    int turnosConstruccion;

    public void construir(){
        if(turnosConstruccion == 3){
            this.estado = new Construido();
            this.darleVida();
        }
        this.turnosConstruccion = turnosConstruccion + 1;
    }

    public abstract boolean estaConstruido();

    public abstract void recibirDanio(int danio);

    public abstract void reparar();

    public abstract void darleVida();

    public abstract boolean estaReparado();
}

