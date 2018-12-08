package fiuba.algo3.tp2.vista;

import javafx.scene.canvas.Canvas;
import javafx.scene.image.Image;

import static fiuba.algo3.tp2.modelo.Campo.Constantes.*;

public class CastilloView {
    private double tamanio;
    private double widht;
    private Canvas canvas;
    private double posicionX;
    private double posicionY;
    private Image imagen;
    private double height;

    public CastilloView(Canvas canvas, double posicionX, double posicionY) {

        this.posicionX = posicionX;
        this.posicionY = posicionY;
        this.canvas = canvas;

        widht = canvas.getWidth();
        height = canvas.getHeight();

        tamanio = Math.sqrt(TAMANIO_CASTILLO);

        imagen = new Image("file:src/fiuba/algo3/tp2/vista/imagenes/castillo.png");
        canvas.getGraphicsContext2D().drawImage(imagen, posicionX,posicionY,(tamanio*widht/COLUMNA_DEFAULT_MAPA),(tamanio*height/FILA_DEFAULT_MAPA));
    }
}
