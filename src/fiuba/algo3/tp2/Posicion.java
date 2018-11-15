package fiuba.algo3.tp2;
public class Posicion {

    private int x;
    private int y;

    Posicion (String pos) {

        int[] posicion = this.convertirStringAint(pos);
        this.x = posicion[0];
        this.y = posicion[1];
    }

    public void moverArriba(String dimensionMapa) {
        String nuevaPosicion = this.convertirIntAString(x-1, y);
        Posicion posicionAMover = new Posicion(nuevaPosicion);
        if (posicionAMover.esPosicionValida(dimensionMapa)) {
            this.x = x-1;
        } else {
            throw new RuntimeException();
        }
    }

    public boolean esIgualA(String pos) {
        int[] posicionActual = this.convertirStringAint(pos);
        return (posicionActual[0] == x) && (posicionActual[1] == y);

    }

    private int[] convertirStringAint(String cadena){

        int [] resultado = new int[2];
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

    public void moverAbajo(String dimensionMapa) {
        String nuevaPosicion = this.convertirIntAString(x+1, y);
        Posicion posicionAMover = new Posicion(nuevaPosicion);
        if (posicionAMover.esPosicionValida(dimensionMapa)) {
            this.x = x+1;
        } else {
            throw new RuntimeException();
        }
    }

    public void moverIzquierda(String dimensionMapa) {
        String nuevaPosicion = this.convertirIntAString(x, y-1);
        Posicion posicionAMover = new Posicion(nuevaPosicion);
        if (posicionAMover.esPosicionValida(dimensionMapa)) {
            this.y = y-1;
        } else {
            throw new RuntimeException();
        }
    }

    public void moverDerecha(String dimensionMapa) {
        String nuevaPosicion = this.convertirIntAString(x, y+1);
        Posicion posicionAMover = new Posicion(nuevaPosicion);
        if (posicionAMover.esPosicionValida(dimensionMapa)) {
            this.y = y+1;
        } else {
            throw new RuntimeException();
        }
    }

    public void moverSuperiorIzquierda(String dimensionMapa) {
        String nuevaPosicion = this.convertirIntAString(x-1, y-1);
        Posicion posicionAMover = new Posicion(nuevaPosicion);
        if (posicionAMover.esPosicionValida(dimensionMapa)) {
            this.x = x-1;
            this.y = y-1;
        } else {
            throw new RuntimeException();
        }
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
    }
}