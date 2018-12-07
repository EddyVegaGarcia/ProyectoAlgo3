package fiuba.algo3.tp2.controlador;

import fiuba.algo3.tp2.modelo.Juego;
import fiuba.algo3.tp2.modelo.Jugador;
import javafx.scene.canvas.Canvas;
import javafx.scene.image.Image;


public class UbicarUnidades {
    private Juego juego;
    private Canvas canvas;
    private double height;
    private double widht;

    public UbicarUnidades(Juego juego, Canvas canvasCentral) {

        this.juego = juego;
        this.canvas = canvas;
        
        ubicarAledanos(juego.jugador1());
    }

    private void ubicarAledanos(Jugador jugador1) {
        
        widht = canvas.getWidth();
        height = canvas.getHeight();
        
        Image imagen = new Image("file:src/fiuba/algo3/tp2/vista/imagenes");
       // canvas.getGraphicsContext2D().drawImage(imagen, );
    }
}
