package fiuba.algo3.tp2;

public class Parcela {

    int fila;
    int columna;
    EstadoParcela estadoParcela;
    String contiene;

    Parcela(int i, int j) {

        contiene = "vacio";
        fila = i;
        columna = j;

        estadoParcela = new Libre();
    }

    public void ocuparParcela(String unaUnidad){

        contiene = unaUnidad;
        estadoParcela = estadoParcela.Ocupar();

    }

    public Boolean estaOcupado() {

        return estadoParcela.estaOcupado();

    }
}
