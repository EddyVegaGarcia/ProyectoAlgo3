package fiuba.algo3.tp2.modelo.Campo;

public class Posicion {

    private int posicionFila;
    private int posicionColumna;

    /*
        Posicion(String pos) {

            int[] posicion = this.convertirStringAint(pos);
            this.x = posicion[0];
            this.y = posicion[1];
        }
    */
    public Posicion(int unaPosicionFila, int unaPosicionColumna) {
        this.posicionFila = unaPosicionFila;
        this.posicionColumna = unaPosicionColumna;
    }

    public int getColumna() {
        return posicionColumna;
    }

    public int getFila() {
        return posicionFila;
    }

    public boolean estaContenidaEnDimensiones(Posicion unaPosicionLimite) {
        return ((posicionFila >= 0) && (posicionColumna >= 0)
                && (posicionFila < unaPosicionLimite.getFila()) && (posicionColumna < unaPosicionLimite.getColumna()));

    }

    public boolean compararPosicion(Posicion unaPosicion) {
        return ( posicionFila == unaPosicion.getFila()) && (posicionColumna == unaPosicion.getColumna());
    }

    public int obtenerTamanioLimite() {
        return posicionFila * posicionColumna;
    }
}

    /*
    public Posicion calcularPosicionDeUnRango(int tamanio, Mapa mapa) {
            int filaInferior = posicionFila + (tamanio/ 4);
            int columnaDerecha = posicionColumna + (tamanio / 4);

            for (int i = posicionColumna + tamanio; i <= columnaDerecha + tamanio; i++) {
                for (int j = posicionFila + tamanio; j <= filaInferior + tamanio; j++) {
                    Posicion posActual = new Posicion(i, j);
                    if (estaContenidaEnDimensiones(mapa.getFilas(),mapa.getColumnas()) && mapa.estaDisponible(posActual)) {
                        return posActual;
                    }
                }
            }
            return null;

    }
}

    public boolean esIgualA(String pos) {
        int[] posicionActual = this.convertirStringAint(pos);
        return (posicionActual[0] == x) && (posicionActual[1] == y);

    }

    private int[] convertirStringAint(String cadena) {

        int[] resultado = new int[2];
        String[] posicion = cadena.split(",");
        resultado[0] = Integer.parseInt(posicion[0]);
        resultado[1] = Integer.parseInt(posicion[1]);
        return resultado;

    }

    private String convertirIntAString(int x, int y) {
        String nuevoX = Integer.toString(x);
        String nuevoY = Integer.toString(y);

        return nuevoX + "," + nuevoY;
    }

    public boolean esPosicionValida(String dimension) {
        int[] dimensionMapa = this.convertirStringAint(dimension);
        return (x <= dimensionMapa[0]) && (y <= dimensionMapa[1]);
    }




    public void moverSuperiorDerecha(String dimensionMapa) {
        String nuevaPosicion = this.convertirIntAString(x-1, y+1);
        Posicion posicionAMover = new Posicion(nuevaPosicion);
        if (posicionAMover.esPosicionValida(dimensionMapa)) {
            this.x = x-1;
            this.y = y+1;
        } else {
            throw new RuntimeException();
        }

    }

    public void moverInferiorIzquierda(String dimensionMapa) {
        String nuevaPosicion = this.convertirIntAString(x+1, y-1);
        Posicion posicionAMover = new Posicion(nuevaPosicion);
        if (posicionAMover.esPosicionValida(dimensionMapa)) {
            this.x = x+1;
            this.y = y-1;
        } else {
            throw new RuntimeException();
        }
    }

    public void moverInferiorDerecha(String dimensionMapa) {
        String nuevaPosicion = this.convertirIntAString(x+1, y+1);
        Posicion posicionAMover = new Posicion(nuevaPosicion);
        if (posicionAMover.esPosicionValida(dimensionMapa)) {
            this.x = x+1;
            this.y = y+1;
        } else {
            throw new RuntimeException();
        }
    }*/
