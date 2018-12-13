package fiuba.algo3.tp2.controlador;

import fiuba.algo3.tp2.modelo.Direcciones.*;
import fiuba.algo3.tp2.modelo.Interfaces.Diseñador;
import fiuba.algo3.tp2.modelo.Juego.*;
import fiuba.algo3.tp2.modelo.Piezas.Pieza;
import fiuba.algo3.tp2.modelo.UnidadFactory.PiezaType;
import fiuba.algo3.tp2.vista.ContenedorPrincipal;
import javafx.geometry.Insets;
import javafx.scene.canvas.Canvas;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.stage.Stage;

import static fiuba.algo3.tp2.modelo.UnidadFactory.PiezaType.*;

public class JuegoView {

    private HBox contenedorInformacionDeJugadores;
    private VBox contenedorConsola;
    private VBox contenedorParaUnaPieza;
    private VBox contenedorVertical;
    private Jugador jugador2;
    private Jugador jugador1;
    private ContenedorPrincipal contenedorPrincipal;
    private Canvas canvasCentral;
    public int height = 550;
    public int width = 1000;
    private Juego juego;
    private Label etiquetaConsola;

    public JuegoView(ContenedorPrincipal contenedorPrincipal, String nombreJugador1, String nombreJugador2, Stage myStage) {

        juego = new Juego(nombreJugador1, nombreJugador2);
        this.contenedorPrincipal = contenedorPrincipal;
        jugador1 = juego.jugador1();
        jugador2 = juego.jugador2();

        canvasCentral = new Canvas(width, height);
        canvasCentral.setOnMousePressed(new MouseEventHandler(this, juego, canvasCentral));

        contenedorParaUnaPieza = new VBox();
        contenedorParaUnaPieza.setPrefWidth(200);
        contenedorParaUnaPieza.setSpacing(10);
        contenedorParaUnaPieza.setPadding(new Insets(10));

        contenedorConsola = new VBox();
        contenedorConsola.setPrefHeight(200);
        contenedorConsola.setSpacing(10);
        contenedorConsola.setPadding(new Insets(15));

        contenedorInformacionDeJugadores = new HBox();
        contenedorInformacionDeJugadores.setPrefHeight(200);
        contenedorInformacionDeJugadores.setSpacing(10);
        contenedorInformacionDeJugadores.setPadding(new Insets(15));

        setConsola();
        acualizarContenedorDeInformacionDeJugadores();

        setEstadoDelJuego(canvasCentral);

        contenedorPrincipal.setCenter(canvasCentral);
        contenedorPrincipal.setTop(contenedorInformacionDeJugadores);
        contenedorPrincipal.setLeft(contenedorParaUnaPieza);
        contenedorPrincipal.setBottom(contenedorConsola);

        informarQueJugadorEstaDeTurno();
    }

    private void agregarEtiquetasDeVidasDeJugadores() {
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

        /*HBox contenedorHorizontal = new HBox();
        contenedorHorizontal.setSpacing(10);
        contenedorHorizontal.getChildren().addAll(contenedorJugador1, contenedorJugador2);*/
        contenedorInformacionDeJugadores.getChildren().addAll(contenedorJugador1, contenedorJugador2);

        //contenedorVertical.getChildren().addAll(contenedorHorizontal);
    }

    private void colocarDatosDelJugador(Jugador jugadorDeTuno) {

        VBox contenedorVertical = new VBox();
        contenedorVertical.setSpacing(10);
        contenedorVertical.setPadding(new Insets(10));

        //colocarBoton(contenedorVertical);

        Label etiqueta = new Label();
        etiqueta.setText("Oro : " + jugadorDeTuno.stringOro());

        String nombreDelJugadorDeTurno = juego.jugadorDeTurno().obtenerNombre();

        Label etiquetaTurno = new Label();
        etiquetaTurno.setText("Turno del Jugador : " + nombreDelJugadorDeTurno);

        contenedorVertical.getChildren().addAll(etiquetaTurno, etiqueta);
        contenedorInformacionDeJugadores.getChildren().add(contenedorVertical);
    }

    private void informarQueJugadorEstaDeTurno() {

        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Inicio Del Juego");
        alert.setHeaderText("Jugador de Turno");
        String mensaje = "Comienza el jugador " + juego.jugadorDeTurno().obtenerNombre() + ".";
        alert.setContentText(mensaje);
        alert.show();

    }

    private void setConsola() {
        etiquetaConsola = new Label();
        etiquetaConsola.setText("consola...");
        etiquetaConsola.setFont(Font.font("courier new", FontWeight.SEMI_BOLD, 14));
        etiquetaConsola.setTextFill(Color.WHITE);

        contenedorConsola.getChildren().add(etiquetaConsola);
        contenedorConsola.setStyle("-fx-background-color: black;");
    }

    private void setMapa(Canvas canvasCentral) {
        Image imagen = new Image("file:src/fiuba/algo3/tp2/vista/imagenes/MapaBase2.jpg");
        canvasCentral.getGraphicsContext2D().drawImage(imagen,0,0, width, height);
    }

    private void agregarBotonTerminarFase(){
        BotonTerminarFase boton = new BotonTerminarFase(contenedorInformacionDeJugadores, juego, this);
    }

    private void setEstadoDelJuego(Canvas canvasCentral) {

        setMapa(canvasCentral);
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

        contenedorParaUnaPieza.getChildren().clear();
        contenedorInformacionDeJugadores.getChildren().clear();
        contenedorVertical.getChildren().clear();
        canvasCentral.getGraphicsContext2D().clearRect(0,0, canvasCentral.getWidth(), canvasCentral.getHeight());

        acualizarContenedorDeInformacionDeJugadores();

        setEstadoDelJuego(canvasCentral);
    }

    public void BotonFactory(Pieza pieza) {

        vaciarOpcionesDePieza();
        etiquetaConsola.setText("");

        if( juego.jugadorDeTurno().sosDuenioDe(pieza)) {

            agregarInformacionDePieza(pieza);
            PiezaType type = pieza.obtenerType();

            if(type.equals(PiezaType.UNIDAD_ESPADACHIN)){

                agregarBotonesDeMovimiento(pieza);
                agregarBotonDeAtaque(pieza);

            }
            else if (type.equals(PiezaType.UNIDAD_ALDEANO)){

                agregarBotonesDeMovimiento(pieza);
                agregarBotonConstruirCuartel(pieza);
                agregarBotonConstruirPlazaCentral(pieza);
                agregarBotonReparar(pieza);

            }
            else if (type.equals(PiezaType.UNIDAD_ARMADEASEDIO)){

                agregarBotonesDeMovimiento(pieza);
                //agregarBotonMontarse(pieza);
                //agregarBotonDesmontarse(pieza);
                agregarBotonDeAtaque(pieza);

            }
            else if (type.equals(PiezaType.UNIDAD_ARQUERO)){

                agregarBotonesDeMovimiento(pieza);
                agregarBotonDeAtaque(pieza);

            }
            else if (type.equals(PiezaType.EDIFICIO_CASTILLO)){

                agregarBotonConstruirArmaAsedio(pieza);

            }
            else if (type.equals(PiezaType.EDIFICIO_CUARTEL)){

                agregarBotonCrearEspadachin(pieza);
                agregarBotonCrearArquero(pieza);

            }
            else if (type.equals(PiezaType.EDIFICIO_PLAZACENTRAL)){

                agregarBotonCrearAldeano(pieza);

            }
        }
        else{

            etiquetaConsola.setText("La pieza seleccionada, no pertenece al jugador de turno");

        }

    }

    private void agregarBotonCrearArquero(Pieza pieza) {

        Button boton = new Button();
        boton.setOnAction(new CreacionEventHandler(this, juego, canvasCentral,(Diseñador) pieza,
                UNIDAD_ARQUERO , etiquetaConsola));
        boton.setText("Crear Arquero");

        contenedorParaUnaPieza.getChildren().add(boton);

    }

    private void agregarBotonCrearEspadachin(Pieza pieza) {

        Button boton = new Button();
        boton.setOnAction(new CreacionEventHandler(this, juego, canvasCentral, (Diseñador)pieza,
                UNIDAD_ESPADACHIN , etiquetaConsola));
        boton.setText("Crear espadachin");

        contenedorParaUnaPieza.getChildren().add(boton);

    }

    private void agregarBotonConstruirPlazaCentral(Pieza pieza) {

        Button boton = new Button();
        boton.setOnAction(new CreacionEventHandler(this,juego,canvasCentral, (Diseñador) pieza,
                EDIFICIO_PLAZACENTRAL, etiquetaConsola));
        boton.setText("Crear Plaza Central");

        contenedorParaUnaPieza.getChildren().add(boton);

    }

    private void agregarBotonConstruirCuartel(Pieza pieza) {

        Button boton = new Button();
        boton.setOnAction(new CreacionEventHandler(this,juego,canvasCentral,(Diseñador) pieza,
                EDIFICIO_CUARTEL, etiquetaConsola));
        boton.setText("Crear Cuartel");

        contenedorParaUnaPieza.getChildren().add(boton);

    }

    private void agregarBotonReparar(Pieza pieza) {

        Button boton = new Button();
        boton.setText("Reparar");

        contenedorParaUnaPieza.getChildren().add(boton);

    }

    private void agregarBotonCrearAldeano(Pieza pieza) {

        Button boton = new Button();
        boton.setOnAction(new CreacionEventHandler(this, juego, canvasCentral, (Diseñador) pieza,
                UNIDAD_ALDEANO , etiquetaConsola));
        boton.setText("Crear Aldeano");

        contenedorParaUnaPieza.getChildren().add(boton);

    }
    /*
    private void agregarBotonDesmontar(Pieza pieza) {
        if(pieza.podesDesmontarArmaAsedio()) {
            Button boton = new Button();
            boton.setText("Desmontar Arma de Asedio");

            contenedorParaUnaPieza.getChildren().add(boton);
        }
    }
    */

    private void agregarBotonConstruirArmaAsedio(Pieza pieza) {

        Button boton = new Button();
        boton.setOnAction(new CreacionEventHandler(this, juego, canvasCentral,
                (Diseñador) pieza, UNIDAD_ARMADEASEDIO , etiquetaConsola));
        boton.setText("Construir Arma de Asedio");


        contenedorParaUnaPieza.getChildren().add(boton);

    }

    private void agregarBotonDeAtaque(Pieza pieza) {

        Button boton = new Button();
        boton.setText("Atacar");

        contenedorParaUnaPieza.getChildren().add(boton);

    }

    private void agregarBotonesDeMovimiento(Pieza pieza) {

        Button botonMoverIzquierda = new Button();
        botonMoverIzquierda.setOnAction(new MoverEventHandler(this, juego, pieza, new DireccionIzquierda(), etiquetaConsola));
        botonMoverIzquierda.setText("Mover Izquierda");

        Button botonMoverDerecha = new Button();
        botonMoverDerecha.setOnAction(new MoverEventHandler(this, juego, pieza, new DireccionDerecha(), etiquetaConsola));
        botonMoverDerecha.setText("Mover Derecha");

        Button botonMoverArriba = new Button();
        botonMoverArriba.setOnAction(new MoverEventHandler(this, juego, pieza, new DireccionArriba(), etiquetaConsola));
        botonMoverArriba.setText("Mover Arriba");

        Button botonMoverAbajo = new Button();
        botonMoverAbajo.setOnAction(new MoverEventHandler(this, juego, pieza, new DireccionAbajo(), etiquetaConsola));
        botonMoverAbajo.setText("Mover Abajo");

        Button botonMoverArribaIzquierda = new Button();
        botonMoverArribaIzquierda.setOnAction(new MoverEventHandler(this, juego, pieza, new DireccionArribaIzquierda(), etiquetaConsola));
        botonMoverArribaIzquierda.setText("Mover Arriba-Izquierda");

        Button botonMoverArribaDerecha = new Button();
        botonMoverArribaDerecha.setOnAction(new MoverEventHandler(this, juego, pieza, new DireccionArribaDerecha(), etiquetaConsola));
        botonMoverArribaDerecha.setText("Mover Arriba-Derecha");

        Button botonMoverAbajoIzquierda = new Button();
        botonMoverAbajoIzquierda.setOnAction(new MoverEventHandler(this, juego, pieza, new DireccionAbajoIzquierda(), etiquetaConsola));
        botonMoverAbajoIzquierda.setText("Mover Abajo-Izquierda");

        Button botonMoverAbajoDerecha = new Button();
        botonMoverAbajoDerecha.setOnAction(new MoverEventHandler(this, juego, pieza, new DireccionAbajoDerecha(), etiquetaConsola));
        botonMoverAbajoDerecha.setText("Mover Abajo-Derecha");

        contenedorParaUnaPieza.getChildren().addAll(botonMoverIzquierda, botonMoverDerecha, botonMoverArriba, botonMoverAbajo, botonMoverAbajoDerecha, botonMoverAbajoIzquierda, botonMoverArribaDerecha, botonMoverArribaIzquierda);

    }

    private void agregarInformacionDePieza(Pieza pieza) {

        Label etiqueta = crearEtiquetaConTexto("Selecciono : " + pieza.obtenerNombre());

        Label etiquetaVida = crearEtiquetaConTexto("Vida : " + pieza.obtenerVida());

        contenedorParaUnaPieza.getChildren().addAll(etiqueta, etiquetaVida);
    }

    public void acualizarContenedorDeInformacionDeJugadores() {
        contenedorInformacionDeJugadores.getChildren().clear();
        colocarDatosDelJugador(juego.jugadorDeTurno());
        agregarBotonTerminarFase();
        agregarEtiquetasDeVidasDeJugadores();
    }
}
