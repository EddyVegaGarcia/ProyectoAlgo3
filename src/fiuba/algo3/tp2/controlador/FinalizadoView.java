package fiuba.algo3.tp2.controlador;

import fiuba.algo3.tp2.modelo.Juego.Juego;
import fiuba.algo3.tp2.modelo.Juego.Jugador;
import fiuba.algo3.tp2.vista.Main;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.stage.Modality;
import javafx.stage.Stage;

public class FinalizadoView {

    public FinalizadoView(Stage stage, Juego juego) {
        Jugador ganador = juego.ganador();

        Stage nuevoStage = new Stage();
        nuevoStage.setTitle("Algo3Age Of Empires");
        nuevoStage.initOwner(stage);
        nuevoStage.initModality(Modality.WINDOW_MODAL);

        StackPane root = new StackPane();
        Scene escena = new Scene(root);

        Label etiqueta = new Label();
        etiqueta.setText("Ganador : " + ganador.obtenerNombre());

        Button cerrarJuego = new Button();
        cerrarJuego.setText("Cerrar Juego");
        cerrarJuego.setDefaultButton(true);
        cerrarJuego.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                stage.close();
            }
        });

        Button reiniciar = new Button();
        reiniciar.setText("Reiniciar");
        reiniciar.setDefaultButton(true);
        reiniciar.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                nuevoStage.close();
                Main main = new Main();
                try {
                    main.start(stage);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });

        VBox contenedorVertical =  new VBox(etiqueta, reiniciar, cerrarJuego);
        contenedorVertical.setPadding(new Insets(15));
        contenedorVertical.setSpacing(20);
        contenedorVertical.setPrefWidth(250);

        root.getChildren().add(contenedorVertical);
        nuevoStage.setScene(escena);
        nuevoStage.show();
    }
}
