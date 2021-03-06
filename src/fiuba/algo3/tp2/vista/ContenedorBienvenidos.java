package fiuba.algo3.tp2.vista;


import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.stage.Stage;

import java.awt.*;


public class ContenedorBienvenidos extends StackPane{

    Stage stage;

    public ContenedorBienvenidos(Stage stage, Scene proximaEscena) {

        super();

        this.stage = stage;
        this.setAlignment(Pos.CENTER);

        Toolkit t = Toolkit.getDefaultToolkit();
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();

        Image bgImage = new Image("file:src/fiuba/algo3/tp2/vista/imagenes/AlgoEmpiresPresentacion.jpg");
        ImageView imageView = new ImageView();
        imageView.setImage(bgImage);
        imageView.setFitHeight(screenSize.height);
        imageView.setFitWidth(screenSize.width);
        this.getChildren().add(imageView);

        VBox box = crearVBox(proximaEscena);

        this.getChildren().addAll( box);

    }

    private VBox crearVBox(Scene proximaEscena){

        VBox box = new VBox();

        box.setAlignment(Pos.BASELINE_CENTER);
        box.setSpacing(30);

        Button botonEntrar = new Button();
        botonEntrar.setText(" Iniciar Juego ");
        botonEntrar.setDefaultButton(true);


        Label etiqueta = new Label();
        etiqueta.setFont(Font.font("Tahoma", FontWeight.BOLD, 50));

        etiqueta.setText("AlgoEmpires");
        etiqueta.setTextFill(Color.BLACK);

        BotonEntrarEventHandler botonEntrarHandler =  new BotonEntrarEventHandler(stage, proximaEscena);
        botonEntrar.setOnAction(botonEntrarHandler);

        box.getChildren().addAll(etiqueta, botonEntrar);

        return box;
    }
}
