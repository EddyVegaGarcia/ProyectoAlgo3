package fiuba.algo3.tp2.controlador;

import fiuba.algo3.tp2.modelo.Juego.*;
import fiuba.algo3.tp2.vista.ContenedorPrincipal;
import javafx.geometry.Insets;
import javafx.scene.canvas.Canvas;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

public class JuegoView {

    private Jugador jugador2;
    private Jugador jugador1;
    private ContenedorPrincipal contenedorPrincipal;
    private Canvas canvasCentral;
    public int height = 700;
    public int width = 1300;
    private Juego juego;

    public JuegoView(ContenedorPrincipal contenedorPrincipal, String nombreJugador1, String nombreJugador2) {

        juego = new Juego(nombreJugador1, nombreJugador2);
        this.contenedorPrincipal = contenedorPrincipal;
        jugador1 = juego.jugador1();
        jugador2 = juego.jugador2();

        Canvas canvasCentral = new Canvas(width, height);

        setMapa(canvasCentral);

      //  UbicarEdificios ubicarEdificios = new UbicarEdificios(juego, canvasCentral);
       // UbicarUnidades ubicarUnidades = new UbicarUnidades(juego, canvasCentral);
        setEstadoDelJuego(canvasCentral);

        contenedorPrincipal.setCenter(canvasCentral);
    }

    private void setMapa(Canvas canvasCentral) {
        Image imagen = new Image("file:src/fiuba/algo3/tp2/vista/imagenes/fondo.jpeg");
        canvasCentral.getGraphicsContext2D().drawImage(imagen,0,0, width, height);
    }

    private void setBotones() {

        VBox contenedorVertical = new VBox();
        contenedorVertical.setSpacing(10);
        contenedorVertical.setPadding(new Insets(10));

        agregarEtiquetasDeVidasDeJugadores(contenedorVertical);

        BotonTerminarFase boton = new BotonTerminarFase(contenedorVertical, juego);

        contenedorPrincipal.setLeft(contenedorVertical);
    }

    private void agregarEtiquetasDeVidasDeJugadores(VBox contenedorVertical) {
        VBox contenedorJugador1 = new VBox();
        contenedorJugador1.setPadding(new Insets(10));
        contenedorJugador1.setSpacing(10);

        VBox contenedorJugador2 = new VBox();
        contenedorJugador2.setPadding(new Insets(10));
        contenedorJugador2.setSpacing(10);

        //etiqueta para la vida de los jugadores
        Label etiquetaVidaCastilloJugador1 = crearEtiquetaConTexto("vida : " + jugador1.vida());
        Label etiquetaVidaCastilloJugador2 = crearEtiquetaConTexto("vida : " + jugador2.vida());

        //etiqueta para los nombres de los jugadores
        Label nombreJugador1 = crearEtiquetaConTexto(jugador1.nombre());
        Label nombreJugador2 = crearEtiquetaConTexto(jugador2.nombre());

        contenedorJugador1.getChildren().addAll(nombreJugador1, etiquetaVidaCastilloJugador1);
        contenedorJugador2.getChildren().addAll(nombreJugador2, etiquetaVidaCastilloJugador2);

        HBox contenedorHorizontal = new HBox();
        contenedorHorizontal.setSpacing(10);
        contenedorHorizontal.getChildren().addAll(contenedorJugador1, contenedorJugador2);

        contenedorVertical.getChildren().addAll(contenedorHorizontal);
    }

    private void setEstadoDelJuego(Canvas canvasCentral) {
        setBotones();
        setPiezasJugador(jugador1,canvasCentral);
        setPiezasJugador(jugador2, canvasCentral);
    }

    private void setPiezasJugador(Jugador jugador, Canvas canvasCentral) {
        UbicarPiezas ubicarPiezas = new UbicarPiezas(jugador, canvasCentral);
    }

    private Label crearEtiquetaConTexto(String texto){
        Label etiqueta = new Label();
        etiqueta.setText(texto);
        return etiqueta;
    }
}
