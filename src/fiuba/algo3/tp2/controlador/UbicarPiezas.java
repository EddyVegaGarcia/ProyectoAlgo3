package fiuba.algo3.tp2.controlador;

import fiuba.algo3.tp2.modelo.Campo.Posicion;
import fiuba.algo3.tp2.modelo.Juego.*;
import fiuba.algo3.tp2.modelo.Piezas.Edificios.Castillo;
import fiuba.algo3.tp2.modelo.Piezas.Edificios.PlazaCentral;
import fiuba.algo3.tp2.modelo.Piezas.Unidad;
import fiuba.algo3.tp2.modelo.Piezas.Unidades.Aldeano;
import javafx.scene.canvas.Canvas;
import javafx.scene.image.Image;

import java.util.ArrayList;

import static fiuba.algo3.tp2.modelo.Campo.Constantes.*;


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


        ubicarAledanos(jugador.getAldeanos());
        ubicarCastillo(jugador.obtenerCastillo());
        ubicarPlazas(jugador.getPlazas());
    }

    public UbicarPiezas(Canvas canvasCentral){

        this.canvas = canvasCentral;

        widht = canvas.getWidth();
        height = canvas.getHeight();


    }

    private void ubicarPlazas(ArrayList<PlazaCentral> plazas) {
        Image imagen = new Image("file:src/fiuba/algo3/tp2/vista/imagenes/PlazaCentral.png");

        double tamanio = Math.sqrt(TAMANIO_PLAZA);

        for(PlazaCentral plaza : plazas){
            Posicion posicion = plaza.obtenerPosicion();
            ubicarPieza(imagen, posicion.getColumna(), posicion.getFila(),tamanio);
        }
    }

    private void ubicarCastillo(Castillo castillo) {
        Posicion posicion = castillo.obtenerPosicion();

        double tamanio = Math.sqrt(TAMANIO_CASTILLO);

        Image imagen = new Image("file:src/fiuba/algo3/tp2/vista/imagenes/Castillo.png");

        ubicarPieza(imagen, posicion.getColumna(), posicion.getFila(), tamanio);
    }

    private void ubicarAledanos(ArrayList<Aldeano> aldeanos) {
        
        Image imagen = new Image("file:src/fiuba/algo3/tp2/vista/imagenes/Aldeano.png");
        double tamanio = Math.sqrt(TAMANIO_UNIDAD);

        for(Aldeano aldeano : aldeanos){
            Posicion posicion = aldeano.obtenerPosicion();
            ubicarPieza(imagen, posicion.getColumna(), posicion.getFila(),tamanio);
        }
    }

    public void UbicarArmasDeAsedios(Unidad unaUnidad){

        Image imagen = new Image("file:src/fiuba/algo3/tp2/vista/imagenes/ArmaDeAsedio.jpg");
        double tamanio = Math.sqrt(TAMANIO_UNIDAD);

        Posicion posicion = unaUnidad.obtenerPosicion();
        ubicarPieza(imagen, posicion.getColumna(), posicion.getFila(),tamanio);


    }

    private void ubicarPieza(Image imagen, int columna, int fila, double tamanio) {
        double posicionX = (columna*widht/COLUMNA_DEFAULT_MAPA);
        double posicionY = (fila*height/FILA_DEFAULT_MAPA);

        canvas.getGraphicsContext2D().drawImage(imagen, posicionX, posicionY, (tamanio*widht/COLUMNA_DEFAULT_MAPA), (tamanio*height/FILA_DEFAULT_MAPA));
    }
}
