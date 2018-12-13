package fiuba.algo3.tp2.controlador;

import fiuba.algo3.tp2.vista.ContenedorBienvenidos;
import fiuba.algo3.tp2.vista.Main;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class OpcionTerminarJuegoEventHandler implements EventHandler<ActionEvent> {
    private Stage stage;

    public OpcionTerminarJuegoEventHandler(Stage stage) {
        this.stage = stage;
    }

    @Override
    public void handle(ActionEvent event) {
        Main main =  new Main();
        try {
            main.start(stage);
        } catch (Exception e) {
            System.out.print("problemas Con el Main");
        }
    }
}
