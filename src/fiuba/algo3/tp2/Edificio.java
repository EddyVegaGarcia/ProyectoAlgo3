package fiuba.algo3.tp2;

public abstract class Edificio {

    private static final int REPARACION = 15;

    int vida;
    int costo;
    EstadoDeEdificio estado;
    int tamanio;
    int turnosConstruccion;


    public  abstract void construir();

    protected abstract int vidaMaxima();


    public void reparar(){
        this.vida = vida + REPARACION;
        if (vida == this.vidaMaxima()){
            this.estado = estado.cambiar();
        }
    }

    public void recibirDanio(int danio){
        if(vida == this.vidaMaxima()){
            this.estado = estado.cambiar();
        }
        this.vida = vida - danio;
    }

    public int obtenerVida() {
        return vida;
    }
}

