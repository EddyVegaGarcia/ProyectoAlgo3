package fiuba.algo3.tp2;

import java.util.HashMap;
import java.util.Map;

public class ColleccionParcelas {

    private Map<String, Parcela> parcelas =  new HashMap<String, Parcela>();


    private void iniciarParcelas(int cantidadFilas, int cantidadColumnas){

        for(int i = 1; i < cantidadFilas + 1; i++) {
            for(int j = 1; j < cantidadColumnas + 1; j++) {

                String keyCadena = Integer.toString(i) + "," + Integer.toString(j);

                parcelas.put(keyCadena, new Parcela(i,j));
            }
        }

    }

    ColleccionParcelas() {

        this.iniciarParcelas(35,40);

    }

    ColleccionParcelas(int cantidadFilas, int cantidadColumnas) {

        this.iniciarParcelas(cantidadFilas,cantidadColumnas);

    }

    public Boolean compararCantidadParcelas(int unaCantidadParcela){

        return unaCantidadParcela == parcelas.size();

    }

    public void colocarUnidad(int posicionFila, int posicionColumna)  {

        Parcela parcela = this.encontrarUbicacion(posicionFila, posicionColumna);

        parcela.ocuparParcela("unidad");

    }

    private Parcela encontrarUbicacion(int posicionFila, int posicionColumna) throws UbicacionErroneaException{

        String keyCadena = Integer.toString(posicionFila) + "," + Integer.toString(posicionColumna);

        if(parcelas.get(keyCadena) == null)
            throw new UbicacionErroneaException();

        return parcelas.get(keyCadena);

    }

    public Boolean estaOcupada(int posicionFila, int posicionColumna) {

        Parcela parcela = this.encontrarUbicacion(posicionFila, posicionColumna);

        return parcela.estaOcupado();

    }
}
