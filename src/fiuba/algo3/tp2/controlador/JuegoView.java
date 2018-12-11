package fiuba.algo3.tp2.controlador;

import fiuba.algo3.tp2.modelo.Direcciones.*;
import fiuba.algo3.tp2.modelo.Juego.*;
import fiuba.algo3.tp2.modelo.Piezas.Pieza;
import fiuba.algo3.tp2.vista.ContenedorPrincipal;
import javafx.geometry.Insets;
import javafx.scene.canvas.Canvas;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

import static fiuba.algo3.tp2.modelo.UnidadFactory.UnidadType.*;

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
        canvasCentral.setOnMousePressed(new MouseEventHandler(this, juego, canvasCentral));

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

    public void vaciarOpcionesDePieza() {
        contenedorParaUnaPieza.getChildren().clear();
    }

    public void actualizar() {
        canvasCentral.getGraphicsContext2D().clearRect(0,0, canvasCentral.getWidth(), canvasCentral.getHeight());
        setEstadoDelJuego(canvasCentral);
    }

    public void crearBotoneraParaPieza(Pieza pieza) {
        vaciarOpcionesDePieza();

        agregarInformacionDePieza(pieza);
        agregarBotonesDeMovimiento(pieza);
        agregarBotonDeAtaque(pieza);
        agregarBotonConstruirArmaAsedio(pieza);
        agregarBotonDesmontar(pieza);
        agregarBotonCrearAldeano(pieza);
        agregarBotonReparar(pieza);
    }

    private void agregarBotonReparar(Pieza pieza) {
        if(pieza.podesReparar()) {
            Button boton = new Button();
            boton.setText("Reparar");

            contenedorParaUnaPieza.getChildren().add(boton);
        }
    }

    private void agregarBotonCrearAldeano(Pieza pieza) {
        if(pieza.podesCrearUnAldeano()) {
            Button boton = new Button();
            boton.setText("Crear Aldeano");

            contenedorParaUnaPieza.getChildren().add(boton);
        }
    }

    private void agregarBotonDesmontar(Pieza pieza) {
        if(pieza.podesDesmontarArmaAsedio()) {
            Button boton = new Button();
            boton.setText("Desmontar Arma de Asedio");

            contenedorParaUnaPieza.getChildren().add(boton);
        }
    }

    private void agregarBotonConstruirArmaAsedio(Pieza pieza) {
        if(pieza.podesConstruirArmaDeAsedio()) {
            Button boton = new Button();
            boton.setOnAction(new CreacionEventHandler(this, juego, canvasCentral, pieza, UNIDAD_ARMADEASEDIO ));
            boton.setText("Construir Arma de Asedio");

            contenedorParaUnaPieza.getChildren().add(boton);
        }
    }

    private void agregarBotonDeAtaque(Pieza pieza) {

        if(pieza.podesAtacar()) {
            Button boton = new Button();
            boton.setText("Atacar");

            contenedorParaUnaPieza.getChildren().add(boton);
        }
    }

    private void agregarBotonesDeMovimiento(Pieza pieza) {

        if(pieza.podesMoverte()) {

            Button botonMoverIzquierda = new Button();
            botonMoverIzquierda.setOnAction(new MoverEventHandler(this, juego, pieza, new DireccionIzquierda()));
            botonMoverIzquierda.setText("Mover Izquierda");

            Button botonMoverDerecha = new Button();
            botonMoverDerecha.setOnAction(new MoverEventHandler(this, juego, pieza, new DireccionDerecha()));
            botonMoverDerecha.setText("Mover Derecha");

            Button botonMoverArriba = new Button();
            botonMoverArriba.setOnAction(new MoverEventHandler(this, juego, pieza, new DireccionArriba()));
            botonMoverArriba.setText("Mover Arriba");

            Button botonMoverAbajo = new Button();
            botonMoverAbajo.setOnAction(new MoverEventHandler(this, juego, pieza, new DireccionAbajo()));
            botonMoverAbajo.setText("Mover Abajo");

            Button botonMoverArribaIzquierda = new Button();
            botonMoverArribaIzquierda.setOnAction(new MoverEventHandler(this, juego, pieza, new DireccionArribaIzquierda()));
            botonMoverArribaIzquierda.setText("Mover Arriba-Izquierda");

            Button botonMoverArribaDerecha = new Button();
            botonMoverArribaDerecha.setOnAction(new MoverEventHandler(this, juego, pieza, new DireccionArribaDerecha()));
            botonMoverArribaDerecha.setText("Mover Arriba-Derecha");

            Button botonMoverAbajoIzquierda = new Button();
            botonMoverAbajoIzquierda.setOnAction(new MoverEventHandler(this, juego, pieza, new DireccionAbajoIzquierda()));
            botonMoverAbajoIzquierda.setText("Mover Abajo-Izquierda");

            Button botonMoverAbajoDerecha = new Button();
            botonMoverAbajoDerecha.setOnAction(new MoverEventHandler(this, juego, pieza, new DireccionAbajoDerecha()));
            botonMoverAbajoDerecha.setText("Mover Abajo-Derecha");

            contenedorParaUnaPieza.getChildren().addAll(botonMoverIzquierda, botonMoverDerecha, botonMoverArriba, botonMoverAbajo, botonMoverAbajoDerecha, botonMoverAbajoIzquierda, botonMoverArribaDerecha, botonMoverArribaIzquierda);
        }
    }

    private void agregarInformacionDePieza(Pieza pieza) {

        Label etiqueta = crearEtiquetaConTexto("Selecciono : " + pieza.nombre());

        Label etiquetaVida = crearEtiquetaConTexto("Vida : " + pieza.obtenerVida());

        contenedorParaUnaPieza.getChildren().addAll(etiqueta, etiquetaVida);
    }
}
