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


public class ContenedorBienvenidos extends StackPane{

    Stage stage;

    public ContenedorBienvenidos(Stage stage, Scene proximaEscena) {

        super();

        this.stage = stage;
        this.setAlignment(Pos.CENTER);

        Image bgImage = new Image("file:src/fiuba/algo3/tp2/vista/imagenes/s.jpg");
        ImageView imageView = new ImageView();
        imageView.setImage(bgImage);
        imageView.setFitHeight(1080);
        imageView.setFitWidth(1920);
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


        Label etiqueta = new Label();
        etiqueta.setFont(Font.font("Tahoma", FontWeight.BOLD, 50));

        etiqueta.setText("Bienvenidos a Algo3Age of Empires");
        etiqueta.setTextFill(Color.WHITE);

        BotonEntrarEvenHandler botonEntrarHandler =  new BotonEntrarEvenHandler(stage, proximaEscena);
        botonEntrar.setOnAction(botonEntrarHandler);

        box.getChildren().addAll(etiqueta, botonEntrar);

        return box;
    }
}
