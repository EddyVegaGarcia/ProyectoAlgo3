package fiuba.algo3.tp2.controlador;

import fiuba.algo3.tp2.modelo.Juego.*;
import fiuba.algo3.tp2.modelo.Piezas.Edificios.Castillo;
import fiuba.algo3.tp2.modelo.Piezas.Edificios.PlazaCentral;
import fiuba.algo3.tp2.modelo.Piezas.Unidades.Aldeano;
import fiuba.algo3.tp2.vista.ContenedorPrincipal;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.canvas.Canvas;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

public class JuegoView {

    private VBox contenedorParaUnaPieza;
    private VBox contenedorVertical;
    private Jugador jugador2;
    private Jugador jugador1;
    private ContenedorPrincipal contenedorPrincipal;
    private Canvas canvasCentral;
    public int height = 600;
    public int width = 1100;
    private Juego juego;

    public JuegoView(ContenedorPrincipal contenedorPrincipal, String nombreJugador1, String nombreJugador2) {

        juego = new Juego(nombreJugador1, nombreJugador2);
        this.contenedorPrincipal = contenedorPrincipal;
        jugador1 = juego.jugador1();
        jugador2 = juego.jugador2();

        canvasCentral = new Canvas(width, height);
        canvasCentral.setOnMousePressed(new MauseEventHandler(this, juego, canvasCentral));

        contenedorVertical = new VBox();
        contenedorVertical.setSpacing(10);
        contenedorVertical.setPadding(new Insets(10));

        contenedorParaUnaPieza = new VBox();
        contenedorParaUnaPieza.setSpacing(10);
        contenedorParaUnaPieza.setPadding(new Insets(10));

        setBotones();
        setEstadoDelJuego(canvasCentral);

        contenedorPrincipal.setCenter(canvasCentral);
    }

    private void setMapa(Canvas canvasCentral) {
        Image imagen = new Image("file:src/fiuba/algo3/tp2/vista/imagenes/MapaBase7.jpg");
        canvasCentral.getGraphicsContext2D().drawImage(imagen,0,0, width, height);
    }

    private void setBotones() {

        agregarEtiquetasDeVidasDeJugadores(contenedorVertical);

        BotonTerminarFase boton = new BotonTerminarFase(contenedorVertical, juego);

        contenedorPrincipal.setLeft(contenedorVertical);

        contenedorVertical.getChildren().add(contenedorParaUnaPieza);
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
        Label nombreJugador1 = crearEtiquetaConTexto(jugador1.obtenerNombre());
        Label nombreJugador2 = crearEtiquetaConTexto(jugador2.obtenerNombre());

        contenedorJugador1.getChildren().addAll(nombreJugador1, etiquetaVidaCastilloJugador1);
        contenedorJugador2.getChildren().addAll(nombreJugador2, etiquetaVidaCastilloJugador2);

        HBox contenedorHorizontal = new HBox();
        contenedorHorizontal.setSpacing(10);
        contenedorHorizontal.getChildren().addAll(contenedorJugador1, contenedorJugador2);

        contenedorVertical.getChildren().addAll(contenedorHorizontal);
    }

    private void setEstadoDelJuego(Canvas canvasCentral) {
        setMapa(canvasCentral);
        //setBotones();
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

    public void activarBotoneraDeCastillo(Castillo castillo) {
        vaciarOpcionesDePieza();

        Label etiqueta = new Label();
        etiqueta.setText("Selecciono : Castillo");

        Button boton = new Button();
        boton.setText("Atacar");

        Button botonCrearArmaAsedio = new Button();
        botonCrearArmaAsedio.setText("Crear Arma de Asedio");

        contenedorParaUnaPieza.getChildren().addAll(etiqueta, boton, botonCrearArmaAsedio);
    }

    public void vaciarOpcionesDePieza() {
        contenedorParaUnaPieza.getChildren().clear();
    }

    public void activarBotoneraDeArquero() {
        vaciarOpcionesDePieza();

        Label etiqueta = new Label();
        etiqueta.setText("Selecciono : Arquero");

        Button boton = new Button();
        boton.setText("Atacar");

        Button botonMoverIzq = new Button();
        botonMoverIzq.setText("Mover Izquierda");

        Button botonMoverDer = new Button();
        botonMoverDer.setText("Mover Derecha");

        Button botonMoverArriba = new Button();
        botonMoverArriba.setText("Mover Arriba");

        Button botonMoverAbajo = new Button();
        botonMoverAbajo.setText("Mover Abajo");

        contenedorParaUnaPieza.getChildren().addAll(etiqueta, boton, botonMoverArriba, botonMoverAbajo, botonMoverDer, botonMoverIzq);
    }

    public void activarBotoneraDeArmaAsedio() {
        vaciarOpcionesDePieza();

        Label etiqueta = new Label();
        etiqueta.setText("Selecciono : Arma de Asedio");

        Button boton = new Button();
        boton.setText("Atacar");

        Button botonDesmontar = new Button();
        boton.setText("Desmontar");

        contenedorParaUnaPieza.getChildren().addAll(etiqueta, boton, botonDesmontar);
    }

    public void activarBotoneraAldeano(Aldeano aldeano) {
        vaciarOpcionesDePieza();

        Label etiqueta = new Label();
        etiqueta.setText("Selecciono : Aldeano");

        Label etiquetaVida = new Label();
        etiquetaVida.setText("Vida : " + aldeano.obtenerVida());

        Button boton = new Button();
        boton.setText("Construir");

        Button botonReparar = new Button();
        botonReparar.setText("Reparar");

        Button botonMoverIzq = new Button();
        botonMoverIzq.setOnAction(new MoverIzqEventHandler(this, juego, aldeano));
        botonMoverIzq.setText("Mover Izquierda");

        Button botonMoverDer = new Button();
        botonMoverDer.setOnAction(new MoverDerEventHandler(this, juego, aldeano));
        botonMoverDer.setText("Mover Derecha");

        Button botonMoverArriba = new Button();
        botonMoverArriba.setOnAction(new MoverArribaEventHandler(this, juego, aldeano));
        botonMoverArriba.setText("Mover Arriba");

        Button botonMoverAbajo = new Button();
        botonMoverAbajo.setOnAction(new MoverAbajoEventHandler(this, juego, aldeano));
        botonMoverAbajo.setText("Mover Abajo");

        contenedorParaUnaPieza.getChildren().addAll(etiqueta, etiquetaVida, boton, botonReparar, botonMoverArriba, botonMoverAbajo, botonMoverDer, botonMoverIzq);
    }

    public void activarBotoneraPlaza(PlazaCentral plaza) {
        vaciarOpcionesDePieza();

        Label etiqueta = new Label();
        etiqueta.setText("Selecciono : Plaza Central");

        Label etiquetaVida = new Label();
        etiquetaVida.setText("Vida : " + plaza.obtenerVida());

        Button boton = new Button();
        boton.setText("Crear Aldeano");

        contenedorParaUnaPieza.getChildren().addAll(etiqueta, etiquetaVida, boton);
    }

    public void actualizar() {
        canvasCentral.getGraphicsContext2D().clearRect(0,0, canvasCentral.getWidth(), canvasCentral.getHeight());
        setEstadoDelJuego(canvasCentral);
    }
}
