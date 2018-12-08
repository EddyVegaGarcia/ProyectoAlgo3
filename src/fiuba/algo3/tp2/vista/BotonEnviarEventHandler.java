package fiuba.algo3.tp2.vista;

import fiuba.algo3.tp2.modelo.Juego.*;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.paint.Color;


public class BotonEnviarEventHandler implements EventHandler<ActionEvent> {

    private ContenedorPrincipal contenedorPrincipal;
    private TextField campoJugador1;
    private TextField campoJugador2;
    private Label mensaje;
    private Label mensaje2;
    private Juego juego;

    public BotonEnviarEventHandler(TextField campoJugador1, TextField campoJugador2, Label mensaje, Label mensaje2, ContenedorPrincipal contenedorPrincipal) {
        this.campoJugador1 = campoJugador1;
        this.campoJugador2 = campoJugador2;
        this.mensaje = mensaje;
        this.mensaje2 = mensaje2;
        this.contenedorPrincipal = contenedorPrincipal;
    }

    @Override
    public void handle(ActionEvent actionEvent) {

        if (this.campoJugador1.getText().trim().equals("") || this.campoJugador2.getText().trim().equals("")) {

            this.mensaje.setText("Debe ingresar un nombre! ");
            this.mensaje.setTextFill(Color.BLACK);
            this.mensaje2.setText("Debe ingresar un nombre! ");
            this.mensaje2.setTextFill(Color.BLACK);

        } else {

            contenedorPrincipal.iniciarJuego(campoJugador1.getText(), campoJugador2.getText());
        }

    }

}