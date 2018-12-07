package fiuba.algo3.tp2.controlador;

import fiuba.algo3.tp2.modelo.Juego;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;

public class BotonTerminarFase extends Button {

    private Juego juego;
    private VBox contenedor;
    private int x = 10;

    public BotonTerminarFase(VBox contenedor, Juego juego){

        this.contenedor = contenedor;
        this.juego = juego;

        this.colocarBoton();
    }

    private void colocarBoton() {
        //String nombreDelJugadorDeTurno = "victor";
        Label etiqueta = new Label();
        etiqueta.setText("Turno del Jugador : " + x);

        Button boton = new Button();
        boton.setText("Terminar turno");
        boton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                //juego.terminarTurno
                x+=10;
                etiqueta.setText("Turno del Jugador : " + x);
            }
        });

        contenedor.getChildren().addAll(etiqueta, boton);
    }
}
