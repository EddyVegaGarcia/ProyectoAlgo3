package fiuba.algo3.tp2.controlador;

import fiuba.algo3.tp2.modelo.Campo.Posicion;
import fiuba.algo3.tp2.modelo.Juego.*;
import fiuba.algo3.tp2.modelo.Piezas.Pieza;
import javafx.scene.canvas.Canvas;
import javafx.scene.image.Image;

import java.util.ArrayList;

import static fiuba.algo3.tp2.modelo.Constantes.*;

public class UbicarPiezas {
    private Jugador jugador;
    private Canvas canvas;
    private double height;
    private double widht;

    public UbicarPiezas(Jugador jugador, Canvas canvasCentral) {

        this.jugador = jugador;
        this.canvas = canvasCentral;

        widht = canvas.getWidth();
        height = canvas.getHeight();

        ubicarPiezas(jugador.getPiezas());
    }

    private void ubicarPiezas(ArrayList<Pieza> piezas) {

        for(Pieza pieza : piezas){
            Image imagen = new Image("file:src/fiuba/algo3/tp2/vista/imagenes/" + pieza.getClass().getSimpleName() + ".png");

            double tamanio = Math.sqrt(pieza.getTamanio());

            Posicion posicion = pieza.obtenerPrimeraPosicion();
            ubicarPieza(imagen, posicion.getColumna(), posicion.getFila(),tamanio);
        }
    }

    private void ubicarPieza(Image imagen, int columna, int fila, double tamanio) {
        double posicionX = (columna*widht/COLUMNA_DEFAULT_MAPA);
        double posicionY = (fila*height/FILA_DEFAULT_MAPA);

        canvas.getGraphicsContext2D().drawImage(imagen, posicionX, posicionY, (tamanio*widht/COLUMNA_DEFAULT_MAPA), (tamanio*height/FILA_DEFAULT_MAPA));
    }
}
