package fiuba.algo3.tp2.vista;

import fiuba.algo3.tp2.controlador.Juego;
import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Screen;
import javafx.stage.Stage;

public class ContenedorPrincipal extends BorderPane {

    Stage myStage;
    private Juego juego;
    public double height;
    public double width;

    public ContenedorPrincipal(Stage stage){
        this.myStage = stage;
        //this.setMenu();
        this.nombreDeLosJugadores();
    }

    private void setMenu() {
        BarraDeMenu menuBar = new BarraDeMenu(myStage);
        this.setTop(menuBar);
    }


    public void nombreDeLosJugadores() {

        Label etiquetaJugador1 = new Label();
        etiquetaJugador1.setText("Jugador 1 : ");

        TextField campoJugador1 = new TextField();
        campoJugador1.setPromptText("Ingrese un nombre");
        campoJugador1.setFocusTraversable(false);

        HBox contenedorHorizontalJugador1 = new HBox();
        contenedorHorizontalJugador1.getChildren().addAll(etiquetaJugador1, campoJugador1);

        Label etiquetaJugador2 = new Label();
        etiquetaJugador2.setText("Jugador 2 : ");

        TextField campoJugador2 = new TextField();
        campoJugador2.setPromptText("Ingrese un nombre");
        campoJugador2.setFocusTraversable(false);

        HBox contenedorHorizontalJugador2 = new HBox();
        contenedorHorizontalJugador2.getChildren().addAll(etiquetaJugador2, campoJugador2);

        Button botonEnviar = new Button();
        botonEnviar.setText(" Enviar ");

        Label mensajeJugador1 = new Label();
        Label mensajeJugador2 = new Label();

        BotonEnviarEventHandler botonEnviarEventHandler = new BotonEnviarEventHandler(campoJugador1, campoJugador2, mensajeJugador1, mensajeJugador2, this);
        botonEnviar.setOnAction(botonEnviarEventHandler);

        VBox contenedorVertical = new VBox(10);
        contenedorVertical.setPadding(new Insets(20));
        contenedorVertical.getChildren().addAll(contenedorHorizontalJugador1, contenedorHorizontalJugador2, botonEnviar, mensajeJugador1, mensajeJugador2);

        this.setCenter(contenedorVertical);
    }


    public void iniciarJuego(String nombreJugador1, String nombreJugador2) {

        juego = new Juego(nombreJugador1, nombreJugador2);

        height = Screen.getPrimary().getVisualBounds().getHeight()*0.9;
        width = Screen.getPrimary().getVisualBounds().getWidth()*0.9;

        setBackground();
        setButton();
        CastilloView castillo = new CastilloView(this, 2, 1);
    }

    private void setButton() {

        VBox contenedorVertical = new VBox();

        Button botonTerminarFase = new Button();
        botonTerminarFase.setText("Terminar Turno");

        contenedorVertical.getChildren().addAll(botonTerminarFase);

        this.setLeft(contenedorVertical);
    }

    private void setBackground() {
        ImageView background = new ImageView();
        background.setImage(new Image("file:src/fiuba/algo3/tp2/vista/imagenes/arenaDeCombate.jpg"));
        background.setFitHeight(height);
        background.setFitWidth(width);
        this.setCenter(background);
    }
}
