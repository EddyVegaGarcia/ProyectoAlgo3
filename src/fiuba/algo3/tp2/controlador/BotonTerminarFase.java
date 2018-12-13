package fiuba.algo3.tp2.controlador;

import fiuba.algo3.tp2.modelo.Juego.*;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

public class BotonTerminarFase extends Button {

    private Jugador jugador1;
    private Jugador jugador2;
    private JuegoView juegoView;
    private Juego juego;
    private VBox contenedor;
    private String nombreDelJugadorDeTurno;

    public BotonTerminarFase(VBox contenedor, Juego juego, JuegoView juegoView){

        this.contenedor = contenedor;
        this.juego = juego;
        this.juegoView = juegoView;
        this.jugador1 = juego.jugador1();
        this.jugador2 = juego.jugador2();

        colocarBoton();
    }

    private void colocarBoton() {

        Button boton = new Button();
        boton.setText("Terminar turno");
        boton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                juego.terminarTurno();
                juegoView.acualizarContenedorDeInformacionDeJugadores();
            }
        });

        contenedor.getChildren().add(boton);
    }
}
