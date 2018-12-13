package fiuba.algo3.tp2.vista;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.awt.*;


public class Main extends Application {

    public static void main (String[] args) { launch(args); }

    @Override
    public void start(Stage stage) throws Exception {
        stage.setTitle("Algo3Age Of Empires");

        ContenedorPrincipal contenedorPrincipal = new ContenedorPrincipal(stage);

        Scene escenaJuego = new Scene(contenedorPrincipal);
        ContenedorBienvenidos contenedorBienvenidos = new ContenedorBienvenidos(stage, escenaJuego);

        Toolkit t = Toolkit.getDefaultToolkit();
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();

        Scene escenaBienvenidos = new Scene(contenedorBienvenidos, screenSize.width, screenSize.height);

        stage.setScene(escenaBienvenidos);
        stage.show();
    }

}
