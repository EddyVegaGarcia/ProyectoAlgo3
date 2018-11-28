package fiuba.algo3.tp2.vista;


import javafx.scene.control.*;
import javafx.stage.Stage;

public class BarraDeMenu extends MenuBar {

    public BarraDeMenu(Stage stage){
        Menu menuPrueba = new Menu("Algo Empires");


        MenuItem itemPrueba =  new MenuItem("itemPrueba");

        menuPrueba.getItems().addAll(itemPrueba);

        this.getMenus().addAll(menuPrueba);
    }
}
