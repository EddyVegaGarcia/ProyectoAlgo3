package fiuba.algo3.tp2;

public class Mapa {

    ColleccionParcelas coleccionistaParcelas;

    public Mapa(){

        coleccionistaParcelas = new ColleccionParcelas();

    }

    public Mapa(int filas, int columnas){
        coleccionistaParcelas = new ColleccionParcelas(filas, columnas);
    }

    public Boolean compararTamanio(int unaCantidadParcela) {

        return coleccionistaParcelas.compararCantidadParcelas(unaCantidadParcela);
    }

    public void colocarUnidad(int posicionFila, int posicionColumna) {

        coleccionistaParcelas.colocarUnidad(posicionFila, posicionColumna);

    }

    public boolean estaOcupadaEnPosicion(int posicionFila, int posicionColumna) {

        return coleccionistaParcelas.estaOcupada(posicionFila, posicionColumna);

    }
}
