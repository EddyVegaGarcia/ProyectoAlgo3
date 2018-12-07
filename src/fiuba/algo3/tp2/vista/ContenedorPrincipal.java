package fiuba.algo3.tp2.vista;

import fiuba.algo3.tp2.controlador.*;
import fiuba.algo3.tp2.modelo.Juego;
import javafx.geometry.Insets;
import javafx.scene.canvas.Canvas;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class ContenedorPrincipal extends BorderPane {

    Stage myStage;

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

        myStage.setTitle("Nombre de los Jugadores");

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

        myStage.setMaximized(true);
        myStage.setTitle("Algo3Age of Empires");

        JuegoView vistaJuego = new JuegoView(this, nombreJugador1, nombreJugador2);
    }
}
