package fiuba.algo3.tp2.vista;

import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.control.MenuBar;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class ContenedorPrincipal extends BorderPane{

    public ContenedorPrincipal(Stage stage){
        this.setBotonera();
        this.setMenu(stage);
    }

    private void setMenu(Stage stage) {
        BarraDeMenu menuBar = new BarraDeMenu(stage);
        this.setTop(menuBar);
    }

    private void setBotonera() {

        Button boton = new Button();
        boton.setText("botonPrueba");

        Button boton2 = new Button();
        boton2.setText("botonPrueba2");

        Button boton3 = new Button();
        boton3.setText("botonPrueba3");

        VBox contenedorVertical = new VBox(boton, boton2, boton3);

        contenedorVertical.setSpacing(10);
        contenedorVertical.setPadding(new Insets(15));

        this.setRight(contenedorVertical);
    }
}
