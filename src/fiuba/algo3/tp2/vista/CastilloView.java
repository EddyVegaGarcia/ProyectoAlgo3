package fiuba.algo3.tp2.vista;

import fiuba.algo3.tp2.controlador.Jugador;
import javafx.scene.canvas.Canvas;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class CastilloView {
    private final Canvas canvas;
    private final double posicionX;
    private final double posicionY;
    private final Image imagen;

    public CastilloView(Canvas canvas, int posicionX, int posicionY) {

        this.posicionX = posicionX;
        this.posicionY = posicionY;
        this.canvas = canvas;

        imagen = new Image("file:src/fiuba/algo3/tp2/vista/imagenes/castillo.png");
        canvas.getGraphicsContext2D().drawImage(imagen, (posicionX*1080/40),(posicionY*720/35),(4*1080/40),(4*720/35));
    }
}
