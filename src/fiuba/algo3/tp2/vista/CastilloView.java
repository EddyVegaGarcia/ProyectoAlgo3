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

    public CastilloView(Canvas canvas, double posicionX, double posicionY) {

        this.posicionX = posicionX;
        this.posicionY = posicionY;
        this.canvas = canvas;

        imagen = new Image("file:src/fiuba/algo3/tp2/vista/imagenes/castillo.png");
        canvas.getGraphicsContext2D().drawImage(imagen, posicionX,posicionY,(4*1300/40),(4*900/35));
    }
}
