package fiuba.algo3.tp2.vista;

import fiuba.algo3.tp2.controlador.Juego;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class ContenedorPrincipal extends BorderPane {

    Stage myStage;

    public ContenedorPrincipal(Stage stage){
        this.myStage = stage;
        this.setMenu();
    }

    private void setMenu() {
        BarraDeMenu menuBar = new BarraDeMenu(myStage);
        this.setTop(menuBar);
    }


    public void inicializarJuego() {
        myStage.setTitle("> Nombre de los Jugadores <");

        TextField primerJugador = new TextField();
        primerJugador.setPromptText("Ingrese nombre del Jugador 1: ");

        Label etiquetaPrimerJugador = new Label();
        etiquetaPrimerJugador.setText(primerJugador.getText());

        TextField segundoJugador = new TextField();
        segundoJugador.setPromptText("Ingrese nombre del Jugador 2: ");

        Label etiquetaSegundoJugador = new Label();
        etiquetaSegundoJugador.setText(segundoJugador.getText());

        Button botonEnviar = new Button();
        botonEnviar.setText("Enviar");

        HBox contenedorEnviar = new HBox(botonEnviar);

        contenedorEnviar.setSpacing(10);
        contenedorEnviar.setPadding(new Insets(15));
        contenedorEnviar.setAlignment(Pos.BASELINE_CENTER);


        VBox contenedorVertical = new VBox(primerJugador, segundoJugador, etiquetaPrimerJugador, etiquetaSegundoJugador);

        contenedorVertical.setSpacing(5);
        contenedorVertical.setPadding(new Insets(10));
        contenedorVertical.setAlignment(Pos.BASELINE_CENTER);

        BotonEnviarEventHandler botonEnviarEventHandler = new BotonEnviarEventHandler(primerJugador, segundoJugador, etiquetaPrimerJugador, etiquetaSegundoJugador);
        botonEnviar.setOnAction(botonEnviarEventHandler);

        TextoEventHandler textoEventHandler = new TextoEventHandler(botonEnviar);
        primerJugador.setOnKeyPressed(textoEventHandler);
        segundoJugador.setOnKeyPressed(textoEventHandler);

        this.setCenter(contenedorVertical);
        this.setRight(contenedorEnviar);
    }



}
