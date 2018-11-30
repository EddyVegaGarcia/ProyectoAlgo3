package fiuba.algo3.tp2.vista;

import fiuba.algo3.tp2.controlador.Juego;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.paint.Color;

import javax.naming.NameClassPair;

public class BotonEnviarEventHandler implements EventHandler<ActionEvent> {

    private TextField nombreJugador1;
    private Label etiquetaNombreJugador1;
    private TextField nombreJugador2;
    private Label etiquetaNombreJugador2;


    public BotonEnviarEventHandler(TextField nombreJugador1, TextField nombreJugador2, Label unaEtiqueta, Label otraEtiqueta) {
        this.nombreJugador1 = nombreJugador1;
        this.etiquetaNombreJugador1 = unaEtiqueta;
        this.nombreJugador2 = nombreJugador2;
        this.etiquetaNombreJugador2 = otraEtiqueta;
    }

    @Override
    public void handle(ActionEvent actionEvent) {

        if (this.nombreJugador1.getText().trim().equals("") || this.nombreJugador2.getText().trim().equals("")) {
            this.etiquetaNombreJugador1.setText("Debe ingresar nombre! ");
            this.etiquetaNombreJugador1.setTextFill(Color.BLACK);
            this.etiquetaNombreJugador2.setText("Debe ingresar nombre! ");
            this.etiquetaNombreJugador2.setTextFill(Color.BLACK);

        } else {

            this.etiquetaNombreJugador1.setText("Nombre del primer jugador: " + this.nombreJugador1.getText());
            this.etiquetaNombreJugador1.setTextFill(Color.BLUEVIOLET);

            this.etiquetaNombreJugador2.setText("Nombre del segundo jugador: " + this.nombreJugador2.getText());
            this.etiquetaNombreJugador2.setTextFill(Color.BLUEVIOLET);
        }

    }

    public String obtenerNombrePrimerJugador() {
        return this.nombreJugador1.getText();
    }

    public String obtenerNombreSegundoJugador() {
        return this.nombreJugador2.getText();
    }

}