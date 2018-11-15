package fiuba.algo3.tp2;

public abstract class Unidad {

    int vida;
    Posicion posicion;
    int costo;

    public void moverArriba(String dimensionMapa) {
        posicion.moverArriba(dimensionMapa);
    }

    public void moverAbajo(String dimensionMapa) {
        posicion.moverAbajo(dimensionMapa);
    }

    public boolean estaEnCasillero(String pos) {
        return posicion.esIgualA(pos);
    }

    public void moverIzquierda(String dimensionMapa) {
        posicion.moverIzquierda(dimensionMapa);
    }

    public void moverDerecha(String dimensionMapa) {
        posicion.moverDerecha(dimensionMapa);
    }

    public void moverSuperiorIzquierda(String dimensionMapa) {
        posicion.moverSuperiorIzquierda(dimensionMapa);
    }

    public void moverSuperiorDerecha(String dimensionMapa) {
        posicion.moverSuperiorDerecha(dimensionMapa);
    }

    public void moverInferiorIzquierda(String dimensionMapa) {
        posicion.moverInferiorIzquierda(dimensionMapa);
    }

    public void moverInferiorDerecha(String dimensionMapa) {
        posicion.moverInferiorDerecha(dimensionMapa);
    }


    public abstract void atacar(Edificio edificio);

    public int obtenerVida(){
        return vida;
    }
}

