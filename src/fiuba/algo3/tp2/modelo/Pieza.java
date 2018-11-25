package fiuba.algo3.tp2.modelo;

public abstract class Pieza {

    int vida;
    int costo;
    int tamanio;

    public int obtenerVida(){ return vida; }

    public int obtenerTamanio() { return tamanio; }

    public abstract void recibirDanio(int danio);

}
