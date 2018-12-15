package fiuba.algo3.tp2.controlador;

import fiuba.algo3.tp2.modelo.Direcciones.*;
import fiuba.algo3.tp2.modelo.Interfaces.Atacante;
import fiuba.algo3.tp2.modelo.Interfaces.Constructor;
import fiuba.algo3.tp2.modelo.Interfaces.Diseñador;
import fiuba.algo3.tp2.modelo.Interfaces.Montable;
import fiuba.algo3.tp2.modelo.Juego.*;
import fiuba.algo3.tp2.modelo.Piezas.Pieza;
import fiuba.algo3.tp2.modelo.UnidadFactory.PiezaType;
import fiuba.algo3.tp2.vista.ContenedorPrincipal;
import fiuba.algo3.tp2.vista.OpcionTerminarJuegoEventHandler;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.stage.Modality;
import javafx.stage.Stage;

import static fiuba.algo3.tp2.modelo.Constantes.LIMITE_POBLACION;
import static fiuba.algo3.tp2.modelo.UnidadFactory.PiezaType.*;

public class JuegoView {

    private Stage stage;
    private VBox contenedorTop;
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
        stage = myStage;

        canvasCentral = new Canvas(width, height);
        canvasCentral.setOnMousePressed(new MouseEventHandler(this, juego, canvasCentral));

        contenedorParaUnaPieza = new VBox();
        contenedorParaUnaPieza.setPrefWidth(250);
        contenedorParaUnaPieza.setSpacing(10);
        contenedorParaUnaPieza.setPadding(new Insets(10));

        contenedorConsola = new VBox();
        contenedorConsola.setPrefHeight(20);
        contenedorConsola.setSpacing(10);
        contenedorConsola.setPadding(new Insets(15));

        contenedorTop = new VBox();
        contenedorTop.setSpacing(20);
        setMenu();

        contenedorInformacionDeJugadores = new HBox();
        contenedorInformacionDeJugadores.setPrefHeight(20);
        contenedorInformacionDeJugadores.setSpacing(10);
        contenedorInformacionDeJugadores.setPadding(new Insets(15));

        informarQueJugadorEstaDeTurno();

        setConsola();
        acualizarContenedorDeInformacionDeJugadores();
        setEstadoDelJuego(canvasCentral);

        contenedorPrincipal.setCenter(canvasCentral);
        contenedorPrincipal.setTop(contenedorTop);
        contenedorPrincipal.setLeft(contenedorParaUnaPieza);
        contenedorPrincipal.setBottom(contenedorConsola);

        contenedorTop.getChildren().add(contenedorInformacionDeJugadores);

    }

    private void setMenu() {
        MenuBar barra = new MenuBar();

        Menu menuInicio = new Menu("Inicio");
        Menu menuAyuda = new Menu("Ayuda");

        MenuItem opcionTerminarJuego = new MenuItem("Terminar Juego");
        MenuItem opcionInstrucciones = new MenuItem("Instrucciones");

        opcionTerminarJuego.setOnAction(new OpcionTerminarJuegoEventHandler(stage));

        menuInicio.getItems().addAll(opcionTerminarJuego);
        menuAyuda.getItems().addAll(opcionInstrucciones);

        barra.getMenus().addAll(menuInicio, menuAyuda);

        contenedorTop.getChildren().add(barra);
    }

    private void colocarDatosDeTurno(Jugador jugadorDeTurno){
        VBox contenedorVertical = new VBox();
        contenedorVertical.setPrefWidth(800);
        contenedorVertical.setSpacing(10);
        contenedorVertical.setPadding(new Insets(10));

        agregarBotonTerminarFase(contenedorVertical);

        Label etiquetaTurno = new Label();
        etiquetaTurno.setText("Turno del Jugador : " + jugadorDeTurno.obtenerNombre());

        contenedorVertical.getChildren().add(etiquetaTurno);
        contenedorInformacionDeJugadores.getChildren().add(contenedorVertical);

    }

    private void colocarDatosDelJugador(Jugador jugadorDeTurno) {

        HBox contenedorHorizonal = new HBox();
        contenedorHorizonal.setSpacing(30);
        contenedorHorizonal.setPadding(new Insets(15));

        Label etiquetaVida = new Label();
        etiquetaVida.setText("Vida : " + jugadorDeTurno.vida());

        Label etiqueta = new Label();
        etiqueta.setText("Oro : " + jugadorDeTurno.stringOro());

        Label etiquetaPoblacion = new Label();
        etiquetaPoblacion.setText("Poblacion : " + jugadorDeTurno.poblacion() + " / " + LIMITE_POBLACION);

        contenedorHorizonal.getChildren().addAll(etiquetaVida, etiqueta, etiquetaPoblacion);
        contenedorInformacionDeJugadores.getChildren().add(contenedorHorizonal);
    }

    private void informarQueJugadorEstaDeTurno() {

        Stage nuevoStage = new Stage();
        nuevoStage.initOwner(stage);
        nuevoStage.setTitle("Jugador De Turno");

        Pane root = new Pane();

        VBox contenedorVertical = new VBox();
        contenedorVertical.setPadding(new Insets(15));
        contenedorVertical.setSpacing(15);
        contenedorVertical.setPrefWidth(250);

        Label etiqueta = new Label();
        etiqueta.setText("Comienza el Jugador : " + juego.jugadorDeTurno().obtenerNombre() + ".");

        Button boton = new Button();
        boton.setText("Aceptar");
        boton.setDefaultButton(true);
        boton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                nuevoStage.close();
            }
        });

        contenedorVertical.getChildren().addAll(etiqueta, boton);
        root.getChildren().add(contenedorVertical);

        Scene escena = new Scene(root);

        nuevoStage.setScene(escena);
        nuevoStage.show();
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

    private void agregarBotonTerminarFase(VBox contenedorVertical){
        BotonTerminarFase boton = new BotonTerminarFase(contenedorVertical, juego, this);
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
                agregarBotonColocarCuartel(pieza);
                agregarBotonColocarPlazaCentral(pieza);
                agregarBotonConstruirEdificio(pieza);
                agregarBotonReparar(pieza);

            }
            else if (type.equals(PiezaType.UNIDAD_ARMADEASEDIO)){

                agregarBotonesDeMovimiento(pieza);
                agregarBotonMontarse(pieza);
                agregarBotonDesmontarse(pieza);
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

    private void agregarBotonConstruirEdificio(Pieza pieza) {

        Button boton = new Button();
        boton.setOnAction(new TrabajoEventHandler(this, juego, canvasCentral,(Constructor) pieza,
                UNIDAD_ARQUERO , etiquetaConsola));
        boton.setText("Terminar construccion");

        contenedorParaUnaPieza.getChildren().add(boton);

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

    private void agregarBotonColocarPlazaCentral(Pieza pieza) {

        Button boton = new Button();
        boton.setOnAction(new CreacionEventHandler(this,juego,canvasCentral, (Diseñador) pieza,
                EDIFICIO_PLAZACENTRAL, etiquetaConsola));
        boton.setText("Crear Plaza Central");

        contenedorParaUnaPieza.getChildren().add(boton);

    }

    private void agregarBotonColocarCuartel(Pieza pieza) {

        Button boton = new Button();
        boton.setOnAction(new CreacionEventHandler(this,juego,canvasCentral,(Diseñador) pieza,
                EDIFICIO_CUARTEL, etiquetaConsola));
        boton.setText("Crear Cuartel");

        contenedorParaUnaPieza.getChildren().add(boton);

    }

    private void agregarBotonReparar(Pieza pieza) {

        Button boton = new Button();
        boton.setOnAction(new RepararEventHandler(this, juego, canvasCentral,
                (Constructor) pieza , etiquetaConsola));
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

    private void agregarBotonMontarse(Pieza pieza){

        Button boton = new Button();
        boton.setOnAction(new MontarEventHandler(this, juego, canvasCentral,(Montable) pieza,
                UNIDAD_ARMADEASEDIO , etiquetaConsola));
        boton.setText("Montarse");

        contenedorParaUnaPieza.getChildren().add(boton);

    }

    private void agregarBotonDesmontarse(Pieza pieza) {

        Button boton = new Button();
        boton.setOnAction(new DesmontarEventHandler(this, juego, canvasCentral,(Montable) pieza,
                UNIDAD_ARMADEASEDIO , etiquetaConsola));
        boton.setText("Desmontarse");

        contenedorParaUnaPieza.getChildren().add(boton);

    }

    private void agregarBotonConstruirArmaAsedio(Pieza pieza) {

        Button boton = new Button();
        boton.setOnAction(new CreacionEventHandler(this, juego, canvasCentral,
                (Diseñador) pieza, UNIDAD_ARMADEASEDIO , etiquetaConsola));
        boton.setText("Construir Arma de Asedio");


        contenedorParaUnaPieza.getChildren().add(boton);

    }

    private void agregarBotonDeAtaque(Pieza unAtacante) {

        Button boton = new Button();
        boton.setOnAction(new AtacarEventHandler(this, juego, canvasCentral,
                (Atacante)unAtacante, etiquetaConsola, stage));
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
        colocarDatosDeTurno(juego.jugadorDeTurno());
        colocarDatosDelJugador(juego.jugadorDeTurno());
    }
}
